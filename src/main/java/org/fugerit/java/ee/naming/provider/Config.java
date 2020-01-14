package org.fugerit.java.ee.naming.provider;

import java.io.Serializable;
import java.util.Properties;
 
public class Config implements Serializable {

	private static final long serialVersionUID = -178829411555556356L;
	
	private Properties props;
	
    public Config() {
        this.props = new Properties();
    }
    
    protected void setAttribute(String key, String value) {
        props.put(key, value);
    }
    
    public Object getAttribute(String key) {
        return props.get(key);
    }
    
}