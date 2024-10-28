/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Manav Darji
 */
package in.co.sandbox.api.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class SandboxException.
 */
public class SandboxException extends Throwable
{

	/** TODO Auto-generated JavaDoc. */
	private static final long serialVersionUID = 4777398988267708757L;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(SandboxException.class);

	/** The message. */
	@JsonProperty("message")
	String message;

	/** The code. */
	@JsonProperty("code")
	int code;

	/** The transaction id. */
	@JsonProperty("transaction_id")
	String transactionId;

	/** The timestamp. */
	@JsonProperty("timestamp")
	long timestamp;

	/**
	 * Instantiates a new sandbox exception.
	 *
	 * @param msg
	 *            the msg
	 */

	public SandboxException(final String msg)
	{
		this.message = msg;

		if (msg != null)
		{
			logger.error(msg);
		}
	}

	/**
	 * Instantiates a new sandbox exception.
	 *
	 * @param msg
	 *            the msg
	 * @param code
	 *            the code
	 */
	public SandboxException(final String msg, final int code)
	{
		this.message = msg;
		this.code = code;
		if (msg != null)
		{
			logger.error(msg);
		}
	}

	/**
	 * Instantiates a new sandbox exception.
	 *
	 * @param msg
	 *            the msg
	 * @param code
	 *            the code
	 * @param cause
	 *            the cause
	 */
	public SandboxException(final String msg, final int code, final Throwable cause)
	{
		this.message = msg;
		this.code = code;
		if (msg != null)
		{
			if (logger.isTraceEnabled() || logger.isInfoEnabled())
			{
				logger.error(msg, cause);
			}
			else
			{
				logger.error(msg);
			}
		}
	}

	/**
	 * Instantiates a new sandbox exception.
	 *
	 * @param msg
	 *            the msg
	 * @param code
	 *            the code
	 * @param transactionId
	 *            the transaction id
	 * @param timestamp
	 *            the timestamp
	 */
	public SandboxException(final String msg, final int code, final String transactionId, final long timestamp)
	{
		this.message = msg;
		this.code = code;
		this.transactionId = transactionId;
		this.timestamp = timestamp;
		if (msg != null)
		{
			logger.error(msg);
		}
	}

	/**
	 * Instantiates a new sandbox exception.
	 *
	 * @param msg
	 *            the msg
	 * @param code
	 *            the code
	 * @param transactionId
	 *            the transaction id
	 * @param timestamp
	 *            the timestamp
	 * @param cause
	 *            the cause
	 */
	public SandboxException(final String msg, final int code, final String transactionId, final long timestamp,
	        final Throwable cause)
	{
		this.message = msg;
		this.code = code;
		this.transactionId = transactionId;
		this.timestamp = timestamp;
		if (msg != null)
		{
			if (logger.isTraceEnabled() || logger.isInfoEnabled())
			{
				logger.error(msg, cause);
			}
			else
			{
				logger.error(msg);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMessage()
	{
		return message;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getCode()
	{
		return code;
	}

	/**
	 * {@inheritDoc}
	 */
	public long getTimestamp()
	{
		return timestamp;
	}

}
