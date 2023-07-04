package in.co.sandbox.api.client.tds.compliance;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.beans.ApiResponse;
import in.co.sandbox.api.client.RestClient;
import in.co.sandbox.api.exception.SandboxException;
import in.co.sandbox.api.types.ENDPOINTS;
import in.co.sandbox.api.types.ENDPOINTS.Environment;

// TODO: Auto-generated Javadoc
/**
 * The Class ITRP.
 */
public class ITRPClient extends RestClient
{

	/**
	 * Instantiates a new TDS compliance client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public ITRPClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Check specified sync.
	 *
	 * @param pan
	 *            the pan
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject complianceCheckSync(final String pan) throws SandboxException
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

	/**
	 * Check specified async.
	 *
	 * @param pans
	 *            the pans
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject submitJob(final String[] pans) throws SandboxException
	{
		try
		{
			ApiResponse response =
			        super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.SECTION_206AB_206CC_COMPLIANCE_CHECK_ASYNC,
			                Environment.get(sessionCredentials.getApiKey())), new JSONArray(pans));

			return response.get("job");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}
	}

	/**
	 * Gets the job status.
	 *
	 * @param jobId
	 *            the job id
	 * @return the job status
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject pollJob(final String jobId) throws SandboxException
	{

		try
		{
			ApiResponse response =
			        super.get(ENDPOINTS.build(ENDPOINTS.URL.SECTION_206AB_206CC_COMPLIANCE_CHECK_ASYNC_POLL_JOB,
			                Environment.get(sessionCredentials.getApiKey()), jobId));

			return response.get("job");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}
	}
}
