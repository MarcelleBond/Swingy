package View;

import Model.Enemy;
import Model.Hero;

import java.util.ArrayList;

public class DrawMap {
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void draw(Hero player, ArrayList<Enemy> villain)
    {
        int check;
        int mapSize =  (player.getLevel()-1)*5+10-(player.getLevel()%2);
        clearScreen();
        for(int i = 0; i < mapSize; i++)
        {
            for(int j = 0; j < mapSize; j++)
            {
                if (player.getCharacterX() == j && player.getCharacterY() == i)
                    System.out.print(player.getCharacterSymbol());
                else if((check = checkVillains(villain, j, i)) != -1)
                    System.out.print(villain.get(check).getCharacterSymbol());
                else
                    System.out.print('.');
            }
            System.out.print('\n');
        }
        System.out.print("Hero Level: " + player.getLevel() + " || Hero Attack: " + player.getAttack() + " || Hero Defense: " + player.getDefense() + " || Hero Hit Points: " + player.getHitPoints() + " || Hero EXP: " + player.getExperience() + "\n");
    }

    private static int checkVillains(ArrayList<Enemy> villains, int posX, int posY)
    {
        for (int i = 0; i < villains.size(); i++)
        {
            if(villains.get(i).getCharacterX() == posX && villains.get(i).getCharacterY() == posY)
                return i;
        }
        return -1;
    }
}
