package Game;

public class smallManaPotion extends Item{
    private int restoreAmount;
    
    public smallManaPotion(){
        super("Small Mana Potion", "Restores 20 Mana" , 15);
        this.restoreAmount = 20;
    }

    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Restoring " + restoreAmount + " HP");
        character.restoreHealth(restoreAmount);
    }
}
