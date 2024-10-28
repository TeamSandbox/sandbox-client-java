/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */

package in.co.sandbox.api.client;

import com.auth0.jwt.JWT;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.auth.ApiUserCredentials;
import in.co.sandbox.api.auth.OAuthSessionCredentials;
import in.co.sandbox.api.beans.ApiResponse;
import in.co.sandbox.api.exception.SandboxException;
import in.co.sandbox.api.mapper.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class RestClient.
 */
public abstract class RestClient
{

	/** The session credentials. */
	protected ApiSessionCredentials sessionCredentials;

	/** The user agent. */
	protected String USER_AGENT = "java/api-core/1.0.0";

	/** The api version. */
	protected String API_VERSION = "1.0.0";

	/** The client. */
	protected OkHttpClient client;

	/** The enable logging. */
	public static boolean ENABLE_LOGGING = false;

	/** The mapper. */
	protected ObjectMapper mapper;

	/**
	 * Instantiates a new rest client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 */
	public RestClient(final ApiSessionCredentials sessionCredentials)
	{
		this(sessionCredentials, true);
	}

	/**
	 * Instantiates a new rest client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public RestClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{

		this.sessionCredentials = sessionCredentials;

		this.mapper = new ObjectMapper();

		final OkHttpClient.Builder builder = new OkHttpClient.Builder();

		final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

		logging.setLevel(HttpLoggingInterceptor.Level.BODY);

		final RequestInterceptor requestInterceptor = new RequestInterceptor();

		final ResponseInterceptor responseInterceptor = new ResponseInterceptor();

		if (enableDebugLog)
		{
			this.client = builder.connectTimeout(1, TimeUnit.MINUTES).readTimeout(1, TimeUnit.MINUTES)
			        .writeTimeout(1, TimeUnit.MINUTES).addInterceptor(logging).addInterceptor(requestInterceptor)
			        .addInterceptor(responseInterceptor).build();
		}
		else
		{
			this.client = builder.connectTimeout(1, TimeUnit.MINUTES).readTimeout(1, TimeUnit.MINUTES)
			        .addInterceptor(requestInterceptor).addInterceptor(responseInterceptor)
			        .writeTimeout(1, TimeUnit.MINUTES).build();
		}

		ENABLE_LOGGING = enableDebugLog;

	}

	/**
	 * Post for get.
	 *
	 * @param url
	 *            the url
	 * @param object
	 *            the object
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected ApiResponse postForGet(final String url, final Object object) throws SandboxException, IOException
	{

		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

		final RequestBody requestBody = RequestBody.create(object != null ? object.toString() : "", JSON);

		final Request request = new Request.Builder().url(url).post(requestBody).header("User-Agent", this.USER_AGENT)
		        .header("x-api-version", this.API_VERSION).header("x-api-key", this.sessionCredentials.getApiKey())
		        .header("Authorization", this.sessionCredentials.getAccessToken()).build();

		final Response response = this.client.newCall(request).execute();

		final String body = response.body().string();

		if (response.header("Content-Type").contains("json"))
		{
			final ApiResponse apiResponse = new ApiResponse(new JSONObject(body));

			if (apiResponse.isError())
			{
				throw mapper.readValue(apiResponse.toString(), SandboxException.class);
			}

			return apiResponse;
		}
		else
		{
			throw new SandboxException("Unexpected content type received from server: "
			        + response.header("Content-Type") + " " + response.body().string(), 502);
		}

	}

	/**
	 * Post.
	 *
	 * @param url
	 *            the url
	 * @param object
	 *            the object
	 * @throws SandboxException
	 *             the sandbox exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected void post(final String url, final Object object) throws SandboxException, IOException
	{

		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

		final RequestBody requestBody = RequestBody.create(object != null ? object.toString() : "", JSON);

		final Request request = new Request.Builder().url(url).post(requestBody).header("User-Agent", this.USER_AGENT)
		        .header("x-api-version", this.API_VERSION).header("x-api-key", this.sessionCredentials.getApiKey())
		        .header("Authorization", this.sessionCredentials.getAccessToken()).build();

		final Response response = this.client.newCall(request).execute();

		final String body = response.body().string();

		final ApiResponse apiResponse = new ApiResponse(new JSONObject(body));

		if (apiResponse.isError())
		{
			throw mapper.readValue(apiResponse.toString(), SandboxException.class);
		}

	}

	/**
	 * Get.
	 *
	 * @param url
	 *            the url
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected ApiResponse get(final String url) throws SandboxException, IOException
	{

		final HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

		final Request request = new Request.Builder().url(httpBuilder.build()).header("User-Agent", this.USER_AGENT)
		        .header("x-api-version", this.API_VERSION).header("x-api-key", this.sessionCredentials.getApiKey())
		        .header("Authorization", this.sessionCredentials.getAccessToken()).build();

		final Response response = this.client.newCall(request).execute();

		final String body = response.body().string();

		if (response.header("Content-Type").contains("json"))
		{
			final ApiResponse apiResponse = new ApiResponse(new JSONObject(body));

			if (apiResponse.isError())
			{
				throw mapper.readValue(apiResponse.toString(), SandboxException.class);
			}

			return apiResponse;
		}
		else
		{
			throw new SandboxException("Unexpected content type received from server: "
			        + response.header("Content-Type") + " " + response.body().string(), 502);
		}

	}

	/**
	 * Delete.
	 *
	 * @param url
	 *            the url
	 * @throws SandboxException
	 *             the sandbox exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected void delete(final String url) throws SandboxException, IOException
	{

		final Request request = new Request.Builder().url(url).delete().header("User-Agent", this.USER_AGENT)
		        .header("x-api-version", this.API_VERSION).header("x-api-key", this.sessionCredentials.getApiKey())
		        .header("Authorization", this.sessionCredentials.getAccessToken()).build();

		final Response response = this.client.newCall(request).execute();

		final String body = response.body().string();

		if (response.header("Content-Type").contains("json"))
		{
			final ApiResponse apiResponse = new ApiResponse(new JSONObject(body));

			if (apiResponse.isError())
			{
				throw mapper.readValue(apiResponse.toString(), SandboxException.class);
			}

		}
	}

	/**
	 * Gets the all.
	 *
	 * @param url
	 *            the url
	 * @return the all
	 * @throws SandboxException
	 *             the sandbox exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected ApiResponse getAll(final String url) throws SandboxException, IOException
	{
		final HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

		final Request request = new Request.Builder().url(httpBuilder.build()).header("User-Agent", this.USER_AGENT)
		        .header("x-api-version", this.API_VERSION).header("x-api-key", this.sessionCredentials.getApiKey())
		        .header("Authorization", this.sessionCredentials.getAccessToken()).build();

		final Response response = this.client.newCall(request).execute();

		final String body = response.body().string();

		if (response.header("Content-Type").contains("json"))
		{
			final ApiResponse apiResponse = new ApiResponse(new JSONObject(body));

			if (apiResponse.isError())
			{
				throw mapper.readValue(apiResponse.toString(), SandboxException.class);
			}

			return apiResponse;

		}
		else
		{
			throw new SandboxException("Unexpected content type received from server: "
			        + response.header("Content-Type") + " " + response.body().string(), 502);
		}

	}

	/**
	 * The Class RequestInterceptor.
	 */
	class RequestInterceptor implements Interceptor
	{

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Response intercept(final Interceptor.Chain chain) throws IOException
		{
			final Request request = chain.request();

			if (JWT.decode(request.header("Authorization")).getExpiresAt().before(new Date()))
			{
				try
				{
					if (RestClient.this.sessionCredentials.getClass().equals(ApiSessionCredentials.class))
					{
						RestClient.this.sessionCredentials.withAccessToken(ApiClientBuilder.basic()
						        .withCredentials(new ApiUserCredentials(sessionCredentials.getApiKey(), null))
						        .authorize(RestClient.this.sessionCredentials.getAccessToken()));
					}
					else if (RestClient.this.sessionCredentials.getClass().equals(OAuthSessionCredentials.class))
					{
						RestClient.this.sessionCredentials.withAccessToken(ApiClientBuilder.basic()
						        .withCredentials(new ApiUserCredentials(sessionCredentials.getApiKey(), null))
						        .authorize(
						                ((OAuthSessionCredentials) RestClient.this.sessionCredentials)
						                        .getApiUserToken(),
						                RestClient.this.sessionCredentials.getAccessToken()));
					}

				}
				catch (final SandboxException e)
				{
					// Ignore
				}

			}

			final Response response = chain
			        .proceed(request.newBuilder().header("Authorization", sessionCredentials.getAccessToken()).build());

			return response;
		}
	}

	/**
	 * The Class ResponseInterceptor.
	 */
	class ResponseInterceptor implements Interceptor
	{

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Response intercept(final Interceptor.Chain chain) throws IOException
		{
			final Request request = chain.request();

			final Response response = chain.proceed(request);

			switch (response.code())
			{
				case 403:

					JSONObject responseJSON = new JSONObject(response.body().string());

					switch (responseJSON.get("message").toString())
					{

						case "Invalid access token":
						case "Access token has expired":
							try
							{

								// Refresh access token
								if (RestClient.this.sessionCredentials.getClass().equals(ApiSessionCredentials.class))
								{
									RestClient.this.sessionCredentials.withAccessToken(ApiClientBuilder.basic()
									        .withCredentials(
									                new ApiUserCredentials(sessionCredentials.getApiKey(), null))
									        .authorize(RestClient.this.sessionCredentials.getAccessToken()));
								}
								else if (RestClient.this.sessionCredentials.getClass()
								        .equals(OAuthSessionCredentials.class))
								{
									RestClient.this.sessionCredentials.withAccessToken(ApiClientBuilder.basic()
									        .withCredentials(
									                new ApiUserCredentials(sessionCredentials.getApiKey(), null))
									        .authorize(
									                ((OAuthSessionCredentials) RestClient.this.sessionCredentials)
									                        .getApiUserToken(),
									                RestClient.this.sessionCredentials.getAccessToken()));
								}

								// Retry
								final Response retryResponse = chain.proceed(request.newBuilder()
								        .header("Authorization", sessionCredentials.getAccessToken()).build());

								// return expected response
								return retryResponse;

							}
							catch (final SandboxException e)
							{
								// Failed to refresh access token; continue

								ResponseBody body = ResponseBody.create(responseJSON.toString(),
								        MediaType.parse("application/json"));

								Response responseObject = response.newBuilder().body(body).build();

								return responseObject;
							}

						default:

							ResponseBody body =
							        ResponseBody.create(responseJSON.toString(), MediaType.parse("application/json"));

							Response responseObject = response.newBuilder().body(body).build();

							return responseObject;

					}

				default:
					break;

			}

			return response;
		}
	}

}
