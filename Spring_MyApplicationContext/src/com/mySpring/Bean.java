package com.mySpring;

import java.util.ArrayList;
import java.util.List;

public class Bean {

	private String id;
	private String className;
	private List<Property> properties=new ArrayList<Property>();
	
	public Bean(String id, String className) {
		super();
		this.id = id;
		this.className = className;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
}
