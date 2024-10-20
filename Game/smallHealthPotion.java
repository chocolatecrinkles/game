package Game;

public class smallHealthPotion extends Item{
    private int restoreAmount;

    public smallHealthPotion(){
        super("Small Health Potion", "Restore 15 HP", 10);
        this.restoreAmount = 15;
    }
    
    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Restoring " + restoreAmount + " HP.");
        character.restoreHealth(restoreAmount);
    }

}
