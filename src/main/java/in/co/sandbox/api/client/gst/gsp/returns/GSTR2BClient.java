package in.co.sandbox.api.client.gst.gsp.returns;

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
 * The Class GSTR2BClient.
 */
public class GSTR2BClient extends RestClient
{

	/**
	 * Instantiates a new GSTR 2 B client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public GSTR2BClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Gets the 2 B invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param file_number
	 *            the file number
	 * @return the 2 B invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getSummary(final String gstin, final String year, final String month, final String file_number)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR2B_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, file_number));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

}
