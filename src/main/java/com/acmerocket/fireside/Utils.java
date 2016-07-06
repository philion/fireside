package com.acmerocket.fireside;

import java.util.Random;

public class Utils {
    
    private static final Random RAND = new Random();
    
    public static int random(int max) {
        return RAND.nextInt(max);
    }
    
    public static int roll(int sides) {
        return roll(sides, 1);
    }
    
    public static int roll(int sides, int numDice) {
        int val = 0;
        for (int i = 0; i < numDice; i++) {
            val += random(sides) + 1;
        }
        
        return val;
    }

    public static int d20() {
        return d20(1);
    }
    
    public static int d20(int numDice) {
        return roll(20, numDice);
    }
}
