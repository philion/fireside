package com.acmerocket.fireside;

import java.util.Map;

public class Monsters {
    //private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Monsters.class);

    public static String DEFAULT_MONSTER_FILE = "src/main/resources/monsters.json"; // FIXME
    
    private final JsonTemplate template;

    private Monsters(JsonTemplate template) {
        this.template = template;
    }
    
    public static Monsters load() {
        return load(DEFAULT_MONSTER_FILE);
    }
    
    public static Monsters load(String filename) {
        return new Monsters(JsonTemplate.load(filename));
    }

    public Monster generate() {
        Map<String,String> attrs = this.template.fill();
        //LOG.info("Loaded attrs: {}", attrs);
        
        return new Monster(attrs);
    }
}
