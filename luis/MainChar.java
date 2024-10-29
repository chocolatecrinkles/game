import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainChar extends Base{
    Scanner scan = new Scanner(System.in);

    protected boolean isSkill1OnCooldown = false;
    protected long skill1CooldownDuration = 3000;
    protected int skill1ManaCost = 10;
    protected long cdReduction = 1000;

    protected boolean isSkill2OnCooldown = false;
    protected long skill2CooldownDuration = 15000;
    protected int skill2ManaCost = 30;
    protected long skill2ActiveDuration = 6000;

    protected boolean isUltimateOnCooldown = false;
    protected long ultimateDuration = 30000;
    protected int ultimateManaCost = 50;

    protected boolean canUseSkill2 = false;
    protected boolean canUseUltimate = false;

    protected Timer skill2start = new Timer();
    protected Timer ultimateStart = new Timer();

    protected List<InventoryItem> inventory;
    protected int inventoryLimit;
    protected int currency;

    public MainChar(String name) {
        super(name, 150, 100, 10, 150, 0, 100, 1, 1.0, "Blade Strike", "Swords Dance", "Judgement");
        attackTimer = new Timer();
        this.inventory = new ArrayList<>();
        this.inventoryLimit = 6;
        this.currency = 100;
    }

    public void setCurrency(int amount){
        this.currency = amount;
    }

    public int getCurrency(){
        return currency;
    }

    public List<InventoryItem> getInventory(){
        return inventory;
    }

    public void setMaxHp(int amount){
        this.maxHp += amount;
    }

    public void addItem(Item item){
        for (InventoryItem invItem : inventory) {
            if (invItem.getItem().getName().equals(item.getName())) {
                invItem.incrementQuantity();
                System.out.println(item.getName() + " has been added to " + getName() + "'s inventory.");
                return;
            }
        }

        if (inventory.size() < inventoryLimit) {
            inventory.add(new InventoryItem(item, 1));
            System.out.println(item.getName() + " has been added to " + getName() + "'s inventory.");
        } else {
            System.out.println("Inventory is full! You can't add more unique items.");
        }
    }

    public void removeItem(Item item){
        for (InventoryItem invItem : inventory) {
            if (invItem.getItem().equals(item)) {
                invItem.decrementQuantity();
                if (invItem.getQuantity() <= 0) {
                    inventory.remove(invItem);
                    System.out.println(item.getName() + " has been is removed from " + getName() + "'s inventory."); // IF WA NAY SULOD
                }
                System.out.println("1 "+ item.getName() + " has been used and is removed from " + getName() + "'s inventory.");
                return;
            }
        }
        System.out.println(item.getName() + " is not in the inventory.");
    }

    public void displayInventory(){
        boolean exitInventory = false;

        while (!exitInventory) {
            System.out.println("\n___________________________________________");
            System.out.println(name + "\'s Inventory:");
            for (int i = 0; i < inventory.size(); i++) {
                InventoryItem invItem = inventory.get(i);
                System.out.println((i + 1) + ") " + invItem.getItem().getName() + " (" + invItem.getQuantity() + ")");
            }
            System.out.println("\n-------------------------------------------");
            System.out.println("Choose an item by number to use it, or type 'x' to close your inventory.");
            String input = scan.nextLine();
            System.out.println("-------------------------------------------");
            if (input.equalsIgnoreCase("x")) {
                exitInventory = true;
            } else {
                try {
                    int itemNumber = Integer.parseInt(input);
                    if (itemNumber > 0 && itemNumber <= inventory.size()) {
                        InventoryItem selectedItem = inventory.get(itemNumber - 1);
                        selectedItem.getItem().applyEffect(this);
                        removeItem(selectedItem.getItem());
                    } else {
                        System.out.println("Invalid item number. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid item number or 'x' to exit.");
                }
            }
        }
        System.out.println("____________________________________________\n");
    }
    
    
    @Override
    public void start(){
        skill2start = new Timer();
        skill2start.schedule(new TimerTask() {
            @Override
            public void run() {
                canUseSkill2 = true; // Skill 2 becomes available after 5 seconds
                System.out.println("Your Skill 2 is now available!");
            }
        }, skill2CooldownDuration); // 5 seconds delay

        // Set a 10-second delay for Ultimate
        ultimateStart = new Timer();
        ultimateStart.schedule(new TimerTask() {
            @Override
            public void run() {
                canUseUltimate = true; // Ultimate becomes available after 10 seconds
                System.out.println("Your Ultimate is now available!");
            }
        }, ultimateDuration); // 10 seconds delay
    }


    public int skill1() {
        setCurrMana(this.currMana - skill1ManaCost);
        Random random = new Random();
        int baseDamage = 5; //setback to 5

        int num = random.nextInt(100);
        int additionalDamage = num / 10;
        if (num <= 9) {
            return 0;
        }

        int damage = (int) ((baseDamage + additionalDamage) * strength);

        isSkill1OnCooldown = true;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                isSkill1OnCooldown = false; // End cooldown
            }
        }, skill1CooldownDuration);
        return damage;
    }


    public void skill2( ){
        setCurrMana(this.currMana - skill2ManaCost);
        strength += 1; // Temporary strength increase
        long originalCD = skill1CooldownDuration;
        skill1CooldownDuration = cdReduction;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                strength -= 1;
                skill1CooldownDuration = originalCD;
            }
        }, skill2ActiveDuration);

        isSkill2OnCooldown = true; // Start cooldown
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                isSkill2OnCooldown = false; // End cooldown
            }
        }, skill2CooldownDuration);
    }


    public int ultimate(Base target){
        setCurrMana(this.currMana - ultimateManaCost);
        int baseDamage = 50;

        int missingHp = target.maxHp - target.currHp;
        int additionalDamage = (int) (0.50 * missingHp);
        int damage = (baseDamage + additionalDamage);

        isUltimateOnCooldown = true;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                isUltimateOnCooldown = false; // End cooldown
            }
        }, ultimateDuration);
        return damage;
    }

    public boolean chooseSkill1(Base target){
        if (isSkill1OnCooldown) {
            System.out.println("Skill is on cooldown!");
        } else  if (this.currMana < skill1ManaCost){
            System.out.println("Insufficient Mana!");
        } else {
            System.out.println(getName() + " used " + skill1Name);
            int damage = skill1();
            System.out.println(getName() + " deals " + damage);
            target.setCurrHp(target.currHp - damage);
            displayStats(MainChar.this, target);
            return  true; // Valid skill chosen
        }
        return false;
    }

    public boolean chooseSkill2(){
        if (!canUseSkill2) {
            System.out.println("Skill 2 is not available yet!");
        } else if (isSkill2OnCooldown) {
            System.out.println("Skill is on cooldown!");
        } else  if (this.currMana < skill2ManaCost){
            System.out.println("Insufficient Mana!");
        } else {
            System.out.println(getName() + " used " + skill2Name);
            skill2();
            System.out.println(getName() + " is pumping up!");
            return true; // Valid skill chosen
        }
        return false;
    }

    public boolean chooseUltimate(Base target){
        if (!canUseUltimate) {
            System.out.println("Ultimate is not available yet!");
        } else if (isUltimateOnCooldown) {
            System.out.println("Skill is on cooldown!");
        } else  if (this.currMana < ultimateManaCost){
            System.out.println("Insufficient Mana!");
        } else {
            System.out.println(getName() + " used " + ultimateName);
            int damage = ultimate(target);
            System.out.println(getName() + " deals " + damage);
            target.setCurrHp(target.currHp - damage);
            displayStats(MainChar.this, target);
            return  true; // Valid skill chosen
        }
        return false;
    }

    @Override
    public void resetState() {
        // Reset any cooldowns, flags, or statuses here
        resetCooldowns();  // Assuming this method resets cooldowns
        resetTimers();     // Assuming this method cancels and clears any active timers
        resetHealthMana(); // Assuming this method resets health/mana if needed
    }

    public void resetCooldowns() {
        // Reset skill cooldowns
        isSkill1OnCooldown = false;
        isSkill2OnCooldown = false;
        isUltimateOnCooldown = false;
        // Reset skill availability
        canUseSkill2 = false;  // Skill 2 needs to become available after its delay
        canUseUltimate = false;
        // Any other reset logic for the character
    }

    @Override
    public void resetTimers() {
        if (attackTimer != null) {
            attackTimer.cancel();
            attackTimer = null;
        }
        if (skill2start != null) {
            skill2start.cancel(); // Cancel the attack timer
        }
        if (ultimateStart != null) {
            ultimateStart.cancel(); // Cancel the attack timer
        }
    }
    public void resetHealthMana() {
        setCurrHp(this.maxHp);  // Reset health
        setCurrMana(this.maxMana);  // Reset mana
    }
}


class InventoryItem {
    private Item item;
    private int quantity;

    public InventoryItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }
}