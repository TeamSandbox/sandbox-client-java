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

		/** The get pan. */
		GET_PAN("/kyc/pan"),

		/** The verify pan. */
		VERIFY_PAN("/pans/{pan}/verify?consent={consent}&reason={reason}"),

		/** The get pan aadhaar link status. */
		GET_PAN_AADHAAR_LINK_STATUS("/it-tools/pans/{pan}/pan-aadhaar-status?aadhaar_number={aadhaar_number}"),

		/** The search tan. */
		SEARCH_TAN("/itd/portal/public/tans/{tan}?consent={consent}&reason={reason}"),

	    /* MCA ENDPOINTS */

		/** The director master data. */
		DIRECTOR_MASTER_DATA("/mca/directors/{din}?consent={consent}&reason={reason}"),

		/** The company master data. */
		COMPANY_MASTER_DATA("/mca/companies/{id}?consent={consent}&reason={reason}"),

	    /* GST ENDPOINTS */

		/** The track GST Return. */
		TRACK_GST_RETURN("/gsp/public/gstr?gstin={gstin}&financial_year={financial_year}"),

		/** The Search GSTIN. */
		SEARCH_GSTIN("/gsp/public/gstin/{gstin}"),

		/** The Search GSTIN by PAN. */
		SEARCH_GSTIN_BY_PAN("/gsp/public/pan/{pan}?state_code={state_code}"),

		/** The gst generate otp. */
		GST_GENERATE_OTP("/gsp/tax-payer/{gstin}/otp?username={username}"),

		/** The gst verify otp. */
		GST_VERIFY_OTP("/gsp/tax-payer/{gstin}/otp/verify?username={username}&otp={otp}"),

		/** The gst portal session expiery. */
		GST_SESSION_EXPIRY("/gsp/tax-payer/{gstin}/session"),

		/** The gst protal referesh taxpayer access. */
		GST_REFERESH_TAXPAYER_ACCESS("/gsp/tax-payer/{gstin}/session/refresh"),

		/** The gst portal taxpayer logout. */
		GST_TAXPAYER_LOGOUT("/gsp/tax-payer/{gstin}/logout"),

		/** The gst generate evc otp. */
		GST_GENERATE_EVC_OTP("/gsp/tax-payer/{gstin}/{gstr}/evc/otp?pan={pan}"),

		/** The gst proceed to file. */
		GST_PROCEED_TO_FILE("/gsp/tax-payer/{gstin}/{gstr}/{year}/{month}/proceed?is_nil={is_nil}"),

		/** The gst get return status. */
		GST_GET_RETURN_STATUS("/gsp/tax-payer/{gstin}/gstrs/{year}/{month}/status?reference_id={reference_id}"),

	    /* LEDGER ENDPOINTS */

		/** The cash itc balance. */
		CASH_ITC_BALANCE("/gsp/tax-payer/{gstin}/ledgers/bal/{year}/{month}"),

		/** The cash ledger. */
		CASH_LEDGER("/gsp/tax-payer/{gstin}/ledgers/cash?from={form}&to={to}"),

		/** The itc ledger. */
		ITC_LEDGER("/gsp/tax-payer/{gstin}/ledgers/itc?from={form}&to={to}"),

		/** The tax liability ledger. */
		TAX_LIABILITY_LEDGER("/gsp/tax-payer/{gstin}/ledgers/tax/{year}/{month}"),

		/** The other ledger. */
		OTHER_LEDGER("/gsp/tax-payer/{gstin}/ledgers/other?from={form}&to={to}"),

		/** The return related liability balance. */
		RETURN_RELATED_LIABILITY_BALANCE("/gsp/tax-payer/{gstin}/ledgers/{gstr}/liability/{year}/{month}"),

	    /* GSTR-1 ENDPOINTS */

		/** The gstr1 get advance tax. */
		GSTR1_GET_AT("/gsp/tax-payer/{gstin}/gstrs/gstr-1/at/{year}/{month}"),

		/** The gstr1 get amended advance tax. */
		GSTR1_GET_AT_AMENDED("/gsp/tax-payer/{gstin}/gstrs/gstr-1/ata/{year}/{month}"),

		/** The gstr1 get b2b invoices. */
		GSTR1_GET_B2B_INVOICES(
		        "/gsp/tax-payer/{gstin}/gstrs/gstr-1/b2b/{year}/{month}?ctin={ctin}&action_required={action_required}&from={from}"),

		/** The gstr1 get b2b amended invoices. */
		GSTR1_GET_B2B_AMENDED_INVOICES(
		        "/gsp/tax-payer/{gstin}/gstrs/gstr-1/b2ba/{year}/{month}?ctin={ctin}&action_required={action_required}&from={from}"),

		/** The gstr1 get b2cl invoices. */
		GSTR1_GET_B2CL_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-1/b2cl/{year}/{month}?state_code={state_code}"),

		/** The gstr1 get b2cl amended invoices. */
		GSTR1_GET_B2CL_AMENDED_INVOICES(
		        "/gsp/tax-payer/{gstin}/gstrs/gstr-1/b2cla/{year}/{month}?state_code={state_code}"),

		/** The gstr1 get b2cs invoices. */
		GSTR1_GET_B2CS_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-1/b2cs/{year}/{month}"),

		/** The gstr1 get b2cs amended invoices. */
		GSTR1_GET_B2CS_AMENDED_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-1/b2csa/{year}/{month}"),

		/** The gstr1 get cdnr invoices. */
		GSTR1_GET_CDNR_INVOICES(
		        "/gsp/tax-payer/{gstin}/gstrs/gstr-1/cdnr/{year}/{month}?action_required={action_required}&from={from}"),

		/** The gstr1 get cdnr amended invoices. */
		GSTR1_GET_CDNR_AMENDED_INVOICES(
		        "/gsp/tax-payer/{gstin}/gstrs/gstr-1/cdnra/{year}/{month}?action_required={action_required}&from={from}"),

		/** The gstr1 get cdnur invoices. */
		GSTR1_GET_CDNUR_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-1/cdnur/{year}/{month}"),

		/** The gstr1 get cdnur amended invoices. */
		GSTR1_GET_CDNUR_AMENDED_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-1/cdnura/{year}/{month}"),

		/** The gstr1 get document issued. */
		GSTR1_GET_DOCUMENT_ISSUED("/gsp/tax-payer/{gstin}/gstrs/gstr-1/doc-issue/{year}/{month}"),

		/** The gstr1 get exp invoices. */
		GSTR1_GET_EXP_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-1/exp/{year}/{month}"),

		/** The gstr1 get exp amended invoices. */
		GSTR1_GET_EXP_AMENDED_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-1/expa/{year}/{month}"),

		/** The gstr1 get summary. */
		GSTR1_GET_SUMMARY("/gsp/tax-payer/{gstin}/gstrs/gstr-1/{year}/{month}"),

		/** The gstr1 get hsn summary. */
		GSTR1_GET_HSN_SUMMARY("/gsp/tax-payer/{gstin}/gstrs/gstr-1/hsn/{year}/{month}"),

		/** The gstr1 get nil supply. */
		GSTR1_GET_NIL_SUPPLY("/gsp/tax-payer/{gstin}/gstrs/gstr-1/nil/{year}/{month}"),

		/** The gstr1 save. */
		GSTR1_SAVE("/gsp/tax-payer/{gstin}/gstrs/gstr-1/{year}/{month}"),

		/** The gstr1 reset. */
		GSTR1_RESET("/gsp/tax-payer/{gstin}/gstrs/gstr-1/{year}/{month}/reset"),

		/** The gstr1 file. */
		GSTR1_FILE("/gsp/tax-payer/{gstin}/gstrs/gstr-1/{year}/{month}/file?pan={pan}&otp={evcotp}"),

	    /* GSTR-2A ENDPOINTS */

		/** The gstr2a b2b invoices. */
		GSTR2A_B2B_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-2a/b2b/{year}/{month}?ctin={ctin}"),

		/** The gstr2a b2ba invoices. */
		GSTR2A_B2BA_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-2a/b2ba/{year}/{month}?ctin={ctin}"),

		/** The gstr2a cdn invoices. */
		GSTR2A_CDN_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-2a/cdn/{year}/{month}?ctin={ctin}"),

		/** The gstr2a cdna invoices. */
		GSTR2A_CDNA_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-2a/cdna/{year}/{month}?ctin={ctin}"),

		/** The gstr2a isd invoices. */
		GSTR2A_ISD_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-2a/isd/{year}/{month}"),

		/** The gstr2a invoices. */
		GSTR2A_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-2a/{year}/{month}"),

	    /* GSTR-2B ENDPOINTS */

		/** The gstr2b invoices. */
		GSTR2B_INVOICES("/gsp/tax-payer/{gstin}/gstrs/gstr-2b/{year}/{month}?file_number={file_number}"),

	    /* GSTR-3B ENDPOINTS */

		/** The gstr3b save. */
		GSTR3B_SAVE("/gsp/tax-payer/{gstin}/gstrs/gstr-3b/{year}/{month}"),

		/** The gstr3b summary. */
		GSTR3B_SUMMARY("/gsp/tax-payer/{gstin}/gstrs/gstr-3b/{year}/{month}"),

		/** The gstr3b file. */
		GSTR3B_FILE("/gsp/tax-payer/{gstin}/gstrs/gstr-3b/{year}/{month}/file?pan={pan}&otp={otp}"),

	    /** Portal API. */

		/** The gst portal generate otp. */
		GST_PORTAL_GENERATE_OTP("/gst-portal/tax-payers/{gstin}/otp"),

		/** The gst portal verify otp. */
		GST_PORTAL_VERIFY_OTP("/gst-portal/tax-payers/{gstin}/otp/verify?otp={otp}"),

		/** The gst item code lookup. */
		GST_ITEM_CODE_LOOKUP("/gst-portal/services/items?key={key}"),

	    /* BANK ENDPOINTS */

		/** The Fetch Bank Details by IFSC. */
		FETCH_BANK_DETAILS_BY_IFSC("/bank/{ifsc}"),

		/** Verify Bank Account. */
		VERIFY_BANK_ACCOUNT("/bank/{ifsc}/accounts/{account_number}/verify?name={name}&mobile={mobile}"),

		/** The upi verification. */
		UPI_VERIFICATION("/bank/upi/{virtual_payment_address}?name={name}"),

	    /* CALCULATOR ENDPOINTS */

		/** The calculate tds. */
		CALCULATE_TDS("/calculators/tds"),

		/** The calculate company registration cost. */
		CALCULATE_COMPANY_REGISTRATION_COST(
		        "/calculators/roc/company/registration-fees?class={class}&state={state}&directors={directors}&share_capital={share_capital}"),

		/** The calculate partnership registration cost. */
		CALCULATE_PARTNERSHIP_REGISTRATION_COST(
		        "/calculators/roc/llp/registration-fees?incorporation_class={incorporation_class}&state={state}&partners={partners}&contribution={contribution}"),

	    /* TDS COMPLIANCE ENDPOINTS */

		/** The section 206ab 206cc compliance check sync. */
		SECTION_206AB_206CC_COMPLIANCE_CHECK_SYNC("/itd/reporting-portal/tds/206-ab/{pan}"),

		/** The section 206ab 206cc compliance check async. */
		SECTION_206AB_206CC_COMPLIANCE_CHECK_ASYNC("/itd/reporting-portal/tds/206-ab"),

		/** The get job status. */
		SECTION_206AB_206CC_COMPLIANCE_CHECK_ASYNC_POLL_JOB("/itd/reporting-portal/tds/206-ab?job_id={jobId}"),

		/** The download form 16a. */
		TDS_COMPLIANCE_FORM16A_SUBMIT_JOB(
		        "/tds-compliance/traces/deductors/{tan}/form-16a?quarter={quarter}&financial_year={financialYear}"),

		/** The get job status traces. */
		TDS_COMPLIANCE_FORM16A_POLL_JOB("/tds-compliance/traces/deductors/{tan}/form-16a?job_id={job_id}"),

	    /* TDS Returns */

		/** The prepare tds returns. */
		TDS_REPORTING_SUBMIT_JOB(
		        "/tds-reporting/deductors/{tan}/tdsrs/{form}/async?quarter={quarter}&financial_year={financialYear}&previous_rrr_number={previous_rrr_number}&filing_type={filing_type}"),

		/** The tds return job status. */
		TDS_REPORTING_POLL_JOB(
		        "/tds-reporting/deductors/{tan}/tdsrs/{form}/async?job_id={job_id}&quarter={quarter}&financial_year={financialYear}"),

		/** The tds e file using txt csi. */
		TDS_E_FILE_USING_TXT_CSI(
		        "/tds-compliance/tin-fc/deductors/{tan}/tdsrs/{form}/e-file?quarter={quarter}&financial_year={financialYear}"),

		/** The tds poll job txt csi return. */
		TDS_E_FILE_TXT_CSI_RETURN_POLL_JOB(
		        "/tds-compliance/tin-fc/deductors/{tan}/tdsrs/{form}/e-file?job_id={job_id}"),

		/** The tds e file using fvu zip. */
		TDS_E_FILE_USING_FVU_ZIP(
		        "/tds-compliance/tin-fc/deductors/{tan}/tdsrs/{form}/fvu/e-file?quarter={quarter}&financial_year={financialYear}"),

		/** The tds poll job fvu zip return. */
		TDS_E_FILE_FVU_ZIP_RETURN_POLL_JOB(
		        "/tds-compliance/tin-fc/deductors/{tan}/tdsrs/{form}/fvu/e-file?job_id={job_id}");

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
