package com.acmerocket.fireside;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Brawl implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Brawl.class);

    private final Monster[] compatants;
    
    public Brawl(int size) {
        Monster[] monsters = new Monster[size];
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = Monsters.load().generate();
        }
        this.compatants = monsters;
    }
    
    public Brawl(Monster...monsters) {
        this.compatants = monsters;
    }
    
    @Override
    public void run() {
        List<Monster> monsters = this.initiative(this.compatants);
        int living = monsters.size();
        while (living > 1) {
            // fight!
            for (Monster source : monsters) {
                Monster target = source.selectTarget(monsters);
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

    protected List<Monster> initiative(Monster[] monsterAry) {
        List<Roll> initRolls = new ArrayList<>(monsterAry.length);
        
        for (Monster monster : monsterAry) {
            initRolls.add(Roll.initiative(monster));            
        }
        initRolls.sort(null);
                
        List<Monster> fighters = new ArrayList<>(monsterAry.length);
        for (Roll roll : initRolls) {
            fighters.add(roll.source());
            LOG.trace("{}", roll);
        }
                
        return fighters;
    }
}
