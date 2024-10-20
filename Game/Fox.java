package Game;

public class Fox extends BaseCharacter{
    public Fox(){
        super("Fox", 90, 60);
    }

    @Override
    public void useSkill1(BaseCharacter target){
        int min = 10, max = 15;
        int damage = (int) (Math.random() * (max - min));
        System.out.println("Fox uses Foxy Maneuver! Damage: -" + damage + "hp");
        attack(target, damage);

    }

    @Override
    public void useSkill2(BaseCharacter target){
        System.out.println("Fox uses Foxy Agility! Damage: -5");
        attack(target, 5);
    }

    @Override
    public void useSkill3(BaseCharacter target){
        System.out.println("Fox uses Foxy Quirky! Damage: ");
        attack(target, 0);
    }
}
