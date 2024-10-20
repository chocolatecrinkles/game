package Game;

import java.util.ArrayList;
import java.util.List;

public class MainCharacter extends BaseCharacter{
    protected int xp;
    protected int currency; //petals
    protected int maxHp;
    protected double strength;
    private List<Item> inventory;
    private int inventoryLimit;

    public MainCharacter(String name){
        super(name, 100, 75);
        this.xp = currency / 4;
        this.maxHp = hp;
        this.currency = 100;
        this.strength = 1.0;
        this.inventoryLimit = 6;
        this.inventory = new ArrayList<>();
    }

    public int getXp(){
        return xp;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public int getMaxMana(){
        return mana;
    }

    public int getCurrency(){
        return currency;
    }

    public void gainExp(int amount){
        if(xp == 100){
            maxHp += 30;
        }
        xp += amount;
        currency += xp / 4;
        System.out.println(name + " gained " + amount + " XP. Total XP: " + xp);
        System.out.println("Currency updated to: " + currency + " petals.");
    }

    public List<Item> getInventory(){
        return inventory;
    }

    @Override
    public void useSkill1(BaseCharacter target){
        System.out.println(name + " uses Rose Petal Strike! Deals 8 damage.");
        attack(target, 8);
    }

    @Override
    public void useSkill2(BaseCharacter target) {
        int healAmount = (int) (maxHp * 0.2); // Heals 20% of max HP
        hp += healAmount;
        if (hp > maxHp) hp = maxHp;
        System.out.println(name + " uses Rose\'s Embrace! Heals " + healAmount + " HP. Current HP: " + hp);
    }

    @Override
    public void useSkill3(BaseCharacter target) {
        System.out.println(name + " uses Fox\'s Trick! Deals 25 damage.");
        attack(target, 25);
    }

    public void showStats(){
        System.out.println("\n------------------------------");
        System.out.println("             STATS            ");
        System.out.println("Character Name: " + name);
        System.out.println("HP: " + hp);
        System.out.println("Mana: " + mana);
        System.out.println("XP: " + xp);
        System.out.println("Currency: " + currency + " petals");
        System.out.println("------------------------------\n");
    }

    public void restoreHealth(int amount){
        hp += amount;
        if(hp > maxHp){
            hp = maxHp;
        }
        System.out.println("HP after healing: " + hp + "/" + maxHp);
    }

    public void restoreMana(int amount){
        mana += amount;
        if(mana > maxMana){
            mana = maxMana;
        }
        System.out.println("Mana after healing: " + mana + "/" + maxMana);
    }

    public void increaseMaxHp(int amount){
        maxHp += amount;
    }

    public void increaseStrength(double amount){
        strength += amount;
    }

    public void displayInventory(){
        System.out.println(name + "'s Inventory: ");
        if(inventory.isEmpty()){
            System.out.println("Inventory is empty.");
        } else{
            for(Item item: inventory){
                System.out.println(item);
            }
        }
    }

    public void addItem(Item item){
        if(inventory.size() < inventoryLimit){
            inventory.add(item);
            System.out.println(item.getName() + " has been added to " + getName() + "\'s inventory.");
        } else{
            System.out.println("Inventory is full! You can't add more items.");
        }
    }

    public void removeItem(Item item){
        if(inventory.contains(item)){
            inventory.remove(item);
            System.out.println(item.getName() + " has been removed from " + getName() + "\'s inventory.");
        } else{
            System.out.println(item.getName() + " is not in the inventory.");
        }
    }

    // public void useItem(String itemName){
    //     for(Item item: inventory){
    //         if(item.getName().equalsIgnoreCase(itemName)){
    //             item.use(getName());
    //             inventory.remove(item);
    //             return;
    //         }
    //     }
    //     System.out.println(itemName + " is not in the inventory.");
    // }
}

