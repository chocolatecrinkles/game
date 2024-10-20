package Game;

public class Drunkard extends BaseCharacter{
    Drunkard(){
        super("Drunkard", 250, 100);
    }

    @Override
    public void useSkill1(BaseCharacter target){
        int damage;
        do{
            damage = (int) (Math.random() * 51);
        } while(damage < 19 && damage > 51);
         
        System.out.println("Drunkard uses Barrel Throw! Damage: " + damage + "hp");
        attack(target, damage);
    }

    @Override
    public void useSkill2(BaseCharacter target){
        if(mana >= 15){
            mana -= 15;
            int healAmount = (int) (hp * 0.3);
            hp += healAmount;
            if (hp > maxHp) hp = maxHp;
            System.out.println("Drunkard uses San Mig Courage and regenerates!");
        } else{
            System.out.println(name + " does not have enough mana for San Mig Couarage.");
        }
    }

    @Override
    public void useSkill3(BaseCharacter target){
        if(mana >= 30){
            mana -= 30;
            System.out.println("Drunkard uses Drunken Rage! Deals 20 damage and stuns " + target.getName());
            target.receiveDamage(20);
            target.stun(target);
        } else{
            System.out.println(name + " does not have enough mana for Druken Rage.");
        }
    }
}
