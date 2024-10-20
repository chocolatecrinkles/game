package Game;


/**
 *  Character
 */
public interface Character {
    int getHp();
    int getMana();
    String getName();
    void useSkill1(BaseCharacter target);
    void useSkill2(BaseCharacter target);
    void useSkill3(BaseCharacter target);
    void attack(BaseCharacter target, int damage);
    void receiveDamage(int damage);
    void stun(BaseCharacter target);
    void showStats();
}