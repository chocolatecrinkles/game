import java.util.*;

public class Shop{
    private List<Item> inventory;
    private MainChar player;

    public Shop(MainChar character){
        this.inventory = new ArrayList<>();
        this.player = character;
        
        inventory.add(new Rose());
        inventory.add(new Clothes1());
        inventory.add(new HealthPotion(HealthPotion.Size.SMALL));
        inventory.add(new HealthPotion(HealthPotion.Size.MEDIUM));
        inventory.add(new HealthPotion(HealthPotion.Size.LARGE));
        inventory.add(new ManaPotion(ManaPotion.Size.SMALL));
        inventory.add(new ManaPotion(ManaPotion.Size.MEDIUM));
        inventory.add(new ManaPotion(ManaPotion.Size.LARGE));
        inventory.add(new StrengthItem(StrengthItem.Rarity.COMMON));
        inventory.add(new StrengthItem(StrengthItem.Rarity.UNCOMMON));
        inventory.add(new StrengthItem(StrengthItem.Rarity.RARE));
    }

    public void displayItems(){
        System.out.println("Welcome to the Shop! These are the available items: ");
        for(int i = 0; i < inventory.size(); i++){
            System.out.println((i+1) + ". " + inventory.get(i).getName());
        }
    }

    public void buyItem(int itemNumber){
        int itemIndex = itemNumber - 1;
        if(itemIndex < -1 || itemIndex >= inventory.size()){
            System.out.println("Invalid item selection.");
            return;
        }

        Item item = inventory.get(itemIndex);
        if(player.getCurrency() >= item.getCost()){
            player.setCurrency(player.getCurrency() - item.getCost());
            
            // inventory.remove(itemIndex);
            System.out.println("You purchased: " + item.getName());
            player.addItem(item);
            displayCurrency();
        } else{
            System.out.println("Not enough currency to buy item!");
        }
    }

    public void displayCurrency(){
        System.out.println("\n-------------------------------------");
        System.out.println("You have " + player.getCurrency() + " petals.");
        System.out.println("-------------------------------------\n");
    }
}
