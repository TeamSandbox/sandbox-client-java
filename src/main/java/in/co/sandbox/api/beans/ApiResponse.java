/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Manav Darji
 */
package in.co.sandbox.api.beans;

import org.json.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ApiResponse.
 */
public class ApiResponse extends Entity
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4114150821473975431L;

	/**
	 * Instantiates a new api response.
	 *
	 * @param jsonObject
	 *            the json object
	 */
	public ApiResponse(JSONObject jsonObject)
	{
		super(jsonObject);
	}

	/**
	 * Checks if is error.
	 *
	 * @return true, if is error
	 */
	public boolean isError()
	{
		if ((Integer) super.get("code") != 200)
		{
			return true;
		}

		return false;
	}

}
