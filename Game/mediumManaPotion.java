package Game;

public class mediumManaPotion extends Item{
    private int restoreAmount;
    
    public mediumManaPotion(){
        super("Small Mana Potion", "Restores 30 Mana" , 25);
        this.restoreAmount = 30;
    }

    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Restoring " + restoreAmount + " HP");
        character.restoreHealth(restoreAmount);
    }
}
