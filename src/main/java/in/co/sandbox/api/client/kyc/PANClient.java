/**
 * Copyright Jun 10, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.client.kyc;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
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
	 * Verify PAN.
	 *
	 * @param pan
	 *            the pan
	 * @param nameAsPerPan
	 *            the name as per pan
	 * @param dateOfBirth
	 *            the date of birth
	 * @param consent
	 *            the consent
	 * @param reason
	 *            the reason
	 * @return the pan
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public PAN verify(final String pan, final String nameAsPerPan, final DateTime dateOfBirth, final String consent,
	        final String reason) throws SandboxException
	{

		try
		{
			JSONObject body = new JSONObject();

			body.put("@entity", "in.co.sandbox.kyc.pan_verification.request");
			body.put("pan", pan);
			body.put("name_as_per_pan", pan);
			body.put("date_of_birth", DateTimeFormat.forPattern("dd/MM/yyyy")
			        .withZone(DateTimeZone.forID("Asia/Kolkata")).print(dateOfBirth));
			body.put("consent", consent);
			body.put("reason", reason);

			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.VERIFY_PAN,
			        Environment.get(sessionCredentials.getApiKey()), pan, consent, reason), body);

			return new PAN(response.get("data"));
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}

	/**
	 * Gets the aadhaar link status.
	 *
	 * @param pan
	 *            the pan
	 * @param aadhaarNumber
	 *            the aadhaar number
	 * @return the aadhaar link status
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAadhaarLinkStatus(final String pan, final String aadhaarNumber) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GET_PAN_AADHAAR_LINK_STATUS,
			        Environment.get(sessionCredentials.getApiKey()), pan, aadhaarNumber));

			return response.get("data");
		}
		catch (IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}

}
