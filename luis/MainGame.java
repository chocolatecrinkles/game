import java.util.Scanner;

public class MainGame extends Base{
    Scanner scan = new Scanner(System.in);
    private Shop shop;

    public boolean fail(MainChar character, Base enemy){
        boolean lose = true;
        boolean gameOver = false;
        boolean leave = false;
        System.out.println("Do you wish to explore?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("3. Visit Shop");
        String choice = scan.nextLine();
        boolean validChoice = false;
        while (!validChoice) {
            switch (choice) {
                case "1" -> {
                    System.out.println("-----You have entered Asteroid-326-----");
                    System.out.println("-----Prepare to fight the "+enemy.getName()+"-----");
                    validChoice = true;
                    character.start();
                    enemy.start();
                }
                case "2" -> {
                    validChoice = true;
                    leave = true;
                }
                case "3" -> {
                    if (shop == null) {  // Initialize shop only the first time
                        shop = new Shop(character);
                    }
                    visitShop(character);
                    validChoice = true;
                }
                default ->{
                    System.out.println("Enter a valid choice!");
                    choice = scan.nextLine();
                }
            }
        }

        if(leave){
            System.out.println("\n-----Leaving Round-----");
            return true;
        }

        boolean hasAttacked = false;
        boolean isRegenMana = false;

        while (!gameOver && character.getCurrHp() > 0 && enemy.getCurrHp() > 0) {
            // Skill selection
            String skill;
            boolean validSkill = false;


            while (!validSkill) {
                character.displayChoiceSkill(character);
                skill = scan.nextLine();

                if (character.getCurrHp() <= 0) {
                    System.out.println(character.getName() + " has been defeated! You Lose!");
                    gameOver = true;
                    break;
                }
                if (character.isParalyzed()) {
                    System.out.println("You are paralyzed!");
                } else {
                    switch (skill) {
                        case "1" -> validSkill = character.chooseSkill1(enemy);
                        case "2" -> validSkill = character.chooseSkill2();
                        case "3" -> validSkill = character.chooseUltimate(enemy);
                        case "4" -> character.displayInventory();
                        default -> System.out.println("Invalid choice! Please select a valid skill.");
                    }
                }
                if(!isRegenMana) {
                    character.updateMana();
                    isRegenMana = true;
                }
            }
            if (!hasAttacked){
                enemy.attack(character);
                hasAttacked = true;
            }
            if (enemy.getCurrHp() <= 0) {
                System.out.println("Congratulations! You Won against "+enemy.getName()+"\n");
                character.levelUp(enemy.getExpYield());
                gameOver = true;
                lose = false;
            }
        }
        System.out.println("\n-----Game Over-----");
        character.resetState();
        enemy.resetState();
        return lose;// Terminate the application
    }


    public void visitShop(MainChar character){
        Shop shop = new Shop(character);
        boolean exitShop = false;

        while (!exitShop) {
            shop.displayItems();
            System.out.println("\n-------------------------------------");
            System.out.println("Enter the item number to purchase, or type 'x' to leave the shop.");
            String input = scan.nextLine();
            System.out.println("-------------------------------------\n");
            if (input.equalsIgnoreCase("x")) {
                exitShop = true;
            } else {
                try {
                    int itemNumber = Integer.parseInt(input);
                    shop.buyItem(itemNumber);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid item number or 'x' to leave.");
                }
            }
        }
        

        shop.displayCurrency();
        
    }
}