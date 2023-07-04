package in.co.sandbox.api.client.gst.gsp;

import java.io.IOException;

import org.json.JSONObject;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.beans.ApiResponse;
import in.co.sandbox.api.client.RestClient;
import in.co.sandbox.api.client.gst.gsp.returns.GSTR1Client;
import in.co.sandbox.api.client.gst.gsp.returns.GSTR2AClient;
import in.co.sandbox.api.client.gst.gsp.returns.GSTR2BClient;
import in.co.sandbox.api.client.gst.gsp.returns.GSTR3BClient;
import in.co.sandbox.api.exception.SandboxException;
import in.co.sandbox.api.types.ENDPOINTS;
import in.co.sandbox.api.types.ENDPOINTS.Environment;

// TODO: Auto-generated Javadoc
/**
 * The Class ReturnsClient.
 */
public class ReturnsClient extends RestClient
{

	/** The gstr1. */
	public GSTR1Client GSTR1;

	/** The gstr2a. */
	public GSTR2AClient GSTR2A;

	/** The gstr2b. */
	public GSTR2BClient GSTR2B;

	/** The gstr3b. */
	public GSTR3BClient GSTR3B;

	/**
	 * Instantiates a new returns client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public ReturnsClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);

		this.GSTR1 = new GSTR1Client(sessionCredentials, enableDebugLog);

		this.GSTR2A = new GSTR2AClient(sessionCredentials, enableDebugLog);

		this.GSTR2B = new GSTR2BClient(sessionCredentials, enableDebugLog);

		this.GSTR3B = new GSTR3BClient(sessionCredentials, enableDebugLog);
	}

	/**
	 * Proceed to file.
	 *
	 * @param gstin
	 *            the gstin
	 * @param gstr
	 *            the gstr
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param is_nil
	 *            the is nil
	 * @param body
	 *            the body
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject proceedToFile(final String gstin, final String gstr, final String year, final String month,
	        final String is_nil, final JSONObject body) throws SandboxException
	{
		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GST_PROCEED_TO_FILE,
			        Environment.get(sessionCredentials.getApiKey()), gstin, gstr, year, month, is_nil), body);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the return status.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param reference_id
	 *            the reference id
	 * @return the return status
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getReturnStatus(final String gstin, final String year, final String month,
	        final String reference_id) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GST_GET_RETURN_STATUS,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, reference_id));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

}
