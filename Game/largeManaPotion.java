package Game;

public class largeManaPotion extends Item{
    private int restoreAmount;
    
    public largeManaPotion(){
        super("Large Mana Potion", "Restores 30 Mana" , 45);
        this.restoreAmount = 50;
    }

    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Restoring " + restoreAmount + " HP");
        character.restoreHealth(restoreAmount);
    }
}
