/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */

package in.co.sandbox.api.client;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.auth.ApiUserCredentials;
import in.co.sandbox.api.auth.OAuthSessionCredentials;
import in.co.sandbox.api.exception.SandboxException;
import in.co.sandbox.api.types.ENDPOINTS;
import in.co.sandbox.api.types.ENDPOINTS.Environment;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class ApiClientBuilder.
 */
public final class ApiClientBuilder
{

	/** The api user credentials. */
	private static ApiUserCredentials apiUserCredentials;

	/** The client. */
	private static OkHttpClient client;

	/** The user agent. */
	private static String USER_AGENT = "java/api-core/1.0.0";

	/** The api version. */
	private static String API_VERSION = "1.0.0";

	static
	{

		final OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)
		        .readTimeout(1, TimeUnit.MINUTES).writeTimeout(1, TimeUnit.MINUTES);

		final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

		logging.setLevel(HttpLoggingInterceptor.Level.BODY);

		if (RestClient.ENABLE_LOGGING)
		{
			client = builder.addInterceptor(logging).build();
		}
		else
		{
			client = builder.build();
		}

	}

	/**
	 * Instantiates a new api client builder.
	 */
	private ApiClientBuilder()
	{
		super();
	}

	/**
	 * Basic.
	 *
	 * @return the api client builder
	 */

	public static ApiClientBuilder basic()
	{
		return new ApiClientBuilder();
	}

	/**
	 * Build ApiClient to access resources on server for api user.
	 *
	 * @return the api client
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public ApiClient build() throws SandboxException
	{
		return this.build(false);
	}

	/**
	 * Builds the.
	 *
	 * @param enableDebugLog
	 *            the enable debug log
	 * @return the api client
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public ApiClient build(final boolean enableDebugLog) throws SandboxException
	{

		/* Initialize using API User credentials */
		if (apiUserCredentials.getApiKey() != null && apiUserCredentials.getApiSecret() != null)
		{
			final ApiSessionCredentials sessionCredentials =
			        new ApiSessionCredentials(apiUserCredentials.getApiKey(), this.authenticate());

			if (sessionCredentials.getAccessToken() != null)
			{
				final ApiClient apiClient = new ApiClient(sessionCredentials, enableDebugLog);

				return apiClient;
			}

			throw new SandboxException("Unable to build client without access token");

		}

		throw new SandboxException("Unable to build client without api key & secret");

	}

	/**
	 * Build ApiClient to access resources on server on behalf of resource owner.
	 *
	 * @param accessToken
	 *            the access token
	 * @return the api client
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public ApiClient build(final String accessToken) throws SandboxException
	{
		return build(accessToken, true);
	}

	/**
	 * Builds the.
	 *
	 * @param accessToken
	 *            the access token
	 * @param enableDebugLog
	 *            the enable debug log
	 * @return the api client
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public ApiClient build(final String accessToken, final boolean enableDebugLog) throws SandboxException
	{

		/* Initialize using Resource Owner credentials */
		if (apiUserCredentials.getApiKey() != null && apiUserCredentials.getApiSecret() != null)
		{
			if (accessToken != null)
			{

				/* Authenticate using API User credentials */
				final ApiSessionCredentials sessionCredentials =
				        new OAuthSessionCredentials(apiUserCredentials.getApiKey(), this.authenticate(), accessToken);

				if (sessionCredentials.getAccessToken() != null)
				{
					if (sessionCredentials.getAccessToken() != null)
					{

						final ApiClient apiClient = new ApiClient(sessionCredentials, enableDebugLog);

						return apiClient;
					}
					throw new SandboxException("Invalid session: Unauthorized Resource Owner");
				}

				throw new SandboxException("Invalid session: Unauthorized API User");

			}

			throw new SandboxException("Unable to build client without resource owner access token");
		}

		throw new SandboxException("Unable to build client without api key & secret");

	}

	/**
	 * With credentials.
	 *
	 * @param credentials
	 *            the credentials
	 * @return the api client builder
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public ApiClientBuilder withCredentials(final ApiUserCredentials credentials) throws SandboxException
	{

		apiUserCredentials = credentials;

		return this;
	}

	/**
	 * Authenticate.
	 *
	 * @return the string
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public String authenticate() throws SandboxException
	{
		try
		{

			final FormBody.Builder builder = new FormBody.Builder();

			final RequestBody requestBody = builder.build();

			final Request request = new Request.Builder()
			        .url(ENDPOINTS.build(ENDPOINTS.URL.AUTHENTICATE, Environment.get(apiUserCredentials.getApiKey())))
			        .post(requestBody).header("User-Agent", USER_AGENT)
			        .header("x-api-key", apiUserCredentials.getApiKey())
			        .header("x-api-secret", apiUserCredentials.getApiSecret()).header("x-api-version", API_VERSION)
			        .build();

			final Response response = client.newCall(request).execute();

			if (response.header("Content-Type").contains("json"))
			{
				final JSONObject jsonObject = new JSONObject(response.body().string());

				if (response.code() != 200)
				{
					throw new SandboxException(jsonObject.get("message").toString(), response.code());
				}

				return jsonObject.get("access_token").toString();
			}
			else
			{
				throw new SandboxException("Unexpected content type received from server: "
				        + response.header("Content-Type") + " " + response.body().string(), 502);
			}
		}
		catch (final IOException ioE)
		{
			throw new SandboxException("Network call failed", 422, ioE);
		}
	}

	/**
	 * Authorize.
	 *
	 * @param requestToken
	 *            the request token
	 * @return the string
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	protected final String authorize(final String requestToken) throws SandboxException
	{
		try
		{
			final FormBody.Builder builder = new FormBody.Builder();

			final RequestBody requestBody = builder.build();

			final Request request = new Request.Builder()
			        .url(ENDPOINTS.build(ENDPOINTS.URL.AUTHORIZE, Environment.get(apiUserCredentials.getApiKey()),
			                requestToken))
			        .post(requestBody).header("User-Agent", USER_AGENT)
			        .header("x-api-key", apiUserCredentials.getApiKey()).header("Authorization", requestToken)
			        .header("x-api-version", API_VERSION).build();

			final Response response = client.newCall(request).execute();

			if (response.header("Content-Type").contains("json"))
			{

				final JSONObject jsonObject = new JSONObject(response.body().string());

				if (response.code() != 200)
				{
					throw new SandboxException(jsonObject.get("message").toString(), response.code());
				}

				return jsonObject.get("access_token").toString();
			}
			else
			{
				throw new SandboxException("Unexpected content type received from server: "
				        + response.header("Content-Type") + " " + response.body().string(), 502);
			}
		}
		catch (final IOException ioE)
		{
			throw new SandboxException("Network call failed", 422, ioE);
		}
	}

	/**
	 * Authorize.
	 *
	 * @param accessToken
	 *            the access token
	 * @param requestToken
	 *            the request token
	 * @return the string
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	protected final String authorize(String accessToken, final String requestToken) throws SandboxException
	{
		try
		{
			final FormBody.Builder builder = new FormBody.Builder();

			final RequestBody requestBody = builder.build();

			final Request request = new Request.Builder()
			        .url(ENDPOINTS.build(ENDPOINTS.URL.OAUTH_AUTHORIZE, Environment.get(apiUserCredentials.getApiKey()),
			                requestToken))
			        .post(requestBody).header("User-Agent", USER_AGENT)
			        .header("x-api-key", apiUserCredentials.getApiKey()).header("Authorization", accessToken)
			        .header("x-api-version", API_VERSION).build();

			final Response response = client.newCall(request).execute();

			if (response.code() == 200)
			{
				if (response.header("Content-Type").contains("json"))
				{
					final JSONObject jsonObject = new JSONObject(response.body().string());

					return jsonObject.get("access_token").toString();
				}
				else
				{
					throw new SandboxException("Unexpected content type received from server: "
					        + response.header("Content-Type") + " " + response.body().string(), 502);
				}
			}
			else if (response.code() == 403)
			{

				// re-authorize API User
				accessToken = this.authorize(accessToken);

				// re-authorize Resource Owner
				return this.authorize(accessToken, requestToken);

			}

			throw new SandboxException("Internal Server Error");

		}
		catch (final IOException ioE)
		{
			throw new SandboxException("Network call failed", 422, ioE);
		}
	}

}
