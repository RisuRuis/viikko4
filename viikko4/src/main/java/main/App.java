package main;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        String file;
        Cave cave = null;
        // Player newPlayer = null;

        System.out.print("Anna pelaajan nimi: ");
        String name = sc.nextLine();
        // newPlayer = new Player(name);
        // System.out.println(name);


        cave = new Cave(new Player(name));


        boolean exit = false;


        while (!exit) {
            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta ohjelma");


            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Anna hirviön tyyppi: ");
                        String type = sc.nextLine();
                        System.out.println("Anna hirviön elämän määrä numerona: ");
                        int health = Integer.parseInt(sc.nextLine());

                        cave.addMonster(new Monster(type, health));
                        break;
                    case 2:
                        cave.listMonsters();
                        
                        break;
                    case 3:
                        System.out.println("Valitse hirviö, johon hyökätä: ");
                        cave.listMonsters();
                        int id = Integer.parseInt(sc.nextLine());
                        cave.attackMonster(id);
                        break;
                    case 4:
                        System.out.println("Anna tiedoston nimi, josta peli tallentaa: ");
                        file = sc.nextLine();
                        cave.saveCave(file);
                        break;
                    case 5:
                        System.out.println("Anna tiedoston nimi, josta peli ladataan: ");
                        file = sc.nextLine();
                        try {
                            Cave loaded = Cave.loadCave(file);
                            cave = loaded;
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                        
                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                    }
            }







        }
    



    sc.close();
    }
}
