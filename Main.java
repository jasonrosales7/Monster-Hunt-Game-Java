import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args) {

    // Create variables
    Scanner s = new Scanner(System.in);
    User u = new User();
    Monster m = new Monster();

    Random a = new Random();
    int monsterChance = a.nextInt(3);
    int currentScore = 0;
    boolean defeatedMonster = false;
    
    // Print the Introduction
    System.out.println("\nWelcome to Forest Adventure! In this game you are to search through the land, fight off monsters, collect points, and find as many collectible problems as you can. Defeat at least one monster and deposit your coins in the proper manner to tally them. Get 50 points and beat a monster and you win, the question is how easy will it be for you. \nYour current location is the Forest Entrance. "
        + "You're surrounded by deep forest, but see a rocky path up ahead. \nEnter a direction (forward,"
        + " back, left, right) or type 'h' for help, 'inventory' for inventory, 'items' to view your items, 'look' to see the items in the area, 'deposit loot' to deposit loot into the pot, 'm' for map, or 'q' to quit");

    // repeating loop (menu) while the score is less than 50
    while (currentScore < 50 || defeatedMonster == false) {
      // Print current location
      System.out.print("_______________________"); 
      System.out.println("\nYour location is " + u.getUserLocation());
      System.out.print("Please enter a command: ");

      // Open Scanner
      String input = s.nextLine();

      // Start tree of possible input commands
      if (input.equalsIgnoreCase("h")) {
        Help.help();
      } else if (input.equalsIgnoreCase("inventory")) {
        System.out.println("Current Inventory:");
        u.inventory.displayScorableItems();
      } else if (input.equalsIgnoreCase("items")) {
        System.out.println("Current Items:");
        u.printItems();
      } else if (input.equalsIgnoreCase("m") || input.equalsIgnoreCase("map")) {
        Help.printMap();
      } else if (input.equalsIgnoreCase("forward")) {
        u.move("forward");
        // creates random monster based on chance
        if (monsterChance == 1) {
          boolean defeatedOneMon;
          defeatedOneMon = m.chooseMonster(u.getUserLocation()); 
          if(defeatedOneMon == true){
            defeatedMonster = true;
          }  
        }
        monsterChance = a.nextInt(3);
        //

      } else if (input.equalsIgnoreCase("back")) {
        u.move("back");
        // creates random monster based on chance
        if (monsterChance == 1) {
          boolean defeatedOneMon;
          defeatedOneMon = m.chooseMonster(u.getUserLocation()); 
          if(defeatedOneMon == true){
            defeatedMonster = true;
          }  
        }
        monsterChance = a.nextInt(3);
        // 
      } else if (input.equalsIgnoreCase("left")) {
        u.move("left");
        // creates random monster based on chance
        if (monsterChance == 1) {
          boolean defeatedOneMon;
          defeatedOneMon = m.chooseMonster(u.getUserLocation()); 
          if(defeatedOneMon == true){
            defeatedMonster = true;
          }  
        }
        monsterChance = a.nextInt(3);
        // 
      } else if (input.equalsIgnoreCase("right")) {
        u.move("right");
        // creates random monster based on chance
        if (monsterChance == 1) {
          boolean defeatedOneMon;
          defeatedOneMon = m.chooseMonster(u.getUserLocation()); 
          if(defeatedOneMon == true){
            defeatedMonster = true;
          }  
        }
        monsterChance = a.nextInt(3);
        //
        
      } else if (input.equalsIgnoreCase("look")) {
        u.look();
      } else if (input.equalsIgnoreCase("pick up")) {
        u.pickUp(u.userLocation.getCurrentLocation());
      } else if (input.equalsIgnoreCase("q")) {
        System.out.println("\nThank you for playing forest adventure!");
        s.close();
        break;
      } else if (input.equalsIgnoreCase("deposit loot")) {
        if (u.getUserLocation().equals("Path")) {
          // This gets the total score of the users inventory and adds it to the game
          // score, then wipes the user inventory
          currentScore += u.dumpItems();
          System.out.println("You placed your loot in the pot. The pot currently holds " + currentScore
              + " points worth of loot. Get the pot to 50 to continue.");
        } else
          System.out.println(
              "You don't see a pot in here. Maybe you can try somewhere else. You think there may be something near the path.");
      } else {
        System.out.println(
            "\nInvalid input. Please enter \"h\", \"q\", \"m\", \"i\", \"look\", \"pick up\", \"deposit loot\", or a direction (forward, back, left, right)");

      }
    }
    // If the score is above 50 and you beat a monster when the while loop ends, a winner screen is shown
    if (currentScore >= 50 && defeatedMonster == true) {
      System.out.println("Congratulations! You found enough loot and were able to beat one monste to win the game! Please play again!");
    }
  }
}