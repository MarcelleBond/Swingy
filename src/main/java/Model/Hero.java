package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Hero extends Character {

    private String heroName;
    private String heroClass;
    private int level;
    private int experience;

   /* public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }*/

    public Hero(int characterX, int characterY, char characterSymbol, int attack, int defence, int hitPoints, String heroName, String heroClass, int level, int experience) {
        super(characterX, characterY, characterSymbol, attack, defence, hitPoints);
        this.heroName = heroName;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return heroName + " " + heroClass + " " + level + " " + experience + " " + getAttack() + " " + getDefense() + " " + getHitPoints();
    }
}
