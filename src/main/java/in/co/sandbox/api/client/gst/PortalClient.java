/**
 * Copyright Aug 25, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.client.gst;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.client.RestClient;
import in.co.sandbox.api.client.gst.gsp.portal.TaxPayerClient;

// TODO: Auto-generated Javadoc
/**
 * The Class PortalClient.
 */
public class PortalClient extends RestClient
{

	/** The taxpayer. */
	public TaxPayerClient TAXPAYER;

	/**
	 * Instantiates a new portal client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public PortalClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials);

		this.TAXPAYER = new TaxPayerClient(sessionCredentials, enableDebugLog);
	}

}
