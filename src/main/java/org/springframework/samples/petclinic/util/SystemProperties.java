package org.springframework.samples.petclinic.util;

import java.util.HashMap;

public class SystemProperties extends HashMap<String,String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public String get(Object name) {
        return System.getProperty(name != null ? name.toString() : null);
    }
}
