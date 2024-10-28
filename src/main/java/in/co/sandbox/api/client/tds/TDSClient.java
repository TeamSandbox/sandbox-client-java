package in.co.sandbox.api.client.tds;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.client.RestClient;

// TODO: Auto-generated Javadoc
/**
 * The Class TDSClient.
 */
public class TDSClient extends RestClient
{

	/** The compliance. */
	public ComplianceClient COMPLIANCE;

	/**
	 * Instantiates a new TDS client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public TDSClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);

		this.COMPLIANCE = new ComplianceClient(sessionCredentials, enableDebugLog);
	}
}
