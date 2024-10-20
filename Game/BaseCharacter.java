package Game;

abstract class BaseCharacter implements Character{
    protected String name;
    protected int hp;
    protected int mana;
    protected int maxHp;
    protected int maxMana;
    protected double strength;
    
    public BaseCharacter(String name, int hp, int mana){
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.maxHp = hp;
        this.maxMana = mana;
        this.strength = 1.0;
    }

    @Override
    public int getHp(){
        return hp;
    }

    @Override
    public int getMana(){
        return mana;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void receiveDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        System.out.println(name + " receives " + damage + " damage. Current HP: " + hp);
    }

    @Override
    public void attack(BaseCharacter target, int damage){
        damage =(int) (damage * strength);
        System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage.");
        target.receiveDamage(damage);
    }

    @Override
    public void stun(BaseCharacter target){
        System.out.println(target.getName() + " is stunned and cannot attack");
    }

    @Override
    public void showStats(){
        System.out.println("\n------------------------------");
        System.out.println("             STATS            ");
        System.out.println("Character Name: " + name);
        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("------------------------------\n");
    }
    
}
