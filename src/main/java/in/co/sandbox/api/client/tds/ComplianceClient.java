package in.co.sandbox.api.client.tds;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.client.RestClient;
import in.co.sandbox.api.client.tds.compliance.PublicClient;

// TODO: Auto-generated Javadoc
/**
 * The Class TDSComplianceClient.
 */
public class ComplianceClient extends RestClient
{

	/** The public. */
	public PublicClient PUBLIC;

	/**
	 * Instantiates a new TDS compliance client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public ComplianceClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials);

		this.PUBLIC = new PublicClient(sessionCredentials, enableDebugLog);

	}

}
