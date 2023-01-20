import java.util.Scanner;
import java.util.Random;


public class Pterodactyl extends Monster{



  //varibles for all monsters
  int pterodactylHealth = getHealth();
  boolean pterodactylRunaway = getRunStatus();
  boolean won = getWonStatus();

  public void pterodactylIntro(){
    System.out.println("OH NO! A feathery pterodactyl has spotted you and doesn't want to leave you alone. It's coming in at you at rapid speeds. Here are your options:"); 
    fightPterodacytl();
  }

  public void fightPterodacytl(){

    while(pterodactylHealth >= -300 && pterodactylRunaway == false && won == false){
    System.out.println("The pterodactyl current health is " + pterodactylHealth);
    Random move = new Random();
    int randomMonsterMove= move.nextInt(6);
    switch(randomMonsterMove){

      // /////////////////////////////////////////////////////////////
      case 1:
      if(pterodactylHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        break;
      }else{
        wingAttack();
      }
      break;

      // /////////////////////////////////////////////////////////////
      case 2:
      if(pterodactylHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        super.setWonBattle();
        break;
      }else{
        peck();
      }
      break;
      // /////////////////////////////////////////////////////////////
      case 3:
      if(pterodactylHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        break;
      }else{
        headButt();
        Scanner scan = new Scanner(System.in);
        System.out.println("\tA - Try to quickly grab a rock to move in place of where you are standing");
        System.out.println("\tB - You attempt to dodge the move");
        System.out.println("\tC - Headbutt it back to try and counter its move");
        String x = scan.nextLine();
    
        if(x.equalsIgnoreCase("A")){
          System.out.println("You are very lucky and were quick enought to pull this move off. The monster instead headbutt your well placed rock");
          pterodactylHealth = pterodactylHealth - 50;
        }else if(x.equalsIgnoreCase("B")){
          System.out.println("Nice work dodging the headButt.");
          pterodactylHealth = pterodactylHealth - 10;

        }else if(x.equalsIgnoreCase("C")){
          System.out.println("That was a poor option, rest in peace lol");
          System.exit(0);
        }else{
            System.out.println("That is not an option, try again");
          }
       
      }
      break;

      case 4:
      if(pterodactylHealth <= 0){
        System.out.println("You defeated the monster! Good job, keep it going!");
        this.won = true;
        setWonBattle();
        super.setWonBattle();
        break;
      }else{
        runAway();
        pterodactylRunaway = true;
      }
      break;

      case 5:
      if(pterodactylHealth <= 0){
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



  //Attack moves specific to pterodactyl
  public void wingAttack(){
    System.out.println("The Pterodactyl monster is now opening his wings to slice you.  Here are you options:");
    Scanner s = new Scanner(System.in);
    System.out.println("\tA - Do nothing.");
    System.out.println("\tB - Duck the monster's wing attack.");
    System.out.println("\tC - Time it as best as you can to pluck a chunk of its feathers from its wings.");

    String input = s.nextLine();
    if(input.equalsIgnoreCase("A")){
            System.out.println("Luckly enough, the Pterodactyl completely missed you and flew head first right into a convievely place mountain. Your quick decision making has let you beat this monster in one move!");
            pterodactylHealth = pterodactylHealth - 200;
    }else if (input.equalsIgnoreCase("B")) {
            System.out.println("Nice Work!! You were able to dodge the wing attack which then messed up the Pterodactyl. ");
            pterodactylHealth = pterodactylHealth - 60;
    }else if (input.equalsIgnoreCase("C")) {
            System.out.println("You were able to plug a big chunk of it's feathers and it started to lose control. It now needs time to recover.");
            pterodactylHealth = pterodactylHealth - 30;
    }else{
            System.out.println("That is not an option, try again");
          } 
  }
  public void peck(){
   System.out.println("The Pterodactyl monster is now going to use it's massive beak to peck you. Here are your options:");
    Scanner s = new Scanner(System.in);
    System.out.println("\tA - Move to the right");
    System.out.println("\tB - Go for the uppper cut.");
    System.out.println("\tC - Try to stop the peck with your hands");

    String input = s.nextLine();
    if(input.equalsIgnoreCase("A")){
            System.out.println("Nice Work!! You were able to dodge the peck. The Pterodactyl then hit it's head on the ground.");
            pterodactylHealth = pterodactylHealth - 200;
    }else if (input.equalsIgnoreCase("B")) {
            System.out.println("Wow!! What a punch. You were able to knock out the Pterodactyl. ");
            pterodactylHealth = pterodactylHealth - 60;
    }else if (input.equalsIgnoreCase("C")) {
            System.out.println("That was not a good choice. You have been impaled by the Pterodacyl and you are elimated. Better luck next time");
            System.exit(0);
    }else{
            System.out.println("That is not an option, try again");
          } 
  }
  
  public boolean getWon(){
    return won;
  }

}