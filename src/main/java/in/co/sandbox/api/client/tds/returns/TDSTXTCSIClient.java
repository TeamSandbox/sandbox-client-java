package in.co.sandbox.api.client.tds.returns;

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
 * The Class TDSTxtCsi.
 */
public class TDSTXTCSIClient extends RestClient
{

	/**
	 * Instantiates a new TDS txt csi.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public TDSTXTCSIClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Submit job.
	 *
	 * @param tan
	 *            the tan
	 * @param form
	 *            the form
	 * @param financialYear
	 *            the financial year
	 * @param quarter
	 *            the quarter
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject submitJob(final String tan, final String form, final String quarter, final String financialYear)
	        throws SandboxException
	{

		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.TDS_E_FILE_USING_TXT_CSI,
			        Environment.get(sessionCredentials.getApiKey()), tan, form, quarter, financialYear), null);

			return response.get("job");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}
	}

	/**
	 * Poll job status.
	 *
	 * @param tan
	 *            the tan
	 * @param form
	 *            the form
	 * @param jobId
	 *            the job id
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject pollJob(final String tan, final String form, final String jobId) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.TDS_E_FILE_TXT_CSI_RETURN_POLL_JOB,
			        Environment.get(sessionCredentials.getApiKey()), tan, form, jobId));

			return response.get("job");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}
	}
}
