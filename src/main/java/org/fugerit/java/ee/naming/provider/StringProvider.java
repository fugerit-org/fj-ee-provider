package org.fugerit.java.ee.naming.provider;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

/**
 * Simple ObjectFactory using a java.util.String to return only one configuration entry
 * (if more configuration entries are set, result may be unpredictable). 
 * 
 * @author fugerit
 *
 */
public class StringProvider implements ObjectFactory, Serializable {

	private static final long serialVersionUID = 6199452144621162425L;

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
		Object config = null;
		Reference ref = (Reference) obj;
		Enumeration<RefAddr> addrs = ref.getAll();
		RefAddr addr = null;
		String value = null;
		while (addrs.hasMoreElements()) {
			addr = (RefAddr) addrs.nextElement();
			value = (String) addr.getContent();
			config = value;
		}
		return config;
	}

}
