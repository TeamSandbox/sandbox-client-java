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
 * The Class LedgerClient.
 */
public class LedgerClient extends RestClient
{

	/**
	 * Instantiates a new ledger client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public LedgerClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Gets the cash ITC balance.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the cash ITC balance
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getCashITCBalance(final String gstin, final String year, final String month)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.CASH_ITC_BALANCE,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the cash ledger.
	 *
	 * @param gstin
	 *            the gstin
	 * @param fromDate
	 *            the from date
	 * @param toDate
	 *            the to date
	 * @return the cash ledger
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getCashLedger(final String gstin, final String fromDate, final String toDate)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.CASH_LEDGER,
			        Environment.get(sessionCredentials.getApiKey()), gstin, fromDate, toDate));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the ITC ledger.
	 *
	 * @param gstin
	 *            the gstin
	 * @param fromDate
	 *            the from date
	 * @param toDate
	 *            the to date
	 * @return the ITC ledger
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getITCLedger(final String gstin, final String fromDate, final String toDate)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.ITC_LEDGER,
			        Environment.get(sessionCredentials.getApiKey()), gstin, fromDate, toDate));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the tax liability ledger.
	 *
	 * @param gstin
	 *            the gstin
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the tax liability ledger
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getTaxLiabilityLedger(final String gstin, final String year, final String month)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.TAX_LIABILITY_LEDGER,
			        Environment.get(sessionCredentials.getApiKey()), gstin, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the other ledger.
	 *
	 * @param gstin
	 *            the gstin
	 * @param fromDate
	 *            the from date
	 * @param toDate
	 *            the to date
	 * @return the other ledger
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getOtherLedger(final String gstin, final String fromDate, final String toDate)
	        throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.OTHER_LEDGER,
			        Environment.get(sessionCredentials.getApiKey()), gstin, fromDate, toDate));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}

	/**
	 * Gets the return related liability balance.
	 *
	 * @param gstin
	 *            the gstin
	 * @param gstr
	 *            the gstr
	 * @param year
	 *            the year
	 * @param month
	 *            the month
	 * @return the return related liability balance
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject getReturnRelatedLiabilityBalance(final String gstin, final String gstr, final String year,
	        final String month) throws SandboxException
	{
		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.RETURN_RELATED_LIABILITY_BALANCE,
			        Environment.get(sessionCredentials.getApiKey()), gstin, gstr, year, month));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500, e);
		}
	}
}
