package Game;

public class Lamplighter extends BaseCharacter{
    Lamplighter(){
        super("Lamplighter", 120, 70);
    }

    @Override
    public void useSkill1(BaseCharacter target){
        System.out.println("Lamplighter uses Flame Dance! Damage: -10hp");
        attack(target, 10);
    }

    @Override
    public void useSkill2(BaseCharacter target){
        System.out.println("Lamplighter uses Warm Glow! Damage: -15hp");
        attack(target, 15);
    }

    @Override
    public void useSkill3(BaseCharacter target){
        System.out.println("Lampligher uses Ember Shield! Defends and counter with 15hp damage");
        attack(target, 15);
    }
}
