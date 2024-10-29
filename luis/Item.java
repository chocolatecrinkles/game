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

    public void applyEffect(MainChar character){
        System.out.println(character.getName() + " uses " + name + "!");
    }

    public void describe(){
        System.out.println(name + " - " + effect + " (Cost: " + cost + "petals)");
    }

    void useItem(MainChar character, Item item){
        List<InventoryItem> inventory = character.getInventory();
        boolean found = false;

        for(InventoryItem invItem: inventory){
            if(invItem.getItem().getName().equals(item.getName())){
                found = true;

                invItem.getItem().applyEffect(character);
                invItem.decrementQuantity();
                if(invItem.getQuantity() <= 0){
                    inventory.remove(invItem);
                }
                System.out.println(item.getName() + " has been used and removed from " + character.getName() + "\' inventory.");
                break;
            }

            if(!found){
                System.out.println(item.getName() + " is not in " + character.getName() + "\'s inventory.");
            }
        }
    }

}
