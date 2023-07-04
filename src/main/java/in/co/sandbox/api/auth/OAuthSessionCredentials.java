/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */

package in.co.sandbox.api.auth;

// TODO: Auto-generated Javadoc
/**
 * The Class OAuthSessionCredentials.
 */
public class OAuthSessionCredentials extends ApiSessionCredentials
{

	/** The resource owner token. */
	protected String resourceOwnerToken;

	/**
	 * Instantiates a new o auth session credentials.
	 *
	 * @param apiKey
	 *            the api key
	 * @param apiUserToken
	 *            the api user token
	 * @param resourceOwnerToken
	 *            the resource owner token
	 */
	public OAuthSessionCredentials(final String apiKey, final String apiUserToken, final String resourceOwnerToken)
	{
		super(apiKey, apiUserToken);

		this.resourceOwnerToken = resourceOwnerToken;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getApiKey()
	{
		return this.apiKey;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OAuthSessionCredentials withAccessToken(final String accessToken)
	{
		this.resourceOwnerToken = accessToken;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAccessToken()
	{
		return this.resourceOwnerToken;
	}

	/**
	 * With api user token.
	 *
	 * @param apiUserToken
	 *            the api user token
	 * @return the o auth session credentials
	 */
	public OAuthSessionCredentials withApiUserToken(final String apiUserToken)
	{
		super.withAccessToken(apiUserToken);

		return this;
	}

	/**
	 * Gets the api user token.
	 *
	 * @return the api user token
	 */
	public String getApiUserToken()
	{
		return super.getAccessToken();
	}
}
