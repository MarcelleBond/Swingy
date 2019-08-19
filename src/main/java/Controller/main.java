package Controller;

import Model.Enemy;
import Model.ReadFile;
import Model.Hero;
import Model.WriteFile;
import View.Battle;
import View.DrawMap;
import View.Lobby;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class main {
    public static void main(String[] args) {
        String input;
        Hero hero = null;
        HeroSetup setup = new HeroSetup();
        /////////////////////////HERO CREATION///////////////////////////
        try {
            ReadFile file = new ReadFile("./src/main/HeroDB.txt");
            String[] heroesString = file.OpenFile();
            Scanner scanner = new Scanner(System.in);
            Lobby.startUp();
            while (!(input = scanner.nextLine()).equalsIgnoreCase("q")) {
                if (input.equalsIgnoreCase("1")) {
                    Lobby.createHero();
                    hero = setup.createHero(heroesString);
                    break;
                } else if (input.equalsIgnoreCase("2")) {
                    Lobby.displaySavedHeros(heroesString);
                    hero = setup.pickHero(heroesString);
                    break;
                } else
                    Lobby.invalidInput();
            }
            if (hero != null) {
                int size = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
                hero.setSize(size);
                ArrayList<Enemy> villains = genVill(size, hero);

                /////////////////////////////////////GAME START////////////////////////////
                DrawMap.draw(hero, villains);
                while (!(input = scanner.nextLine()).equalsIgnoreCase("q")) {
                    int tempX = hero.getCharacterX();
                    int tempY = hero.getCharacterY();
                    if (input.equalsIgnoreCase("w")) {
                        hero.setCharacterY(hero.getCharacterY() - 1);
                    } else if (input.equalsIgnoreCase("s")) {
                        hero.setCharacterY(hero.getCharacterY() + 1);
                    } else if (input.equalsIgnoreCase("d")) {
                        hero.setCharacterX(hero.getCharacterX() + 1);
                    } else if (input.equalsIgnoreCase("a")) {
                        hero.setCharacterX(hero.getCharacterX() - 1);
                    } else
                        Lobby.invalidInput();
                    for (int i = 0; i < villains.size(); i++) {
                        if (villains.get(i).getCharacterX() == hero.getCharacterX() && villains.get(i).getCharacterY() == hero.getCharacterY())
                        {
                            villains = FightOrRun(hero, villains, heroesString, tempX, tempY);
                            size = hero.getSize();
                        }
                    }
                    DrawMap.draw(hero, villains);
                    if (hero.getCharacterX() == 0 || hero.getCharacterX() == size - 1 || hero.getCharacterY() == 0 || hero.getCharacterY() == size - 1) {
                        Battle.winner();
                        break;
                    }

                }
            }
            ////////////////////////HERO SAVE//////////////////////
            setup.saveHeroes(hero, heroesString);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<Enemy> FightOrRun(Hero hero, ArrayList<Enemy> villains, String[] heroesString, int lastX, int lastY) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < villains.size(); i++) {
            if (villains.get(i).getCharacterX() == hero.getCharacterX() && villains.get(i).getCharacterY() == hero.getCharacterY()) {
                Battle.fightOrRun(villains.get(i));

                while (true) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("F")) {
                        Battle.fightStart();
                        villains = battle(hero, villains, heroesString, i);
                        break;
                    } else if (input.equalsIgnoreCase("R")) {
                        Random randomNumGenerator = new Random();
                        int chance = randomNumGenerator.nextInt(100);
                        if ((chance % 2) == 0) {
                            hero.setCharacterX(lastX);
                            hero.setCharacterY(lastY);
                        } else {
                            Battle.fightStart();
                            villains = battle(hero, villains, heroesString, i);
                        }
                        break;
                    } else
                        Lobby.invalidInput();
                }
            }
        }
        return villains;
    }

    private static ArrayList<Enemy> battle(Hero hero, ArrayList<Enemy> villains, String[] heroesString, int i) {
        Random randomNumGenerator = new Random();
        int hit = ThreadLocalRandom.current().nextInt(0, 1);
        while (true) {
            if (hero.getHitPoints() < 1) {
                Battle.fightStats(villains.get(i), hero);
                Battle.gameOver();
                HeroSetup setup = new HeroSetup();
                hero.setHitPoints(1000);
                if (hero.getDefense() <= 0)
                    hero.setDefense(0);
                setup.saveHeroes(hero, heroesString);
                System.exit(0);
            } else if (villains.get(i).getHitPoints() < 1) {
                Battle.fightStats(villains.get(i), hero);
                hero.setExperience(hero.getExperience() + 200);
                if (hero.getDefense() <= 0)
                    hero.setDefense(0);
                villains.remove(i);
                int chance = randomNumGenerator.nextInt(100);
                if ((chance % 2) == 0) {
                    Battle.artifacts();
                    Scanner scanner = new Scanner(System.in);
                    String input;
                    while (!(input = scanner.nextLine()).equalsIgnoreCase("q")) {
                        if (input.equalsIgnoreCase("1")) {
                            hero.setHitPoints(hero.getHitPoints() + 200);
                            break;
                        } else if (input.equalsIgnoreCase("2")) {
                            hero.setDefense(hero.getDefense() + 200);
                            break;
                        } else if (input.equalsIgnoreCase("3")) {
                            hero.setAttack(hero.getAttack() + 200);
                            break;
                        } else
                            Lobby.invalidInput();
                    }
                }
                break;
            } else {
                if (hit == 1) {
                    if (hero.getDefense() > 0)
                        hero.setDefense(hero.getDefense() - villains.get(i).getAttack());
                    else
                        hero.setHitPoints(hero.getHitPoints() - villains.get(i).getAttack());
                    hit = 0;
                } else {
                    if (villains.get(i).getDefense() > 0)
                        villains.get(i).setDefense(villains.get(i).getDefense() - hero.getAttack());
                    else
                        villains.get(i).setHitPoints(villains.get(i).getHitPoints() - hero.getAttack());
                    hit = 1;
                }
            }

        }
        if (hero.getExperience() >= (((hero.getLevel() + 1) * 1000) + (Math.pow(hero.getLevel(), 2) * 450))) {
            Battle.levelUp();
            hero.setLevel(hero.getLevel() + 1);
            int size = (hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
            hero.setSize(size);
            hero.setCharacterX(size / 2);
            hero.setCharacterY(size / 2);
            System.out.println("PosY" + hero.getCharacterY());
            System.out.println("PosX" + hero.getCharacterX());
            villains = genVill(size, hero);
        }
        return villains;
    }

    private static ArrayList<Enemy> genVill(int size, Hero hero) {
        ArrayList<Enemy> villains = new ArrayList<Enemy>();
        for (int i = 0; i < size; i++) {
            Random randomNumGenerator = new Random();
            villains.add(new Enemy(randomNumGenerator.nextInt(size), randomNumGenerator.nextInt(size), ThreadLocalRandom.current().nextInt(hero.getAttack() - 300, hero.getAttack() - 250), ThreadLocalRandom.current().nextInt(hero.getDefense() - 90, hero.getDefense() - 75), 1000));
        }
        return villains;
    }
}

