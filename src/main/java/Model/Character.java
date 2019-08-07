package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    private int characterX;
    private int characterY;
    private char characterSymbol;
    private int attack;
    private int defense;
    private int hitPoints;

 /*   protected Character(int characterX, int characterY, char characterSymbol, int attack, int defense, int hitPoints) {
        this.characterX = characterX;
        this.characterY = characterY;
        this.characterSymbol = characterSymbol;
        this.attack = attack;
        this.defence = defense;
        this.hitPoints = hitPoints;
    }*/

/*    public int getCharacterX() {
        return characterX;
    }

    public void setCharacterX(int characterX) {
        this.characterX = characterX;
    }

    public int getCharacterY() {
        return characterY;
    }

    public void setCharacterY(int characterY) {
        this.characterY = characterY;
    }

    public char getCharacterSymbol() {
        return characterSymbol;
    }

    public void setCharacterSymbol(char characterSymbol) {
        this.characterSymbol = characterSymbol;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defence;
    }

    public void setDefense(int defence) {
        this.defence = defence;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }*/

    @Override
    public String toString() {
        return "Character{" +
                "characterX=" + characterX +
                ", characterY=" + characterY +
                ", characterSymbol=" + characterSymbol +
                ", attack=" + attack +
                ", defence=" + defense +
                ", hitPoints=" + hitPoints +
                '}';
    }
}
