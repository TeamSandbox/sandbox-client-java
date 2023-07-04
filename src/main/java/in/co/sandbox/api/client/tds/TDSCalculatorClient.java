/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Manav Darji
 */
package in.co.sandbox.api.client.tds;

import java.io.IOException;
import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONObject;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.beans.ApiResponse;
import in.co.sandbox.api.client.RestClient;
import in.co.sandbox.api.exception.SandboxException;
import in.co.sandbox.api.types.ENDPOINTS;
import in.co.sandbox.api.types.ENDPOINTS.Environment;

// TODO: Auto-generated Javadoc
/**
 * The Class TDSCalculatorClient.
 */
public class TDSCalculatorClient extends RestClient
{

	/**
	 * Instantiates a new TDS calculator client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public TDSCalculatorClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);

	}

	/**
	 * Calculate tds.
	 *
	 * @param deducteeType
	 *            the deductee type
	 * @param isPanAvailable
	 *            the is pan available
	 * @param residentialStatus
	 *            the residential status
	 * @param section
	 *            the section
	 * @param creditAmount
	 *            the credit amount
	 * @param creditDate
	 *            the credit date
	 * @return the api response
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject calculateTds(final String deducteeType, final Boolean isPanAvailable,
	        final String residentialStatus, final String section, final BigDecimal creditAmount,
	        final DateTime creditDate) throws SandboxException
	{

		JSONObject request = new JSONObject();

		request.put("deductee_type", deducteeType);
		request.put("is_pan_available", isPanAvailable.booleanValue() == true ? "Y" : "N");
		request.put("residential_status", residentialStatus);
		request.put("section", section);
		request.put("credit_amount", creditAmount);
		request.put("credit_date",
		        DateTimeFormat.forPattern("dd/MM/yyyy").withZone(DateTimeZone.forID("Asia/Kolkata")).print(creditDate));

		try
		{
			ApiResponse response = super.postForGet(
			        ENDPOINTS.build(ENDPOINTS.URL.CALCULATE_TDS, Environment.get(sessionCredentials.getApiKey())),
			        request);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}

}
