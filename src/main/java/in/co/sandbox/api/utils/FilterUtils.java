/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.utils;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class FilterUtils.
 */
public class FilterUtils
{

	/**
	 * List to CSV.
	 *
	 * @param list
	 *            the list
	 * @return the string
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	public static String listToCSV(final List<String> list) throws IllegalArgumentException
	{
		final StringBuilder csv = new StringBuilder();
		for (int index = 0; index < list.size(); index++)
		{
			csv.append(list.get(index));

			if (index != list.size() - 1)
			{
				csv.append(",");
			}
		}
		return csv.toString();
	}
}
