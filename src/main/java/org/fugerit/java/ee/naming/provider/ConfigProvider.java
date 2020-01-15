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
 * Simple ObjectFactory based on {@link Config} to return all configuration entries 
 * 
 * @see Config
 * 
 * @author fugerit
 *
 */
public class ConfigProvider implements ObjectFactory, Serializable {

	private static final long serialVersionUID = 6199621162425L;

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
		Config conf = new Config();
		Reference ref = (Reference) obj;
		Enumeration<RefAddr> addrs = ref.getAll();
		RefAddr addr = null;
		String entryName = null;
		String value = null;
		while (addrs.hasMoreElements()) {
			addr = (RefAddr) addrs.nextElement();
			entryName = addr.getType();
			value = (String) addr.getContent();
			conf.setAttribute( entryName , value );
		}
		return conf;
	}

}
