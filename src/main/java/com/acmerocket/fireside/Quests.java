package com.acmerocket.fireside;

import java.util.Map;

public class Quests {
    //private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Quests.class);

    public static String DEFAULT_FILE = "src/main/resources/quests.json";
    
    private final JsonTemplate template;

    private Quests(JsonTemplate template) {
        this.template = template;
    }
    
    public static Quests load() {
        return load(DEFAULT_FILE);
    }
    
    public static Quests load(String filename) {
        return new Quests(JsonTemplate.load(filename));
    }

    public Quest generate() {
        Map<String,String> attrs = this.template.fill();
        //LOG.info("Loaded attrs: {}", attrs);
        
        return new Quest(attrs);
    }
    
    public static void main(String[] args) {
    	int iter = 1;
    	if (args.length > 0) {
    		iter = Integer.parseInt(args[0]);
    	}
    	
    	Quests quests = Quests.load();
    	
    	for (int i = 0; i < iter; i++) {
    		System.out.println(quests.generate());
    	}
    }
}
