package org.wpgn.dodo.json.support;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;

public class Json4DateObjectMapper extends ObjectMapper{

	public Json4DateObjectMapper(String pattern){
		  super();
	        configure(Feature.WRITE_DATES_AS_TIMESTAMPS, false);
	        if(pattern==null){
	        	pattern = "yyyy-MM-dd HH:mm:SS";
	        }
	        setDateFormat(new SimpleDateFormat(pattern));
	}
}
