package com.acmerocket.fireside;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quest {
    //private static final Logger LOG = LoggerFactory.getLogger(Quest.class);

    //private final Race race;
    //private final CharClass clss;
    //private final String mood;
    private final String description;
    
    
    public Quest(Map<String, String> attrs) {
        //this.race = Race.valueOf(attrs.get("race"));
        //this.clss = CharClass.valueOf(attrs.get("dclass"));
        this.description = attrs.get("value");
        //this.mood = attrs.get("adjective");
        
        //this.hitpoints = this.clss.hitpoints();
        //LOG.debug("attrs: {}", attrs);
    }
    
    public String toString() {
        //return this.mood + " " + this.race + " " + this.clss;
    	return this.description();
    }
    
    public String description() {
        return this.description;
    }
}
