/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.client;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.client.bank.KYCClient;
import in.co.sandbox.api.client.gst.GSTClient;
import in.co.sandbox.api.client.roc.ROCClient;
import in.co.sandbox.api.client.tds.TDSClient;

// TODO: Auto-generated Javadoc
/**
 * The Class ApiClient.
 */
public class ApiClient
{

	/** The kyc. */
	public KYCClient KYC;

	/** The roc. */
	public ROCClient ROC;

	/** The gst. */
	public GSTClient GST;

	/** The tds. */
	public TDSClient TDS;

	/**
	 * Instantiates a new api client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            enable debug log flag
	 */
	protected ApiClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{

		this.KYC = new KYCClient(sessionCredentials, enableDebugLog);

		this.ROC = new ROCClient(sessionCredentials, enableDebugLog);

		this.GST = new GSTClient(sessionCredentials, enableDebugLog);

		this.TDS = new TDSClient(sessionCredentials, enableDebugLog);
	}

}
