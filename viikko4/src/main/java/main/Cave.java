package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Cave implements Serializable {
    private ArrayList<Monster> monsters = new ArrayList<>();
    public Player player;

    public Cave(Player player) {
        this.player = player;
    }


    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public Monster getMonsterById(int id) {
        return monsters.get(id);
    }

    public void listMonsters() {
        int i = 1;
        if (monsters.isEmpty()) {
            System.out.println("Luola on tyhjä.");
        } 
        System.out.println("Luolan hirviöt:");
        for (Monster monster : monsters) {
            monster.printInfo(i);
            i++;

        }
    }

    public void attackMonster(int numero) {
        int id = numero - 1;
        Monster m = monsters.get(id);
        boolean alive = player.attack(m);

        if (!alive) {
            monsters.remove(id);
        }
    }

    public void saveCave(String file) {
        try {
            ObjectOutputStream caveWriter = new ObjectOutputStream(new FileOutputStream(file));
            caveWriter.writeObject(this);
            caveWriter.close();
            System.out.println("Peli tallennettiin tiedostoon" + file + ".");
        } catch (IOException e) {
            System.out.println("Pelin tallentaminen ei onnistunut");
            e.printStackTrace();
        }
        
    }

    public static Cave loadCave(String file) throws ClassNotFoundException {
        try {
            ObjectInputStream caveReader = new ObjectInputStream(new FileInputStream(file));
            Cave loadedCave = (Cave) caveReader.readObject();
            caveReader.close();
            System.out.println("Peli ladattu tiedostosta " + file + ". Tervetuloa takaisin, " + loadedCave.player.getName() + ".");
            return loadedCave;
        } catch (IOException e) {
            System.out.println("Pelin lataaminen ei onnistunut");
            e.printStackTrace();
            return null;
        }
    }

}
