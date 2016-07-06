package com.acmerocket.fireside;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App  {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    
    public static void main( String[] args ) {
        LOG.info("Hello world!");
        
        Brawl brawl = new Brawl(2);
        brawl.run(); // synch, for now
        
        
        // Generate 2 characters
        // make them fight until one has zero hit point
    }
    
    
}
