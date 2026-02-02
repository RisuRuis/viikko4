package main;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int playerDamage = 10;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public boolean attack(Monster target) {
        System.out.println(name + " hyökkää " + target.getType() + " hirviöön!" );
        return target.takeDamage(playerDamage);
    }
}
