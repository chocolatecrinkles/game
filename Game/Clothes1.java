package Game;

public class Clothes1 extends Item{
    private int additionalHp;

    public Clothes1(){
        super("", "Increases maximum HP.", 30);
        additionalHp = 20;
    }

    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Max HP increasing to 20");
        character.increaseMaxHp(additionalHp);
    }
}
