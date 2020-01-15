package org.fugerit.java.ee.naming.provider;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

/**
 * Simple ObjectFactory using a java.util.Properties to return all configuration entries 
 * 
 * @author fugerit
 *
 */
public class PropertyProvider implements ObjectFactory, Serializable {

	private static final long serialVersionUID = 6199452144621162425L;

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
		Properties props = new Properties();
		Reference ref = (Reference) obj;
		Enumeration<RefAddr> addrs = ref.getAll();
		RefAddr addr = null;
		String entryName = null;
		String value = null;
		while (addrs.hasMoreElements()) {
			addr = (RefAddr) addrs.nextElement();
			entryName = addr.getType();
			value = (String) addr.getContent();
			props.setProperty( entryName , value );
		}
		return props;
	}

}
