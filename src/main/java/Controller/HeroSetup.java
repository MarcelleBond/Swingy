package Controller;

import Model.Hero;
import Model.WriteFile;
import View.Lobby;

import java.io.IOException;
import java.util.Scanner;

public class HeroSetup {

    public static Hero createHero(String[] heroString)
    {
        int mapSize =  (1 - 1)*5+10-(1 % 2);
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            name = scanner.nextLine();
            name = name.replaceAll(" ", "");
            if (!checkName(name, heroString))
                break;
            Lobby.nameTaken();
        }
        String classType;
        Lobby.HeroClass();
        while(!(classType = scanner.nextLine()).equalsIgnoreCase("q"))
        {
            if (classType.equalsIgnoreCase("1"))
                return new Hero(mapSize/2, mapSize/2,'H', 500, 1500, 1000, name, "MORTAL", 1, 1000);
            else if (classType.equalsIgnoreCase("2"))
                return new Hero(mapSize/2, mapSize/2,'H', 800, 1800, 1000, name, "GOD", 1, 1000);
            else if (classType.equalsIgnoreCase("3"))
                return new Hero(mapSize/2, mapSize/2,'H', 1300, 2300, 1000, name, "TITAN", 1, 1000);
            else
                Lobby.invalidInput();
        }
        if (classType.equalsIgnoreCase("q"))
            System.exit(0);
        return null;
    }

    private static boolean checkName(String name, String[] heroString) {
        for (int i = 0; i <  heroString.length; i++)
        {
            String[] hero = heroString[i].split(" ");
            if (hero[0].equals(name))
                return true;
        }
        return false;
    }

    public static Hero pickHero(String[] heroes)
    {
        Scanner scanner = new Scanner(System.in);
        String str;
        String hero;
        String[] details;
        int mapSize;
        while (true)
        {
            if ((str = scanner.nextLine()).matches("[1-9]+") && Integer.parseInt(str) - 1 < heroes.length)
            {
                hero = heroes[Integer.parseInt(str) - 1];
                details = hero.split(" ");
                mapSize =  (Integer.parseInt(details[2]) - 1)*5+10-(Integer.parseInt(details[2]) % 2);
                return new Hero(mapSize/2, mapSize/2, 'H', Integer.parseInt(details[4]),Integer.parseInt(details[5]),Integer.parseInt(details[6]), details[0], details[1],Integer.parseInt(details[2]), Integer.parseInt(details[3]));
            }
            Lobby.invalidInput();
        }
    }

    public void saveHeroes(Hero hero, String[] heroesString)
    {
        if (hero != null)
        {
            try {
                WriteFile data = new WriteFile("./src/main/HeroDB.txt", false);
                data.writeToFile(hero.toString());
                data = new WriteFile("./src/main/HeroDB.txt", true);
                for (int i = 0; i <  heroesString.length; i++)
                {
                    String[] check = heroesString[i].split(" ");
                    if (check[0].equals(hero.getHeroName()))
                        continue;
                    data.writeToFile(heroesString[i]);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
