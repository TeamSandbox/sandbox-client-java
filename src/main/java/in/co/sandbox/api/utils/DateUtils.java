/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Harsh Bagadia
 */
package in.co.sandbox.api.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import in.co.sandbox.api.exception.ConverterException;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtils.
 */
public class DateUtils
{

	/** The date formatter. */
	public static DateTimeFormatter DATE_FORMATTER =
	        DateTimeFormat.forPattern("dd/MM/yyyy").withZone(DateTimeZone.forID("Asia/Kolkata"));

	/** The datetime formatter. */
	public static DateTimeFormatter DATETIME_FORMATTER =
	        DateTimeFormat.forPattern("dd/MM/yyyy hh:mm:ss a").withZone(DateTimeZone.forID("Asia/Kolkata"));

	/** The timezone. */
	public static DateTimeZone TIMEZONE = DateTimeZone.forID("Asia/Kolkata");

	/**
	 * Now in india.
	 *
	 * @return the date time
	 */
	public static DateTime nowInIndia()
	{
		return DateTime.now(TIMEZONE);
	}

	/**
	 * Prints the date.
	 *
	 * @param date
	 *            the date
	 * @return the string
	 * @throws ConverterException
	 *             the converter exception
	 */
	public static String printDate(final DateTime date) throws ConverterException
	{
		return DATE_FORMATTER.print(date.getMillis());
	}

	/**
	 * Prints the date time.
	 *
	 * @param date
	 *            the date
	 * @return the string
	 * @throws ConverterException
	 *             the converter exception
	 */
	public static String printDateTime(final DateTime date) throws ConverterException
	{
		return DATETIME_FORMATTER.print(date.getMillis());
	}

	/**
	 * Read date.
	 *
	 * @param date
	 *            the date
	 * @return the date time
	 * @throws ConverterException
	 *             the converter exception
	 */
	public static DateTime readDate(final String date) throws ConverterException
	{
		return DATE_FORMATTER.parseDateTime(date);
	}

	/**
	 * Read ISO 8601 date.
	 *
	 * @param date
	 *            the date
	 * @return the date time
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	public static DateTime readISO8601Date(final String date) throws IllegalArgumentException
	{
		return DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZ").withZone(DateTimeZone.forID("Asia/Kolkata"))
		        .parseDateTime(date);
	}

	/**
	 * Read date time.
	 *
	 * @param date
	 *            the date
	 * @return the date time
	 * @throws ConverterException
	 *             the converter exception
	 */
	public static DateTime readDateTime(final String date) throws ConverterException
	{
		return DATETIME_FORMATTER.parseDateTime(date);
	}

	/**
	 * Read date.
	 *
	 * @param date
	 *            the date
	 * @return the date time
	 * @throws ConverterException
	 *             the converter exception
	 */
	public static DateTime readDate(java.sql.Date date) throws ConverterException
	{
		if (date != null)
		{
			return new DateTime(date, TIMEZONE);
		}

		return null;
	}

	/**
	 * Read date.
	 *
	 * @param date
	 *            the date
	 * @return the date time
	 * @throws ConverterException
	 *             the converter exception
	 */
	public static DateTime readDate(Long date) throws ConverterException
	{
		if (date != null)
		{
			return new DateTime(date, TIMEZONE);
		}

		return null;
	}

	/**
	 * Read date.
	 *
	 * @param timestamp
	 *            the timestamp
	 * @return the date time
	 * @throws ConverterException
	 *             the converter exception
	 */
	public static DateTime readDate(java.sql.Timestamp timestamp) throws ConverterException
	{
		if (timestamp != null)
		{
			return new DateTime(timestamp, TIMEZONE);
		}

		return null;

	}

}
