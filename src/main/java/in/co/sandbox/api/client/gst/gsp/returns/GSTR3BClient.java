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
 * The Class GSTR3BClient.
 */
public class GSTR3BClient extends RestClient
{

	/**
	 * Instantiates a new GSTR 3 B client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public GSTR3BClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Save.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param body
	 *            the body
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject save(final String gstin, final String year, final String month, final JSONObject body)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GSTR3B_SAVE,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month), body);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Summary.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getSummary(final String gstin, final String year, final String month) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR3B_SUMMARY,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * File.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param pan
	 *            the pan
	 * @param otp
	 *            the otp
	 * @param body
	 *            the body
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject file(final String gstin, final String year, final String month, final String pan,
	        final String otp, final JSONObject body) throws SandboxException
	{
		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GSTR3B_FILE,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, pan, otp), body);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}
}
