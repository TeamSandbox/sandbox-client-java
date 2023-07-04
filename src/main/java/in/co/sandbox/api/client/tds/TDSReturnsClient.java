package in.co.sandbox.api.client.tds;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.client.RestClient;
import in.co.sandbox.api.client.tds.returns.TDSFVUClient;
import in.co.sandbox.api.client.tds.returns.TDSTXTCSIClient;

// TODO: Auto-generated Javadoc
/**
 * The Class TDSReturns.
 */
public class TDSReturnsClient extends RestClient
{

	/** The tdstxtcsi. */
	public TDSTXTCSIClient TXT;

	/** The tdsfvu. */
	public TDSFVUClient FVU;

	/**
	 * Instantiates a new TDS returns.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public TDSReturnsClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials);

		this.TXT = new TDSTXTCSIClient(sessionCredentials, enableDebugLog);

		this.FVU = new TDSFVUClient(sessionCredentials, enableDebugLog);
	}
}
