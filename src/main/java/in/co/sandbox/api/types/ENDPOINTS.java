/**
 * Copyright Aug 20, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.types;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.co.sandbox.api.utils.FilterUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class ENDPOINTS.
 */
public final class ENDPOINTS
{

	/**
	 * Build.
	 *
	 * @param endpoint
	 *            the endpoint
	 * @param env
	 *            the env
	 * @param args
	 *            arguments
	 * @return the string
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static String build(final URL endpoint, final Environment env, final Object... args)
	{
		String url = new StringBuilder().append(env.getHost()).append(endpoint.getValue()).toString();

		String regex = "\\{(\\w*)\\}";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher;

		int i = 0;

		do
		{
			matcher = pattern.matcher(url);

			if (matcher.find())
			{
				url = url.replace(matcher.group(0),
				        args != null && args.length > i && args[i] != null && !args[i].toString().isEmpty()
				                ? (args[i] instanceof List || args[i] instanceof String[]
				                        ? FilterUtils.listToCSV((List) args[i])
				                        : args[i].toString())
				                : "");
			}

			i++;

		}
		while (matcher.find());

		return url.toString();

	}

	/**
	 * The Enum Environment.
	 */
	public enum Environment
	{

		/** PROD API ENDPOINT. */
		PROD("https://api.sandbox.co.in"),

		/** UAT API ENDPOINT. */
		UAT("https://test-api.sandbox.co.in"),

		/** LOCAL API ENDPOINT. */
		LOCAL("http://localhost:8080/api-services");

		/**
		 * Gets the.
		 *
		 * @param apiKey
		 *            the api key
		 * @return the environment
		 */
		public static Environment get(String apiKey)
		{

			switch (apiKey.split("_")[1])
			{
				case "live":
					return Environment.PROD;
				case "test":
					return Environment.UAT;
				default:
					return Environment.PROD;
			}
		}

		/** The host. */
		private final String host;

		/**
		 * Instantiates a new host.
		 *
		 * @param host
		 *            the host
		 */
		Environment(final String host)
		{
			this.host = host;
		}

		/**
		 * Gets the host.
		 *
		 * @return the host
		 */
		public String getHost()
		{
			return this.host;
		}
	}

	/**
	 * The Enum URL.
	 */
	public enum URL
	{

		/** The authenticate. */
		AUTHENTICATE("/authenticate"),

		/** The authorize. */
		AUTHORIZE("/authorize?request_token={requestToken}"),

	    /* OAUTH ENDPOINTS */

		/** The oauth authorize. */
		OAUTH_AUTHORIZE("/oauth/authorize?request_token={requestToken}"),

	    /* PAN ENDPOINTS */

		/** The verify pan. */
		VERIFY_PAN("/kyc/pan/verify"),

		/** The get pan aadhaar link status. */
		GET_PAN_AADHAAR_LINK_STATUS("/it-tools/pans/{pan}/pan-aadhaar-status?aadhaar_number={aadhaar_number}"),

	    /* MCA ENDPOINTS */

		/** The director master data. */
		DIRECTOR_MASTER_DATA("/mca/company/master-data/search"),

		/** The company master data. */
		COMPANY_MASTER_DATA("/mca/director/master-data/search"),

	    /* GST ENDPOINTS */

		/** The track GST Return. */
		TRACK_GST_RETURN("/gst/compliance/public/gstrs/track?financial_year={financial_year}&gstr={gstr}"),

		/** The Search GSTIN. */
		SEARCH_GSTIN("/gst/compliance/public/gstin/search"),

		/** The Search GSTIN by PAN. */
		SEARCH_GSTIN_BY_PAN("/gst/compliance/public/pan/search?state_code={state_code}"),

	    /* BANK ENDPOINTS */

		/** The Fetch Bank Details by IFSC. */
		FETCH_BANK_DETAILS_BY_IFSC("/bank/{ifsc}"),

		/** Verify Bank Account. */
		VERIFY_BANK_ACCOUNT("/bank/{ifsc}/accounts/{account_number}/verify?name={name}&mobile={mobile}"),

		/** Verify Bank Account. */
		VERIFY_BANK_ACCOUNT_PENNILESS(
		        "/bank/{ifsc}/accounts/{account_number}/penniless-verify?name={name}&mobile={mobile}"),

		/** The upi verification. */
		UPI_VERIFICATION("/bank/upi/{virtual_payment_address}?name={name}"),

	    /* TDS COMPLIANCE ENDPOINTS */

		/** The search tan. */
		SEARCH_TAN("/itd/portal/public/tans/{tan}?consent={consent}&reason={reason}"),

		/** The section 206ab 206cc compliance check sync. */
		SECTION_206AB_206CC_COMPLIANCE_CHECK_SYNC("/tds/compliance/206ab/check");

		/** The value. */
		private final String value;

		/**
		 * Instantiates a new url.
		 *
		 * @param value
		 *            the value
		 */
		URL(final String value)
		{
			this.value = value;
		}

		/**
		 * Gets the value.
		 *
		 * @return the value
		 */
		public String getValue()
		{
			return this.value;
		}

	}
}
