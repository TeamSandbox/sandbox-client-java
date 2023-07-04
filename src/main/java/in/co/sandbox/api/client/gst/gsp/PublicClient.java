/**
 * Copyright Sep 27, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.client.gst.gsp;

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
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject trackGSTReturn(final String gstin, final String financialYear) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.TRACK_GST_RETURN,
			        Environment.get(sessionCredentials.getApiKey()), gstin, financialYear));
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
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.SEARCH_GSTIN,
			        Environment.get(sessionCredentials.getApiKey()), gstin));

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
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.SEARCH_GSTIN_BY_PAN,
			        Environment.get(sessionCredentials.getApiKey()), pan, stateCode));

			return response.get("data");

		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}

	/**
	 * Generate OTP.
	 *
	 * @param gstin
	 *            the gstin
	 * @param username
	 *            the username
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject generateOTP(final String gstin, final String username) throws SandboxException
	{
		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GST_GENERATE_OTP,
			        Environment.get(sessionCredentials.getApiKey()), gstin, username), null);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Verify OTP.
	 *
	 * @param gstin
	 *            the gstin
	 * @param username
	 *            the username
	 * @param otp
	 *            the otp
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject verifyOTP(final String gstin, final String username, final String otp) throws SandboxException
	{

		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GST_VERIFY_OTP,
			        Environment.get(sessionCredentials.getApiKey()), gstin, username, otp), null);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Session expiery.
	 *
	 * @param gstin
	 *            the gstin
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject sessionExpiry(final String gstin) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GST_SESSION_EXPIRY,
			        Environment.get(sessionCredentials.getApiKey()), gstin));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Referesh taxpayer access.
	 *
	 * @param gstin
	 *            the gstin
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject refereshTaxpayerAccess(final String gstin) throws SandboxException
	{

		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GST_REFERESH_TAXPAYER_ACCESS,
			        Environment.get(sessionCredentials.getApiKey()), gstin), null);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Taxpayer logout.
	 *
	 * @param gstin
	 *            the gstin
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject taxpayerLogout(final String gstin) throws SandboxException
	{

		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GST_TAXPAYER_LOGOUT,
			        Environment.get(sessionCredentials.getApiKey()), gstin), null);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}

	}

	/**
	 * Generate EVCOTP.
	 *
	 * @param gstin
	 *            the gstin
	 * @param gstr
	 *            the gstr
	 * @param pan
	 *            the pan
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject generateEVCOTP(final String gstin, final String gstr, final String pan) throws SandboxException
	{

		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GST_GENERATE_EVC_OTP,
			        Environment.get(sessionCredentials.getApiKey()), gstin, gstr, pan), null);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

}
