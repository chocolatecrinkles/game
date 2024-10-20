package Game;

public class King extends BaseCharacter{
    King(){
        super("King", 400, 150);
    }

    @Override
    public void useSkill1(BaseCharacter target){
        int min = 20, max = 30;
        int damage = (int) (Math.random() * (max - min));
        System.out.println("The King uses Royal Decree! Damage: " + damage);
        attack(target, damage);
    }

    @Override
    public void useSkill2(BaseCharacter target){
        target.mana -= (int) target.mana * 0.5;
        
    }

    @Override
    public void useSkill3(BaseCharacter target){
        target.stun(target);
        System.out.println("The King uses Absolute Authority! Bow down to the king");
        attack(target, 50);
    }
}
