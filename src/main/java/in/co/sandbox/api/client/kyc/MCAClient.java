package in.co.sandbox.api.client.kyc;

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
 * The Class MCAClient.
 */
public class MCAClient extends RestClient
{

	/**
	 * Instantiates a new MCA client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public MCAClient(ApiSessionCredentials sessionCredentials, boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Gets the director master data.
	 *
	 * @param din
	 *            the din
	 * @param consent
	 *            the consent
	 * @param reason
	 *            the reason
	 * @return the director master data
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getDirectorMasterData(final String din, final String consent, final String reason)
	        throws SandboxException
	{
		try
		{
			JSONObject body = new JSONObject();

			body.put("@entity", "in.co.sandbox.kyc.mca.master_data.request");
			body.put("id", din);
			body.put("consent", consent);
			body.put("reason", reason);

			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.DIRECTOR_MASTER_DATA,
			        Environment.get(sessionCredentials.getApiKey())), body);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the company master data.
	 *
	 * @param id
	 *            the id
	 * @param consent
	 *            the consent
	 * @param reason
	 *            the reason
	 * @return the company master data
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getCompanyMasterData(final String id, final String consent, final String reason)
	        throws SandboxException
	{
		try
		{

			JSONObject body = new JSONObject();

			body.put("@entity", "in.co.sandbox.kyc.mca.master_data.request");
			body.put("id", id);
			body.put("consent", consent);
			body.put("reason", reason);

			ApiResponse response = super.postForGet(
			        ENDPOINTS.build(ENDPOINTS.URL.COMPANY_MASTER_DATA, Environment.get(sessionCredentials.getApiKey())),
			        body);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}
}
