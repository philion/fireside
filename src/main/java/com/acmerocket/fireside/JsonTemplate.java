package com.acmerocket.fireside;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTemplate {
    private static final Logger LOG = LoggerFactory.getLogger(JsonTemplate.class);

    public static String DEFAULT_ROOT_NAME = "template";
    
    private static final Pattern KEY_PATTERN = Pattern.compile("@(\\w+)");
    
    private final JsonNode root; 
    
    public JsonTemplate(JsonNode root) {
        this.root = root;
    }
    
    public static JsonTemplate load(String filename) {
        try {
            return load(new File(filename));
        }
        catch (IOException e) {
            LOG.error("Unable to load {}", filename, e);
            return null;
        }
    }

    public static JsonTemplate load(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(file);
        //LOG.info("Loaded JSON: {}", root);
        //LOG.info("Template: {}", root.get("template").get(0));
        return new JsonTemplate(root);
    }
    
    public JsonNode get() {
        return this.get(DEFAULT_ROOT_NAME);
    }
    
    public JsonNode get(String name) {
        JsonNode node = this.root.get(name);
        
        if (node.isArray()) {
            int idx = Utils.random(node.size());
            node = node.get(idx);
        }
        
        return node;
    }

    public List<String> keys(String str) {
        List<String> found = new ArrayList<>();
        
        // parse out @ words
        //LOG.info("Searching {}", str);
        Matcher matcher = KEY_PATTERN.matcher(str);
        while (matcher.find()) {
            found.add(matcher.group(1));
        }
        
        return found;
    }

    public Map<String, String> fill() {
    	HashMap<String,String> attrs = new HashMap<>();
    	String value = this.fill(this.get().asText(), attrs);
    	attrs.put("value", value);
    	return attrs;
    }
    
    public String fill(String tmpl, Map<String,String> attrs) {    
        List<String> keys = this.keys(tmpl);
        // LOG.info("Loaded keys: {}", keys);
        
        String whole = tmpl;
        for (String key : keys) {
            String value = this.get(key).asText();
            
            value = this.fill(value, attrs);
            
            attrs.put(key, value);
            //LOG.info("{} == {}", key, value);
            whole = whole.replace("@"+key, value);
        }
                
        return whole;
    }
}
