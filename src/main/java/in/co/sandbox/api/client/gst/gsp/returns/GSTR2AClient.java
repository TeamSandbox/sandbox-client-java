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
 * The Class GSTR2AClient.
 */
public class GSTR2AClient extends RestClient
{

	/**
	 * Instantiates a new GSTR 2 A client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public GSTR2AClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
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
	 * @return the b 2 B invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getB2BInvoices(final String gstin, final String year, final String month, final String ctin)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR2A_B2B_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, ctin));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}

	}

	/**
	 * Gets the ammended B 2 B invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param ctin
	 *            the ctin
	 * @return the ammended B 2 B invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAmmendedB2BInvoices(final String gstin, final String year, final String month,
	        final String ctin) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR2A_B2BA_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, ctin));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the CDN invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param ctin
	 *            the ctin
	 * @return the CDN invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getCDNInvoices(final String gstin, final String year, final String month, final String ctin)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR2A_CDN_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, ctin));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the ammended CDN invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @param ctin
	 *            the ctin
	 * @return the ammended CDN invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getAmmendedCDNInvoices(final String gstin, final String year, final String month,
	        final String ctin) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR2A_CDNA_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month, ctin));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the ISD invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the ISD invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getISDInvoices(final String gstin, final String year, final String month) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR2A_ISD_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the 2 A invoices.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the 2 A invoices
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getSummary(final String gstin, final String year, final String month) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.GSTR2A_INVOICES,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}
}
