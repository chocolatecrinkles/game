package Game;

public class smallStrengthItem extends Item{
    private double strengthIncrease = 0.25;

    public smallStrengthItem(){
        super("Small Strength Item", "Increases strength to 25%", 30);
    }

    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Increasing strength to 25%");
        character.increaseStrength(strengthIncrease);
    }
}
