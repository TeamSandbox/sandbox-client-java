package in.co.sandbox.api.client.tds;

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
 * The Class Reporting.
 */
public class TDSReportingClient extends RestClient
{

	/**
	 * Instantiates a new reporting.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public TDSReportingClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Prepare TDS return.
	 *
	 * @param form
	 *            the form
	 * @param tan
	 *            the tan
	 * @param formType
	 *            the form type
	 * @param quarter
	 *            the quarter
	 * @param financialYear
	 *            the financial year
	 * @param previous_rrr_number
	 *            the previous rrr number
	 * @param filing_type
	 *            the filing type
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject prepareTDSReturn(final JSONObject form, final String tan, final String formType,
	        final String quarter, final String financialYear, final String previous_rrr_number,
	        final String filing_type) throws SandboxException
	{

		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.TDS_REPORTING_SUBMIT_JOB,
			        Environment.get(sessionCredentials.getApiKey()), tan, formType, quarter, financialYear,
			        previous_rrr_number, filing_type), form);

			return response.get("job");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}
	}

	/**
	 * Gets the return job status.
	 *
	 * @param tan
	 *            the tan
	 * @param form
	 *            the form
	 * @param jobId
	 *            the job id
	 * @param quarter
	 *            the quarter
	 * @param financial_year
	 *            the financial year
	 * @return the return job status
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getReturnJobStatus(final String tan, final String form, final String jobId, final String quarter,
	        final String financial_year) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.TDS_REPORTING_POLL_JOB,
			        Environment.get(sessionCredentials.getApiKey()), tan, form, jobId, quarter, financial_year));

			return response.get("job");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}
	}
}
