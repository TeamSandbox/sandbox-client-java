package in.co.sandbox.api.client.roc;

import in.co.sandbox.api.auth.ApiSessionCredentials;

// TODO: Auto-generated Javadoc
/**
 * The Class ROCClient.
 */
public class ROCClient
{

	/** The calculator. */
	public ROCCalculatorClient CALCULATOR;

	/**
	 * Instantiates a new ROC client.
	 *
	 * @param apiSessionCredentials
	 *            the api session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public ROCClient(final ApiSessionCredentials apiSessionCredentials, final boolean enableDebugLog)
	{

		this.CALCULATOR = new ROCCalculatorClient(apiSessionCredentials, enableDebugLog);
	}
}
