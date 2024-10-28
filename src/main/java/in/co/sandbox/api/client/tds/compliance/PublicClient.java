package in.co.sandbox.api.client.tds.compliance;

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
 * The Class Public clientO.
 */
public class PublicClient extends RestClient
{

	/**
	 * Instantiates a new TDS compliance client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public PublicClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
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

	/**
	 * 206 AB and 206 CC Compliance Check.
	 *
	 * @param pan
	 *            the pan
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject complianceCheck(final String pan) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.SECTION_206AB_206CC_COMPLIANCE_CHECK_SYNC,
			        Environment.get(sessionCredentials.getApiKey()), pan));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}
	}
}
