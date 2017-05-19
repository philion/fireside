package com.acmerocket.fireside;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Brawl implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Brawl.class);

    private final Creature[] compatants;
    
    public Brawl(int size) throws IOException {
        Creature[] monsters = new Creature[size];
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = Creatures.instance().generate();
        }
        this.compatants = monsters;
    }
    
    public Brawl(Creature...monsters) {
        this.compatants = monsters;
    }
    
    @Override
    public void run() {
        List<Creature> creatures = this.initiative(this.compatants);
        int living = creatures.size();
        while (living > 1) {
            // fight!
            for (Creature source : creatures) {
                Creature target = source.selectTarget(creatures);
                Roll attack = Roll.attack(source);
                if (attack.hits(target)) {
                    Roll damage = Roll.damage(source, target);
                    LOG.info("Hit! {} against AC-{}", attack, target.getAC());
                    
                    target.takeDamage(damage);
                    LOG.info("{} down to {}hp, after {}", target, target.hp(), damage);
                    
                    source.takeExperience(damage);
                    
                    if (! target.isAlive()) {
                        LOG.info("{} killed {}", source, target);
                        living--;
                    }
                }
                else {
                    LOG.info("miss: {}", attack);
                }
            }
        }
    }

    protected List<Creature> initiative(Creature[] monsterAry) {
        List<Roll> initRolls = new ArrayList<>(monsterAry.length);
        
        for (Creature creature : monsterAry) {
            initRolls.add(Roll.initiative(creature));            
        }
        initRolls.sort(null);
                
        List<Creature> fighters = new ArrayList<>(monsterAry.length);
        for (Roll roll : initRolls) {
            fighters.add(roll.source());
            LOG.trace("{}", roll);
        }
                
        return fighters;
    }
}
