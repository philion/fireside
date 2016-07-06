package com.acmerocket.fireside;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Monster {
    private static final Logger LOG = LoggerFactory.getLogger(Monster.class);

    private final Race race;
    private final CharClass clss;
    private final String mood;
    private final String description;
    
    private Armor armor = Armor.random();
    private Weapon weapon = Weapon.random();
    
    private int experience;
    private int hitpoints;
    
    public Monster(Map<String, String> attrs) {
        this.race = Race.valueOf(attrs.get("race"));
        this.clss = CharClass.valueOf(attrs.get("dclass"));
        this.description = attrs.get("value");
        this.mood = attrs.get("adjective");
        
        this.hitpoints = this.clss.hitpoints();
    }

    /**
     * Select a target from a list of enemies
     * @return
     */
    public Monster selectTarget(List<Monster> enemies) {
        // select highest hitpoints, except me.
        
        Monster target = null;
        int hp = Integer.MAX_VALUE;
        for (Monster enemy : enemies) {
            if (enemy.hp() < hp  && enemy != this) {
                target = enemy;
                hp = enemy.hp();
            }
        }
        
        return target;
    }

    public int hp() {
        return this.hitpoints;
    }
    
    public boolean isAlive() {
        return this.hitpoints > 0;
    }
    
    public void takeDamage(Roll roll) {
        this.hitpoints -= roll.damage();
        if (this.hitpoints <= 0) {
            LOG.debug("{} has died from {}", this, roll);
        }
    }
    
    public String toString() {
        return this.mood + " " + this.race + " " + this.clss;
    }
    
    public String description() {
        return this.description;
    }
    
    public boolean isSneaky() {
        return this.clss.isSneaky();
    }

    public int movement() {
        return this.armor.movement;
    }

    public int level() {
        return this.experience / 1000 + 1;
    }

    public int getAC() {
        return this.armor.ac;
        // TODO Add shield
    }
    
    public int damage() {
        return this.weapon.damage();
    }

    public void takeExperience(Roll damage) {
        this.experience += damage.value();
    }
}
