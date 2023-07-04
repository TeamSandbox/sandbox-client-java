package in.co.sandbox.api.client.bank;

import in.co.sandbox.api.auth.ApiSessionCredentials;

// TODO: Auto-generated Javadoc
/**
 * The Class KYCClient.
 */
public class KYCClient
{

	/** The bank. */
	public BankClient BANK;

	/** The mca. */
	public MCAClient MCA;

	/** The pan. */
	public PANClient PAN;

	/** The taxpayer. */
	public TaxPayerClient TAXPAYER;

	/**
	 * Instantiates a new KYC client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public KYCClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{

		this.BANK = new BankClient(sessionCredentials, enableDebugLog);

		this.MCA = new MCAClient(sessionCredentials, enableDebugLog);

		this.PAN = new PANClient(sessionCredentials, enableDebugLog);

		this.TAXPAYER = new TaxPayerClient(sessionCredentials, enableDebugLog);
	}
}
