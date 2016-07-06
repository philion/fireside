package com.acmerocket.fireside;

public enum CharClass {
    Cleric,
    Fighter,
    Rogue,
    Wizard,
    Barbarian,
    Bard,
    Druid,
    Monk,
    Paladin,
    Ranger,
    Sorcerer,
    Warlock;
    
    public boolean isSneaky() {
        if (this == Bard || this == Ranger || this == Rogue) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isSmashy() {
        if (this == Barbarian || this == Fighter || this == Monk || this == Paladin) {
            return true;
        }
        else {
            return false;
        }  
    }
    
    public boolean isMagical() {
        if (this == Cleric || this == Druid || this == Sorcerer || this == Warlock || this == Wizard) {
            return true;
        }
        else {
            return false;
        }  
    }
    
    public int hitpoints() {
        if (isSmashy()) return 10;
        if (isSneaky()) return 8;
        if (isMagical()) return 6;
        return 4;
    }
}
