package com.acmerocket.fireside;

import java.util.Map;

public class Place {
    //private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Place.class);

    private final String description;
    
    public Place(Map<String, String> attrs) {
        this.description = attrs.get("value");
    }
    
    public String toString() {
    	return this.description();
    }
    
    public String description() {
        return this.description;
    }
}
