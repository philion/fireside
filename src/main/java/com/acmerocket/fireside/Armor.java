package com.acmerocket.fireside;

public enum Armor {
    Unarmored(10, 12),
    Leather(12, 9), 
    Chainmail(14, 6), 
    Platemail(16, 3), 
    Shield(1, -1); 
    
    public final int ac;
    public final int movement;
    
    private Armor(int ac, int mvt) {
        this.ac = ac;
        this.movement = mvt;
    }
    
    public static Armor random() {
        int idx = Utils.random(Armor.values().length - 1); // skip shield
        return values()[idx];
    }
}
