/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.auth;

// TODO: Auto-generated Javadoc
/**
 * The Class ApiSessionCredentials.
 */
public class ApiSessionCredentials
{

	/** The api key. */
	protected String apiKey;

	/** The access token. */
	protected String accessToken;

	/**
	 * Instantiates a new api session credentials.
	 *
	 * @param apiKey
	 *            the api key
	 * @param accessToken
	 *            the access token
	 */
	public ApiSessionCredentials(final String apiKey, final String accessToken)
	{
		this.apiKey = apiKey;

		this.accessToken = accessToken;
	}

	/**
	 * Gets the api key.
	 *
	 * @return the api key
	 */
	public String getApiKey()
	{
		return this.apiKey;
	}

	/**
	 * With api key.
	 *
	 * @param apiKey
	 *            the api key
	 * @return the quicko credentials
	 */
	public ApiSessionCredentials withApiKey(final String apiKey)
	{
		this.apiKey = apiKey;

		return this;
	}

	/**
	 * Gets the access token.
	 *
	 * @return the access token
	 */
	public String getAccessToken()
	{
		return this.accessToken;
	}

	/**
	 * With access token.
	 *
	 * @param accessToken
	 *            the access token
	 * @return the quicko credentials
	 */
	public ApiSessionCredentials withAccessToken(final String accessToken)
	{
		this.accessToken = accessToken;

		return this;
	}

}
