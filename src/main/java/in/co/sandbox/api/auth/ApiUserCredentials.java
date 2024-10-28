/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.auth;

// TODO: Auto-generated Javadoc
/**
 * The Interface ApiUserCredentials.
 */
public class ApiUserCredentials
{

	/** The api key. */
	protected String apiKey;

	/** The api secret. */
	protected String apiSecret;

	/**
	 * Instantiates a new api user credentials.
	 *
	 * @param apiKey
	 *            the api key
	 * @param apiSecret
	 *            the api secret
	 */
	public ApiUserCredentials(final String apiKey, final String apiSecret)
	{
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
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
	 * Gets the api secret.
	 *
	 * @return the api secret
	 */
	public String getApiSecret()
	{
		return this.apiSecret;
	}

}
