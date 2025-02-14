public class ManaPotion extends Item{
    public enum Size{
        SMALL, MEDIUM, LARGE
    }
    private Size size;
    private int restoreAmount;

    public ManaPotion(Size size){
        super(size + " Mana Potion", "Restores mana based on size", getCost(size));
        this.size = size;
        this.restoreAmount = getRestoreAmount(size);
    }

    private static int getCost(Size size){
        switch(size){
            case SMALL: return 15;
            case MEDIUM: return 25;
            case LARGE: return 35;
            default: return 15;
        }
    }

    private int getRestoreAmount(Size size){
        switch(size){
            case SMALL: return 10;
            case MEDIUM: return 20;
            case LARGE: return 30;
            default: return 10;
        }
    }

    @Override
    public void applyEffect(MainChar character){
        System.out.println("Restoring " + restoreAmount + " Mana!");
        character.setCurrMana(character.getCurrMana() + restoreAmount);
    }
}