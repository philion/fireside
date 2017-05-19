package com.acmerocket.fireside;

import java.io.IOException;
import java.util.Map;

public class Creatures {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Quests.class);

    public static String TEMPLATE_FILE = "/quests.json";
    
    private final JsonTemplate template;
    
    private static Creatures INSTANCE;
    static {
    	try {
    		INSTANCE = new Creatures();
    	}
    	catch (Exception e) {
    		LOG.error("Error creating instance from {}", TEMPLATE_FILE, e);
    	}
    }
    public static synchronized Creatures instance() {
    	return INSTANCE;
    }

    private Creatures(JsonTemplate template) {
        this.template = template;
    }
    
    public Creatures() throws IOException {
        this(JsonTemplate.load(Creatures.class.getResourceAsStream(TEMPLATE_FILE)));
    }
    
    public Creatures(String filename) throws IOException {
        this(JsonTemplate.load(filename));
    }

    public Creature generate() {
        Map<String,String> attrs = this.template.fill();
        //LOG.info("Loaded attrs: {}", attrs);
        
        return new Creature(attrs);
    }
    
    public static void main(String[] args) throws IOException {
    	int iter = 1;
    	if (args.length > 0) {
    		iter = Integer.parseInt(args[0]);
    	}
    	
    	Creatures quests = new Creatures();
    	
    	for (int i = 0; i < iter; i++) {
    		System.out.println(quests.generate());
    	}
    }
}
