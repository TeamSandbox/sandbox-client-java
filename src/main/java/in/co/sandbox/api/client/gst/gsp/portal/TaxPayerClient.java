/**
 * Copyright Aug 20, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.client.gst.gsp.portal;

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
 * The Class TaxPayerClient.
 */
public class TaxPayerClient extends RestClient
{

	/**
	 * Instantiates a new tax payer client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public TaxPayerClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Generate otp.
	 *
	 * @param gstin
	 *            the gstin
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject generateOtp(final String gstin) throws SandboxException
	{
		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GST_PORTAL_GENERATE_OTP,
			        Environment.get(sessionCredentials.getApiKey()), gstin), null);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}

	}

	/**
	 * Verify otp.
	 *
	 * @param gstin
	 *            the gstin
	 * @param otp
	 *            the otp
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject verifyOtp(final String gstin, final String otp) throws SandboxException
	{
		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GST_PORTAL_VERIFY_OTP,
			        Environment.get(sessionCredentials.getApiKey()), gstin, otp), null);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}

	}

}
