package Game;

public class Clothes2 extends Item{
    private int additionalHp;

    public Clothes2(){
        super("", "Increases maximum HP.", 50);
        additionalHp = 35;
    }

    @Override
    public void applyEffect(MainCharacter character){
        System.out.println("Max HP increasing to 35");
        character.increaseMaxHp(additionalHp);
    }
}
