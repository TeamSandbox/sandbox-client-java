/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.beans;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import in.co.sandbox.api.exception.ConverterException;
import in.co.sandbox.api.utils.DateUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Entity.
 */
public class Entity implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5327480854057572947L;

	/** The model json. */
	private JSONObject modelJson;

	/** The tmstmp. */
	private final String TMSTMP = "timestamp";

	/** The code. */
	private final String CODE = "code";

	/**
	 * Instantiates a new entity.
	 *
	 * @param jsonObject
	 *            the json object
	 */
	public Entity(JSONObject jsonObject)
	{
		this.modelJson = jsonObject;
	}

	/**
	 * Gets the.
	 *
	 * @param <T>
	 *            the generic type
	 * @param key
	 *            the key
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String key)
	{
		// Return null if key not in JSONObject
		if (!has(key))
		{
			return null;
		}
		// Return Date for timestamps
		if (key.equals(TMSTMP))
		{
			try
			{
				return (T) DateUtils.readDate(modelJson.getLong(key));
			}
			catch (final JSONException jE)
			{
				return null;
			}
			catch (final ConverterException cE)
			{
				return null;
			}
		}

		if (key.equals(CODE))
		{
			return (T) new Integer(modelJson.getInt(key));
		}

		Object value = modelJson.get(key);

		if (value == null)
		{
			return null;
		}

		return (T) value.getClass().cast(value);
	}

	/**
	 * To json.
	 *
	 * @return the JSON object
	 */
	public JSONObject toJson()
	{
		return modelJson;
	}

	/**
	 * Checks for.
	 *
	 * @param key
	 *            the key
	 * @return true, if successful
	 */
	public boolean has(String key)
	{
		return modelJson.has(key);
	}

	/**
	 * Checks for value.
	 *
	 * @param key
	 *            the key
	 * @return true, if successful
	 */
	public boolean hasValue(String key)
	{
		if (modelJson.has(key) && !modelJson.isNull(key) && !modelJson.get(key).toString().isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString()
	{
		return modelJson.toString();
	}
}