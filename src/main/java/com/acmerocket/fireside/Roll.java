package com.acmerocket.fireside;

import java.util.Random;

/**
 * Record of the role of a dice.
 * @author philion
 *
 */
public class Roll implements Comparable<Roll> {
    public enum Type { attack, damage, initiative }
    
    private final Type type;
    private final int value;
    private final Monster source;
    private final Monster target;
    
    private Roll(Type type, int value, Monster source, Monster target) {
        this.type = type;
        this.value = value;
        this.source = source;
        this.target = target;
    }
        
    public static Roll initiative(Monster source) {
        int initiativeVal = d20() + source.movement();
        if (source.isSneaky()) {
            initiativeVal += 2;
        }
        return new Roll(Type.initiative, initiativeVal, source, null);        
    }

    public static Roll attack(Monster source) {
        int value = d20() + source.level();
        return new Roll(Type.attack, value, source, null);
    }

    public static Roll damage(Monster source, Monster target) {
        int damage = roll(source.damage());
        return new Roll(Type.damage, damage, source, target);        
    }
    
    // ----
    
    public boolean hits(Monster target) {
        if (this.type == Type.attack && this.value > target.getAC()) {
            return true;
        }
        return false;
    }
    
    // ----
    
    public static int d20() {
        return d20(1);
    }
    public static int d20(int numDice) {
        return roll(20, numDice);
    }
    
    public static int roll(int sides) {
        return roll(sides, 1);
    }
    public static int roll(int sides, int numDice) {
        int val = 0;
        for (int i = 0; i < numDice; i++) {
            val += RAND.nextInt(sides) + 1; // add 1 *after* roll to make 1-based dice value
        }
        
        return val;
    }
    private static final Random RAND = new Random();

    @Override
    public int compareTo(Roll other) { // this is -1: less, 0: equal, 1: greater
        if (this.type == other.type) {
            return other.value - this.value;
        }
        else {
            return other.type.ordinal() - this.type.ordinal();
        }
    }

    public Monster source() {
        return this.source;
    }
    
    public int value() {
        return value;
    }
    
    public int damage() {
        if (this.type == Type.damage) {
            return this.value();
        }
        return 0;
    }
    
    public String toString() {
        return this.source + " rolls " + this.type + " of " + this.value;
    }
    
    public static Object random(Object[] values) {
        return values[roll(values.length)-1];
    }
}
