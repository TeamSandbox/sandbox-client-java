/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.beans;

import org.joda.time.DateTime;
import org.json.JSONObject;

import in.co.sandbox.api.exception.ConverterException;
import in.co.sandbox.api.utils.DateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class ApiResponse.
 */
public class PAN extends Entity
{

	/** TODO Auto-generated JavaDoc. */
	private static final long serialVersionUID = 6560869628388110234L;

	/**
	 * Instantiates a new api response.
	 *
	 * @param jsonObject
	 *            the json object
	 */
	public PAN(JSONObject jsonObject)
	{
		super(jsonObject);
	}

	/**
	 * Gets the pan.
	 *
	 * @return the pan
	 */
	public String getPan()
	{
		return super.get("pan");
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName()
	{
		return super.get("first_name");
	}

	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName()
	{
		return super.get("middle_name");
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName()
	{
		return super.get("last_name");
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName()
	{
		return super.get("full_name");
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus()
	{
		return super.get("status");
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory()
	{
		return super.get("category");
	}

	/**
	 * Gets the last updated.
	 *
	 * @return the last updated
	 */
	public DateTime getLastUpdated()
	{
		if (super.has("last_updated"))
		{

			try
			{
				return DateUtils.readDate(super.get("last_updated").toString());
			}
			catch (final ConverterException cE)
			{
				return null;
			}

		}

		return null;

	}

}
