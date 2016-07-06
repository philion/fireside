package com.acmerocket.fireside;

import java.util.HashMap;
import java.util.Map;

public class Weapon {
     public enum Type {
         small(4), ranged(6), medium(8), large(10);
         
         private int damage;
         private Type(int dmg) { this.damage = dmg; }
         public int damage() { return damage; }
     }
     
     private static final Map<String,Type> names = new HashMap<>();
     static {
         names.put("dagger", Type.small);
         names.put("sling", Type.small);
         names.put("rock", Type.small);
         names.put("broken bottle", Type.small);
         
         names.put("bow", Type.ranged); 
         names.put("crossbow", Type.ranged); 
         names.put("thrown", Type.ranged); 
         names.put("javelin", Type.ranged);
         
         names.put("sword", Type.medium);
         names.put("mace", Type.medium); 
         names.put("axe", Type.medium); 
         names.put("bag-ass club", Type.medium);
         
         names.put("polearm", Type.large); 
         names.put("greatsword", Type.large);
         names.put("your mom", Type.large);
     }
     
     private String name;
     private Type type;
     
     private Weapon(String name, Type type) {
         this.name = name;
         this.type = type;
     }
     
     public String toString() {
         return this.name;
     }
     
     public int damage() {
         return this.type.damage;
     }

    public static Weapon random() {
        String name = Roll.random(names.keySet().toArray()).toString();
        Type type = names.get(name);
        return new Weapon(name, type);
    }
}
