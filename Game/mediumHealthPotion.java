package Game;

public class mediumHealthPotion extends Item{
    private int restoreAmount;

    public mediumHealthPotion(){
        super("Medium Health Potion", "Restores 30 HP", 45);
        this.restoreAmount = 30;
    }

    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Restoring " + restoreAmount + " HP");
        character.restoreHealth(restoreAmount);
    }
}