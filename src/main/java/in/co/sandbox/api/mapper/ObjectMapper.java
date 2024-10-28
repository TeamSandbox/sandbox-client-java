/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Manav Darji
 */
package in.co.sandbox.api.mapper;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsonorg.JsonOrgModule;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectMapper.
 */
public class ObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper
{

	/** TODO Auto-generated JavaDoc. */
	private static final long serialVersionUID = 1123276100501474040L;

	/**
	 * Instantiates a new object mapper.
	 */
	public ObjectMapper()
	{
		this.registerModule(new JodaModule());
		this.registerModule(new JsonOrgModule());
		this.setSerializationInclusion(Include.NON_NULL);

	}

}
