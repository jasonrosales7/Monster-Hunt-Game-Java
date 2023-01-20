import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.*;

public class Cyclops extends Monster{


  //varibles for all monsters
  int cyclopsHealth = getHealth();
  boolean cyclopsRunaway = getRunStatus();
  boolean won = getWonStatus();

  public void cyclopsIntro(){
    System.out.println("You hear loud footsteps heading towards you. OH NO! You have been spotted by the cyclops. Here are you options:");
    cyclopsFight();
  }

  public void cyclopsFight(){
  
    while(cyclopsHealth >= -300 && cyclopsRunaway == false && won == false){
    System.out.println("The cyclops current health is " + cyclopsHealth);
    Random move = new Random();
    int randomMonsterMove= move.nextInt(6);
    switch(randomMonsterMove){

      // /////////////////////////////////////////////////////////////
      case 1:
      if(cyclopsHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        break;
      }else{
        hypnotize();
      }
      break;

      // /////////////////////////////////////////////////////////////
      case 2:
      if(cyclopsHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        super.setWonBattle();
        break;
      }else{
        rockThrow();
      }
      break;
      // /////////////////////////////////////////////////////////////
      case 3:
      if(cyclopsHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        break;
      }else{
        tackle();
        Scanner scan = new Scanner(System.in);
            System.out.println("\tPick A to move to the side");
            System.out.println("\tPick B to accept defeat");
            System.out.println("\tPick C to give him a left hook");
        String x = scan.nextLine();
          if(x.equalsIgnoreCase("A")){
          System.out.println("You dodged the move and it did damage to itself!");
          cyclopsHealth = cyclopsHealth - 40;
        }else if(x.equalsIgnoreCase("B")){
          cyclopsHealth = cyclopsHealth + 110;
          System.out.println("Game Over :( You have been defeated by the Cyclops. Better luck next time.");
          System.exit(0);
        }else if(x.equalsIgnoreCase("C")){
          cyclopsHealth = cyclopsHealth - 10;
           System.out.println("Your left hook was very weak but you managed to give some damage to the Cyclops");
          }else{
            System.out.println("That is not an option, try again");
          } 
      }
      break;

      case 4:
      if(cyclopsHealth <=0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        break;
      }else{
        runAway();
        cyclopsRunaway = true;
      }
      break;

      case 5:
      if(cyclopsHealth <=0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        break;
      }else{
        noReturn();
    
      }
      break;
    }
    }  
  }


  //Attack moves specific to Cyclops 
  public void hypnotize(){
    System.out.println("The cyclopps has decided to stop and stare at you, he is attempting hypnosis!!! What do you do??");
    Scanner scan = new Scanner(System.in);
    System.out.println("\t Pick A to poke it in the eye");
    System.out.println("\t Pick B to give it a seashell");
    System.out.println("\t Pick C to throw a twig at it");
    String x = scan.nextLine();
    if(x.equalsIgnoreCase("A")){
      System.out.println("That was very effective, great choice!");
      cyclopsHealth = cyclopsHealth - 90;
    }else if(x.equalsIgnoreCase("B")){
      System.out.println("You angered the monster even more, due to its adrenaline it now has more health");
      cyclopsHealth = cyclopsHealth + 110;
    }else if(x.equalsIgnoreCase("That move was very ineffective, it still did some damage")){
      cyclopsHealth = cyclopsHealth - 15;
    }else{
        System.out.println("That is not an option, try again");
    }
  }
  public void rockThrow(){
    System.out.println("The cyclopps has ran over and picked up a large boulder, he is preparing to throw it!!! What do you do??");
    Scanner scan = new Scanner(System.in);
    System.out.println("\t Pick A to catch the rock");
    System.out.println("\t Pick B to watch it as it hurddles towards you");
    System.out.println("\t Pick C to move to the side");
    String x = scan.nextLine();
    if(x.equalsIgnoreCase("A")){
      System.out.println("You caught the rock and threw it back, he looks hurt, well done");
      cyclopsHealth = cyclopsHealth - 50;
    }else if(x.equalsIgnoreCase("B")){
      System.out.println("Game Over :( . You have been defeated by the Cyclops. Better luck next time.");
      System.exit(0);
    }else if(x.equalsIgnoreCase("C")){
      System.out.println("You successfully dodge the rock, it bounces off another rock and hit the monster!");
      cyclopsHealth = cyclopsHealth - 30;
    }else{
      System.out.println("That is not an option, try again");
    }
  }

  public boolean getWon(){
    return won;
  }


}