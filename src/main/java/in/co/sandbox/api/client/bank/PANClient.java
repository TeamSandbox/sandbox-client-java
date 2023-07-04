/**
 * Copyright Jun 10, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.client.bank;

import java.io.IOException;

import org.json.JSONObject;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.beans.ApiResponse;
import in.co.sandbox.api.beans.PAN;
import in.co.sandbox.api.client.RestClient;
import in.co.sandbox.api.exception.SandboxException;
import in.co.sandbox.api.types.ENDPOINTS;
import in.co.sandbox.api.types.ENDPOINTS.Environment;

// TODO: Auto-generated Javadoc
/**
 * The Class PANClient.
 */
public class PANClient extends RestClient
{

	/**
	 * Instantiates a new PAN client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public PANClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Verify.
	 *
	 * @param pan
	 *            the pan
	 * @param consent
	 *            the consent
	 * @param reason
	 *            the reason
	 * @return the pan
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public PAN get(final JSONObject body) throws SandboxException
	{
		try
		{
			ApiResponse response = super.postForGet(
			        ENDPOINTS.build(ENDPOINTS.URL.GET_PAN, Environment.get(sessionCredentials.getApiKey())), body);

			return new PAN(response.get("data"));
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}
	}

	/**
	 * Get.
	 *
	 * @param pan
	 *            the pan
	 * @param consent
	 *            the consent
	 * @param reason
	 *            the reason
	 * @return the pan
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public PAN verify(final String pan, final String consent, final String reason) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.VERIFY_PAN,
			        Environment.get(sessionCredentials.getApiKey()), pan, consent, reason));

			return new PAN(response.get("data"));
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}

	/**
	 * Gets the aadhar link status.
	 *
	 * @param pan
	 *            the pan
	 * @param aadharNumber
	 *            the aadhar number
	 * @return the aadhar link status
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAadharLinkStatus(final String pan, final String aadharNumber) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GET_PAN_AADHAAR_LINK_STATUS,
			        Environment.get(sessionCredentials.getApiKey()), pan, aadharNumber));

			return response.get("data");
		}
		catch (IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}

}
