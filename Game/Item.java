package Game;

import java.util.List;

public class Item {
    private String name;
    private String effect;
    private int cost;

    public Item(String name, String effect, int cost){
        this.name = name;
        this.effect = effect;
        this.cost = cost;
    }

    public String getName(){
        return name;
    }

    public String getEffect(){
        return effect;
    }

    public int getCost(){
        return cost;
    }

    public void applyEffect(MainCharacter character){
        System.out.println(character.getName() + " uses " + name + "!");
    }

    public void describe(){
        System.out.println(name + " - " + effect + " (Cost: " + cost + "petals");
    }

    void useItem(MainCharacter character, Item item){
        List<Item> inventory = character.getInventory();

        if(inventory.contains(item)){
            item.applyEffect(character);
            inventory.remove(item);
            System.out.println(item.getName() + " has been used and removed from " + character.getName() + "\' inventory.");
        } else{
            System.out.println(item.getName() + " is not in " + character.getName() + "\' inventory.");
        }

    }

}
