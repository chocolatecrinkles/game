package Game;

public class VainMan extends BaseCharacter{
    VainMan(){
        super("Vain Man", 250, 100);
    }

    @Override
    public void useSkill1(BaseCharacter target){
        int damage;

        do{
            damage = (int) (Math.random() * 51);
        }while(damage < -1 && damage > 11);

        System.out.println("Vain Man uses Fleeting Flame! Damage: " + damage + "hp");
        attack(target, damage);
    }

    @Override
    public void useSkill2(BaseCharacter target){
        mana -= 10;
        System.out.println("Vain Man uses Ego Boost! Damage: 2hp");
        attack(target, 2);
    }

    @Override
    public void useSkill3(BaseCharacter target){
        mana -= 15;
        int min = 30, max = 50;
        int damage = (int) (Math.random() * (max - min));
        System.out.println("Vain Man uses Illusionary Appeal! Damage: " + damage + "hp");
        attack(target, damage);
    }

    //usaon paggather og mana/
}
