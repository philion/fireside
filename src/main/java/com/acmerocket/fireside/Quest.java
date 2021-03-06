package com.acmerocket.fireside;

import java.util.Map;

public class Quest {
    //private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Quest.class);

    private final String description;
    
    public Quest(Map<String, String> attrs) {
        this.description = attrs.get("value");
    }
    
    public String toString() {
    	return this.description();
    }
    
    public String description() {
        return this.description;
    }
}
