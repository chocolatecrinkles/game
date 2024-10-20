package Game;

public class Clothes3 extends Item{
    private int additionalHp;

    public Clothes3(){
        super("", "Increases maximum HP.", 65);
        additionalHp = 50;
    }

    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Max HP increasing to 50");
        character.increaseMaxHp(additionalHp);
    }
}
