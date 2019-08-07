package View;

import Model.Enemy;
import Model.Hero;

public class Battle {
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void fightStart()
    {
        System.out.print("READY!\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("FIGHT!\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void fightStats(Enemy villain, Hero player)
    {
        System.out.print("\nHero" + ": " + player.getHeroName() + "\nHero Attack: " + player.getAttack() + "\nHero Defense: " + player.getDefense() + "\nHero Hit Points: " + player.getHitPoints());
        System.out.print("\nVillain Attack: " + villain.getAttack() + "\nVillain Defense: " + villain.getDefense() + "\nVillain Hit Points: " + villain.getHitPoints());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void fightOrRun(Enemy villain)
    {
        System.out.print("Villain Attack: " + villain.getAttack() + "\nVillain Defense: " + villain.getDefense() + "\nVillain Hit Points: " + villain.getHitPoints());
        System.out.println("\nDo you want to fight or run \n (F) FIGHT \n (R) RUN \n");
    }

    public  static void winner()
    {
        System.out.print("YOU HAVE WON THE BATTLE\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("BUT THE WAR CONTINUES\n");

    }

    public static void artifacts()
    {
        System.out.print("\nTHE VILLAIN DROPPED ARTIFACTS\n");
        System.out.print("PLEASE CHOSE ONE TO TAKE\n");
        System.out.print("(1) HELM\n");
        System.out.print("(2) ARMOR\n");
        System.out.print("(3) WEAPON\n");
    }
    public static void gameOver()
    {
        clearScreen();
        System.out.println("\n" +
                "  ________                                                  \n" +
                " /  _____/_____    _____   ____     _______  __ ___________ \n" +
                "/   \\  ___\\__  \\  /     \\_/ __ \\   /  _ \\  \\/ // __ \\_  __ \\\n" +
                "\\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  (  <_> )   /\\  ___/|  | \\/\n" +
                " \\______  (____  /__|_|  /\\___  >  \\____/ \\_/  \\___  >__|   \n" +
                "        \\/     \\/      \\/     \\/                   \\/       \n");
    }

    public static void levelUp() {
        System.out.print("\nCONGRATULATIONS YOU LEVELED UP\n");
    }
}
