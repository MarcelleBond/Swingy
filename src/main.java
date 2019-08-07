import java.util.Scanner;

class Character
{
	private int characterX;
	private int characterY;
	private char characterSymbol;
	private int HP;
	private int defence;
	private int attack;
	private int hitPoints;
	private int experience;
	private int level;

	protected int getLevel() {
		return level;
	}

	protected void setLevel(int level) {
		this.level = level;
	}

	private boolean lifeStatus = true;

	protected int getHitPoints() {
		return hitPoints;
	}

	protected void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	protected int getExperience() {
		return experience;
	}

	protected void setExperience(int experience) {
		this.experience = experience;
	}

	protected boolean getLifeStatus()
	{
		return lifeStatus;
	}

	protected void setLifeStatus(boolean status)
	{
		lifeStatus = status;
	}
	protected int getHP() {
		return HP;
	}

	protected void setHP(int HP) {
		this.HP = HP;
	}

	protected int getDefence() {
		return defence;
	}

	protected void setDefence(int defence) {
		this.defence = defence;
	}

	protected int getAttack() {
		return attack;
	}

	protected void setAttack(int attack) {
		this.attack = attack;
	}

	protected Character(int characterX, int characterY, char characterSymbol, int HP, int defence, int attack) {
		this.characterX = characterX;
		this.characterY = characterY;
		this.characterSymbol = characterSymbol;
		this.HP = HP;
		this.defence = defence;
		this.attack = attack;
		experience = 0;
		level = 1;
	}

	protected int getCharacterX() {
		return characterX;
	}

	protected void setCharacterX(int characterX) {
		this.characterX = characterX;
	}

	protected int getCharacterY() {
		return characterY;
	}

	protected void setCharacterY(int characterY) {
		this.characterY = characterY;
	}

	protected char getCharacterSymbol() {
		return characterSymbol;
	}

	protected void setCharacterSymbol(char characterSymbol) {
		this.characterSymbol = characterSymbol;
	}
}

class Hero extends Character {

	public Hero(int characterX, int characterY, char characterSymbol, int HP, int defence, int attack) {
		super(characterX, characterY, characterSymbol, HP, defence, attack);
	}
}

class Villain extends Character
{
	public Villain(int characterX, int characterY, char characterSymbol, int HP, int defence, int attack) {
		super(characterX, characterY, characterSymbol, HP, defence, attack);
	}
}

public class main {
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	/*public static void main(String[] args) {
		String input;
		int tempX;
		int tempY;
		int villainCount = 5;
		Scanner scanner = new Scanner(System.in);
		Villain villain = new Villain(1,2,'V',50,50,50);
		HeroSetup player = new HeroSetup(9/2, 9/2, 'H',100,100,50);
		*//*ArrayList<Villain> villain = new ArrayList<Villain>();
		for (int i = 0; i < villainCount; i++ )
		{
			villain.add(new Villain(1,2,'V',50,50,50));
		}*//*

		int mapsize = (player.getLevel()-1)*5+10-(player.getLevel() %2);

		while (!(input = scanner.nextLine()).equalsIgnoreCase("q"))
			{
				clearScreen();
				tempX = player.getCharacterX();
				tempY = player.getCharacterY();
				if (input.equalsIgnoreCase("w"))
				{
					player.setCharacterY(player.getCharacterY() - 1);
				}
				else if (input.equalsIgnoreCase("s"))
				{
					player.setCharacterY(player.getCharacterY() + 1);
				}
				else if (input.equalsIgnoreCase("d"))
				{
					player.setCharacterX(player.getCharacterX() + 1);
				}
				else if (input.equalsIgnoreCase("a"))
				{
					player.setCharacterX(player.getCharacterX() - 1);
				}
				*//*else
				{
					System.out.print(input);
//					System.out.println("\n");
				}*//*
				for(int i = 0; i < mapsize; i++)
				{
					for(int j = 0; j < mapsize; j++)
					{
						if (player.getCharacterX() == j && player.getCharacterY() == i)
							System.out.print(player.getCharacterSymbol());
						else if(villain.getCharacterX() == j && villain.getCharacterY() == i && villain.getLifeStatus())
							System.out.print(villain.getCharacterSymbol());
						else
							System.out.print('.');
					}
					System.out.print('\n');
				}
				if (((player.getCharacterX() + 1 == villain.getCharacterX() && player.getCharacterY() == villain.getCharacterY())
						|| (player.getCharacterX() - 1 == villain.getCharacterX() && player.getCharacterY() == villain.getCharacterY())
						|| (player.getCharacterY() + 1 == villain.getCharacterY() && player.getCharacterX() == villain.getCharacterX())
						|| (player.getCharacterY() - 1 == villain.getCharacterY() && player.getCharacterX() == villain.getCharacterX())) && villain.getLifeStatus())
				{
					System.out.println("Do you want to fight or run \n (F) FIGHT \n (R) RUN \n");
					input = scanner.nextLine();
					if (input.equalsIgnoreCase("F"))
					{
						System.out.println("Lets Fight Bitch\n");
						while(true)
						{
							if (player.getHP() < 1) {
								System.out.println("GAME OVER");
								System.exit(0);
							}
							else if (villain.getHP() < 1)
							{
								villain.setLifeStatus(false);
								break;
							}
							 else
							{
								if (player.getDefence() > 0)
									player.setDefence(player.getDefence() - villain.getAttack());
								else
									player.setHP(player.getHP() - villain.getAttack());
								if (villain.getDefence() > 0)
									villain.setDefence(villain.getDefence() - player.getAttack());
				                else
				                	villain.setHP(villain.getHP() - player.getAttack());
							}
						}
					}
					else if(input.equalsIgnoreCase("R"))
					{
						player.setCharacterX(tempX);
						player.setCharacterY(tempY);
					}
				}
			}
	}*/
}
