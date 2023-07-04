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
 * The Class Traces.
 */
public class TracesClient extends RestClient
{

	/**
	 * Instantiates a new traces.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public TracesClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Authenticate.
	 *
	 * @param json
	 *            the json
	 * @param tan
	 *            the tan
	 * @param quarter
	 *            the quarter
	 * @param financialYear
	 *            the financial year
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject download16A(final JSONObject json, final String tan, final String quarter,
	        final String financialYear) throws SandboxException
	{
		if (json != null && tan != null && quarter != null && financialYear != null)
		{

			try
			{
				ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.TDS_COMPLIANCE_FORM16A_SUBMIT_JOB,
				        Environment.get(sessionCredentials.getApiKey()), tan, quarter, financialYear), json);

				return response.get("job");
			}
			catch (final IOException e)
			{
				throw new SandboxException("Internal Server Error", 500);
			}
		}
		else
		{
			throw new SandboxException("Missing Required parameters", 400);
		}
	}

	/**
	 * Gets the job status.
	 *
	 * @param tan
	 *            the tan
	 * @param jobId
	 *            the job id
	 * @return the job status
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getJobStatus(final String tan, final String jobId) throws SandboxException
	{
		if (tan != null && jobId != null)
		{

			try
			{
				ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.TDS_COMPLIANCE_FORM16A_POLL_JOB,
				        Environment.get(sessionCredentials.getApiKey()), tan, jobId));

				return response.get("job");
			}
			catch (final IOException e)
			{
				throw new SandboxException("Internal Server Error", 500);
			}
		}
		else
		{
			throw new SandboxException("Missing Required parameters", 400);
		}
	}

}
