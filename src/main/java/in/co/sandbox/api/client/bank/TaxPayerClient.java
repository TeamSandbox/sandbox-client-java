package in.co.sandbox.api.client.bank;

import java.io.IOException;

import org.json.JSONObject;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.beans.ApiResponse;
import in.co.sandbox.api.client.RestClient;
import in.co.sandbox.api.exception.SandboxException;
import in.co.sandbox.api.types.ENDPOINTS;
import in.co.sandbox.api.types.ENDPOINTS.Environment;

// TODO: Auto-generated Javadoc
/**
 * The Class TaxPayerClient.
 */
public class TaxPayerClient extends RestClient
{

	/**
	 * Instantiates a new tax payer client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public TaxPayerClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Search GSTIN.
	 *
	 * @param gstin
	 *            the gstin
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject searchGSTIN(final String gstin) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.SEARCH_GSTIN,
			        Environment.get(sessionCredentials.getApiKey()), gstin));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}
	}

	/**
	 * Search tan.
	 *
	 * @param tan
	 *            the tan
	 * @param consent
	 *            the consent
	 * @param reason
	 *            the reason
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject searchTan(final String tan, final String consent, final String reason) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.SEARCH_TAN,
			        Environment.get(sessionCredentials.getApiKey()), tan, consent, reason));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}
	}
}
