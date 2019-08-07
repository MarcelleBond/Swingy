package View;

import java.util.Arrays;

public class Lobby {
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displaySavedHeros(String[] heros)
    {
        clearScreen();
        String[] hero;
        System.out.print("======================================================\n");
        System.out.print("          CHOSE YOUR HERO\n");
        System.out.print("======================================================\n");
        System.out.print(" NAME | CLASS | LEVEL | EXP | ATK | DEF | HP\n");
        System.out.print("======================================================\n");
        for (int i = 0; i < heros.length; i++)
        {
            hero = heros[i].split(" ");
            System.out.print("("+ (i + 1) +") " + Arrays.toString(hero));
            System.out.print("\n======================================================\n");

        }
    }

    public static void startUp()
    {
        clearScreen();
        System.out.print("=================================\n");
        System.out.print("Welcome to the land of the  Brave\n");
        System.out.print("=================================\n");
        System.out.print("(1) Create a new hero\n");
        System.out.print("(2) Chose from hero list\n");
    }

    public static void createHero()
    {
        clearScreen();
        System.out.print("=================================\n");
        System.out.print("Please enter your hero name and\n");
        System.out.print("then chose your hero class\n");
        System.out.print("=================================\n");
        System.out.print("Name: ");
    }

    public static void HeroClass()
    {
        System.out.print("\n=================================\n");
        System.out.print("1) MORTAL\n");
        System.out.print("2) GOD\n");
        System.out.print("3) TITAN\n");
        System.out.print("=================================\n");
    }

    public  static void nameTaken()
    {
        System.out.print("Sorry name is already taken.\nTry another name please\nName: ");
    }

    public static void invalidInput() {
        System.out.print("Invalid input.\nTry again please\n");
    }
}
