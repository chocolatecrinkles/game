package Game;

public class Rose extends Item{
    private int restoreAmount;

    public Rose(){
        super("Rose", "Restore 10 HP", 8);
        this.restoreAmount = 10;
    }

    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Restoring " + restoreAmount + " HP.");
        character.restoreHealth(restoreAmount);
    }
}
    

