package com.acmerocket.fireside;

import java.io.IOException;
import java.util.Map;

public class Quests {
    //private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Quests.class);

    public static String TEMPLATE_FILE = "/quests.json";
    
    private final JsonTemplate template;

    private Quests(JsonTemplate template) {
        this.template = template;
    }
    
    public Quests() throws IOException {
        this(JsonTemplate.load(Quests.class.getResourceAsStream(TEMPLATE_FILE)));
    }
    
    public Quests(String filename) throws IOException {
        this(JsonTemplate.load(filename));
    }

    public Quest generate() {
        Map<String,String> attrs = this.template.fill();
        //LOG.info("Loaded attrs: {}", attrs);
        
        return new Quest(attrs);
    }
    
    public static void main(String[] args) throws IOException {
    	int iter = 1;
    	if (args.length > 0) {
    		iter = Integer.parseInt(args[0]);
    	}
    	
    	Quests quests = new Quests();
    	
    	for (int i = 0; i < iter; i++) {
    		System.out.println(quests.generate());
    	}
    }
}
