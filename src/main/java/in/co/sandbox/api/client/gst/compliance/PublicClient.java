/**
 * Copyright Sep 27, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.client.gst.compliance;

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
 * The Class PublicClient.
 */
public class PublicClient extends RestClient
{

	/**
	 * Instantiates a new public client.
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
	 * Track GST return.
	 *
	 * @param gstin
	 *            the gstin
	 * @param financialYear
	 *            the financial year
	 * @param gstr
	 *            the gstr
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject trackGSTReturn(final String gstin, final String financialYear, final String gstr)
	        throws SandboxException
	{

		try
		{
			JSONObject body = new JSONObject();

			body.put("gstin", gstin);

			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.TRACK_GST_RETURN,
			        Environment.get(sessionCredentials.getApiKey()), financialYear, gstr), body);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}

	/**
	 * Search gstin.
	 *
	 * @param gstin
	 *            the gstin
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject searchGstin(final String gstin) throws SandboxException
	{

		try
		{
			JSONObject body = new JSONObject();

			body.put("gstin", gstin);

			ApiResponse response = super.postForGet(
			        ENDPOINTS.build(ENDPOINTS.URL.SEARCH_GSTIN, Environment.get(sessionCredentials.getApiKey())), body);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}

	/**
	 * Search gstin by pan.
	 *
	 * @param <T>
	 *            the generic type
	 * @param pan
	 *            the pan
	 * @param stateCode
	 *            the state code
	 * @return the t
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public <T> T searchGstinByPan(final String pan, final String stateCode) throws SandboxException
	{

		try
		{
			JSONObject body = new JSONObject();

			body.put("pan", pan);

			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.SEARCH_GSTIN_BY_PAN,
			        Environment.get(sessionCredentials.getApiKey()), stateCode), body);

			return response.get("data");

		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}
}
