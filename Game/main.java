package Game;
import java.util.ArrayList;
import java.util.*;
public class main {
    public static void main(String[] args){
        String name;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        name = sc.nextLine();

        MainCharacter player = new MainCharacter(name);
        // System.out.println("--------------------------");
        // System.out.println("SKILLS: ");
        // System.out.println("Skill 1: Rose Petal Strike - Deals 8 damage.");
        // System.out.println("Skill 2: Rose Embrace - (Heals 20% of max health)");
        // System.out.println("Skill 3: Fox's Trick");

        Drunkard drunkard = new Drunkard();
        smallHealthPotion sHealthPotion = new smallHealthPotion();

        player.showStats();
        drunkard.useSkill1(player);
        player.showStats();
        player.useSkill1(drunkard); 
        drunkard.showStats();

        drunkard.useSkill2(player);
        drunkard.showStats();

        drunkard.useSkill3(player);
        drunkard.showStats();
        
        player.addItem(sHealthPotion);
        player.displayInventory();
        // IMPLEMENT GAIN XP WHEN ATTAVKING(RANDOM VALUES WHEN MO GAIN OG XP)
        // MATH THE DAMAGE

        // player.showStats();
        // player.useSkill1(drunkard);

        // player.receiveDamage(15);
        
        // player.useSkill2(drunkard);
        // player.gainExp(20);
        // player.showStats();

        // player.receiveDamage(23);
        // player.receiveDamage(12);
        // player.useSkill3(drunkard);

        // player.useSkill2(drunkard);

        // player.showStats();

        //if maconvert ang xp to currency like roses to petals, mazero na sad ang petals
        // paguse sa currency
        // dodge mechanics
        // overloading sa skills
        // default stats
        // defense mechanism
    }
}
