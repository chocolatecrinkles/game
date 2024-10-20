package Game;

public class largeHealthPotion extends Item{
    private int restoreAmount;

    public largeHealthPotion(){
        super("Large Health Potion", "Restores 30 HP", 50);
        this.restoreAmount = 40;
    }

    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Restoring " + restoreAmount + " HP");
        character.restoreHealth(restoreAmount);
    }
}
