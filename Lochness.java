import java.util.Scanner;
import java.util.Random;


public class Lochness extends Monster{


  //varibles for all monsters
  int lochnessHealth = getHealth();
  boolean lochnessRunaway = getRunStatus();
  boolean won = getWonStatus();

  public void lochNessIntro(){
    System.out.println("You look over to the pond and decide to go for a swim. You see in the distance a strange figure and you think it's just a piece of driftwood. As you examine closer it's not just a piece of wood. All of the sudden a long neck comes out of the water and you realise it's the Loch Ness Monster.");
    fightLochness();

  }

  public void fightLochness(){

    while(lochnessHealth >= -300 && lochnessRunaway == false && won == false){
    System.out.println("Lochness current health is " + lochnessHealth);
    Random move = new Random();
    int randomMonsterMove= move.nextInt(6);
    switch(randomMonsterMove){

      // /////////////////////////////////////////////////////////////
      case 1:
      if(lochnessHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        break;
      }else{
        tsunami();
      }
      break;

      // /////////////////////////////////////////////////////////////
      case 2:
      if(lochnessHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        super.setWonBattle();
        break;
      }else{
        waterBurst();
      }
      break;
      // /////////////////////////////////////////////////////////////
      case 3:
      if(lochnessHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        break;
      }else{
        
        headButt();
        Scanner scan = new Scanner(System.in);
            System.out.println("\tPick A to move to the side");
            System.out.println("\tPick B to accept defeat");
            System.out.println("\tPick C to give him a left hook");
      
        String x = scan.nextLine();
        if(x.equalsIgnoreCase("A")){
          System.out.println("You dodged the move and it did damage to itself!");
          lochnessHealth = lochnessHealth - 40;
        }else if(x.equalsIgnoreCase("B")){
          lochnessHealth = lochnessHealth + 110;
          System.out.println("Game Over :( . You have been defeated by the Cyclops. Better luck next time.");
          System.exit(0);
        }else if(x.equalsIgnoreCase("C")){
          lochnessHealth = lochnessHealth - 10;
           System.out.println("Your left hook was very weak but you managed to give some damage to the Cyclops");
        }else{
            System.out.println("That is not an option, try again");
          } 
    
      }
      break;

      case 4:
      if(lochnessHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        super.setWonBattle();
        break;
      }else{
        runAway();
        lochnessRunaway = true;
      }
      break;

      case 5:
      if(lochnessHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        super.setWonBattle();
        break;
      }else{
        noReturn(); 
      }
      break;
    }
    }
  }

  //Lochness monster attacks 
  public void tsunami(){
    System.out.println("The Lochness monster jumps into the air and falls back into the water, no where to be found. You frantically search for the monster and you see something growing in the background. Is the Lochness monster coming back!? Wait, is that a hugh wave... it's a Tsunami!! The Tsunami is soo high that it covers you from the sun. What do you do??");
    Scanner s = new Scanner(System.in);
    System.out.println("\tA - swim away like your michael phelps");
    System.out.println("\tB - swim to the bottom of the pond.");
    System.out.println("\tC - Let the Tsunami take you away.");

    String input = s.nextLine();
    if(input.equalsIgnoreCase("A")){
            System.out.println("Unfortunately, you are not as fast a swimmer as the lochness monster. You were able to escape.");
            }else if (input.equalsIgnoreCase("B")) {
                System.out.println("Unfortunately, you are not as fast a swimmer as the lochness monster. Because you are a slow swimmer, the Lochness monster ate you. ");
                System.out.println("Thanks for playing and try again soon!!!");
                System.exit(0);
            }else if (input.equalsIgnoreCase("C")) {
                System.out.println("Good job you were able to escape with no losses.");
    }else{
            System.out.println("That is not an option, try again");
    } 
  }
  public void waterBurst(){
    System.out.println("The Lochness monster is now lifting up it's tail to create a waterburst!! You are about to feel the full force of tons of water coming at you. Here are you options:");
    Scanner s = new Scanner(System.in);
    System.out.println("\tA - Stay where you are and try to manage the incoming water");
    System.out.println("\tB - Swim underneath the waterburst!");
    System.out.println("\tC - You grab on to the tail of the monster");

    String input = s.nextLine();
    if(input.equalsIgnoreCase("A")){
            System.out.println("Unfortunately, you couldn't manage the full force of water. You were defeated by the Lochness Monster. Thanks for playing and try again soon!!!");
            System.exit(0);
    }else if (input.equalsIgnoreCase("B")) {
                System.out.println("Nice Work!! You were able to dodge the water burst which then turned back on the monster ");
                lochnessHealth = lochnessHealth - 60;
    }else if (input.equalsIgnoreCase("C")) {
                System.out.println("You held onto the tail and it launched you towards its head where you proceed to use your Jackie Chan skills to heel kick him.");
                lochnessHealth = lochnessHealth - 90;
    }else{
      System.out.println("That is not an option, try again");
    } 
  }

  public boolean getWon(){
    return won;
  }

  
}


  