package in.co.sandbox.api.client.tds;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.client.RestClient;
import in.co.sandbox.api.client.tds.compliance.ITRPClient;
import in.co.sandbox.api.client.tds.compliance.TracesClient;

// TODO: Auto-generated Javadoc
/**
 * The Class TDSComplianceClient.
 */
public class TDSComplianceClient extends RestClient
{

	public ITRPClient REPORTING;

	public TracesClient TRACES;

	/**
	 * Instantiates a new TDS compliance client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public TDSComplianceClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials);

		this.REPORTING = new ITRPClient(sessionCredentials, enableDebugLog);

		this.TRACES = new TracesClient(sessionCredentials, enableDebugLog);
	}

}
