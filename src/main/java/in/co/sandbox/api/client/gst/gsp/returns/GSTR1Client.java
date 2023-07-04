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
 * The Class GSTR1Client.
 */
public class GSTR1Client extends RestClient
{

	/**
	 * Instantiates a new GSTR 1 client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public GSTR1Client(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Gets the advance tax.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the advance tax
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAdvanceTax(final String gstin, final String year, final String month) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_AT,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the amended advance tax.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the amended advance tax
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAmendedAdvanceTax(final String gstin, final String year, final String month)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_AT_AMENDED,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the b 2 B invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param ctin
	 *            the ctin
	 * @param action_required
	 *            the action required
	 * @param from
	 *            the from
	 * @return the b 2 B invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getB2BInvoices(final String gstin, final String year, final String month, final String ctin,
	        final String action_required, final String from) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_B2B_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, ctin, action_required, from));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the amended B 2 B invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param ctin
	 *            the ctin
	 * @param action_required
	 *            the action required
	 * @param from
	 *            the from
	 * @return the amended B 2 B invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAmendedB2BInvoices(final String gstin, final String year, final String month,
	        final String ctin, final String action_required, final String from) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_B2B_AMENDED_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, ctin, action_required, from));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the b 2 CL invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param state_code
	 *            the state code
	 * @return the b 2 CL invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getB2CLInvoices(final String gstin, final String year, final String month,
	        final String state_code) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_B2CL_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, state_code));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the amended B 2 CL invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param state_code
	 *            the state code
	 * @return the amended B 2 CL invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAmendedB2CLInvoices(final String gstin, final String year, final String month,
	        final String state_code) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_B2CL_AMENDED_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, state_code));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the b 2 CS invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the b 2 CS invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getB2CSInvoices(final String gstin, final String year, final String month) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_B2CS_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}

	}

	/**
	 * Gets the amended B 2 CS invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the amended B 2 CS invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAmendedB2CSInvoices(final String gstin, final String year, final String month)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_B2CS_AMENDED_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the CDNR invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param action_required
	 *            the action required
	 * @param from
	 *            the from
	 * @return the CDNR invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getCDNRInvoices(final String gstin, final String year, final String month,
	        final String action_required, final String from) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_CDNR_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, action_required, from));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the amended CDNR invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param action_required
	 *            the action required
	 * @param from
	 *            the from
	 * @return the amended CDNR invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAmendedCDNRInvoices(final String gstin, final String year, final String month,
	        final String action_required, final String from) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_CDNR_AMENDED_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, action_required, from));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the CDNUR invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the CDNUR invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getCDNURInvoices(final String gstin, final String year, final String month)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_CDNUR_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the amended CDNUR invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the amended CDNUR invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAmendedCDNURInvoices(final String gstin, final String year, final String month)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_CDNUR_AMENDED_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the doc issued.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the doc issued
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getDocIssued(final String gstin, final String year, final String month) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_DOCUMENT_ISSUED,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the EXP invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the EXP invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getEXPInvoices(final String gstin, final String year, final String month) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_EXP_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the amended EXP invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the amended EXP invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAmendedEXPInvoices(final String gstin, final String year, final String month)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_EXP_AMENDED_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the summary.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the summary
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getSummary(final String gstin, final String year, final String month) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_SUMMARY,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the HSN summary.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the HSN summary
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getHSNSummary(final String gstin, final String year, final String month) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_HSN_SUMMARY,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the NIL supply.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the NIL supply
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getNILSupply(final String gstin, final String year, final String month) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_GET_NIL_SUPPLY,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
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
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_SAVE,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month), body);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}

	}

	/**
	 * Reset.
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
	public JSONObject reset(final String gstin, final String year, final String month, final JSONObject body)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_RESET,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month), body);

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
	 * @param evcOTP
	 *            the evc OTP
	 * @param body
	 *            the body
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject file(final String gstin, final String year, final String month, final String pan,
	        final String evcOTP, final JSONObject body) throws SandboxException
	{
		try
		{
			ApiResponse response = super.postForGet(ENDPOINTS.build(ENDPOINTS.URL.GSTR1_FILE,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, pan, evcOTP), body);

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}

	}
}
