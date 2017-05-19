package com.acmerocket.fireside;

import java.io.IOException;
import java.util.Map;

public class Things {
    //private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Quests.class);

    public static String TEMPLATE_FILE = "/quests.json"; // FIXME
    
    private final JsonTemplate template;

    private Things(JsonTemplate template) {
        this.template = template;
    }
    
    public Things() throws IOException {
        this(JsonTemplate.load(Things.class.getResourceAsStream(TEMPLATE_FILE)));
    }
    
    public Things(String filename) throws IOException {
        this(JsonTemplate.load(filename));
    }

    public Thing generate() {
        Map<String,String> attrs = this.template.fill("item");
        //LOG.info("Loaded attrs: {}", attrs);
        
        return new Thing(attrs);
    }
    
    public static void main(String[] args) throws IOException {
    	int iter = 1;
    	if (args.length > 0) {
    		iter = Integer.parseInt(args[0]);
    	}
    	
    	Things quests = new Things();
    	
    	for (int i = 0; i < iter; i++) {
    		System.out.println(quests.generate());
    	}
    }
}
