/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Manav Darji
 */
package in.co.sandbox.api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ConverterException.
 *
 */
public class ConverterException extends Exception
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7564188491314522698L;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ConverterException.class);

	/**
	 * Instantiates a new converter exception.
	 *
	 * @param msg
	 *            the msg
	 */
	public ConverterException(final String msg)
	{
		super(msg);
		logger.error(msg);
	}

	/**
	 * Instantiates a new converter exception.
	 *
	 * @param msg
	 *            the msg
	 * @param cause
	 *            the cause
	 */
	public ConverterException(final String msg, final Throwable cause)
	{
		super(msg, cause);
		logger.error(msg, cause);
	}

}
