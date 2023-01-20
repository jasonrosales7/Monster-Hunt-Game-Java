import java.util.Scanner;
import java.util.Random;

public class Monster{


  //Variables shared by every monster
  public int health;
  public boolean runAway;
  public boolean wonBattle;


  //Constuctor
  public Monster(){
    this.health = 100;
    this.runAway = false;
    this.wonBattle = false;
  }


  public boolean chooseMonster(String locate){
  
    Random pick = new Random();
    int randomMonster = pick.nextInt(4);
    switch(randomMonster){
      case 1:
      if(locate.equals("Path")||locate.equals("Boulder")||locate.equals("Tree")||locate.equals("Beach")||locate.equals("Pond")){
        
        getTest();
        Cyclops monOption1 = new Cyclops();
        monOption1.cyclopsIntro();
        if(monOption1.getWon() == true){
          monOption1.setWonBattle();
          return true;
        }
        
      }
      break;

      case 2:
      if(locate.equals("Beach")||locate.equals("Tree")||locate.equals("Path")||locate.equals("Boulder")){
        getTest();
        Pterodactyl monOption2 = new Pterodactyl();
        monOption2.pterodactylIntro();
        if(monOption2.getWon() == true){
          monOption2.setWonBattle();
          return true;
        }
        
      }
      break;

      case 3:
      if(locate.equals("Pond")||locate.equals("Beach")){
        getTest();
        Lochness monOption3 = new Lochness();
        monOption3.lochNessIntro();
        if(monOption3.getWon() == true){
          monOption3.setWonBattle();
          return true;
        }
      }
      break;
      
    }
    return wonBattle;

  }

  //Shared moves that every monster in the game has and can access
  public void tackle(){
    System.out.println("Your enemy begins to charge at you, it appears that they are going to tackle you to the gound! What do you do??!?!?! ");
  }
  public void headButt(){
    System.out.println(" Your enemy is in close proximity and is leaning there head back to headbutt you like Zidane vs Italy in the 2006 World Cup. What do you do??!??!?  ");
  }
  public void runAway(){
    System.out.println("Wait a second?!??!? Your enemy appears to be backing away from you. You arent entirely sure what just happend, very strange.... You move on back to your exploration  ");
  }
  public void noReturn(){
    Random num = new Random();
    int deathChance = num.nextInt(5);
    if(deathChance == 1){
      System.out.println("You lose sight of the monster, you turn around and realize its too late... your dead and all your items/valuables are gone. Better luck next time");
    System.exit(0);
    }else{
      System.out.println("Theres space between you and the monster, they are thinking of their next move, play your cards wisely");
      System.out.println("_______________________"); 
    }
  }

  // Getter/Setter methods
  public void getTest(){
    System.out.println("The monsters health is currently " + this.health);
  }

  public int getHealth(){
    return this.health;
  }

  public void setHealth(int newHealth){
    this.health = newHealth;
  }

  public boolean getRunStatus(){
    return this.runAway;
  }

  public boolean getWonStatus(){
    return this.wonBattle;
  }

  public void setWonBattle(){
    this.wonBattle = true;
  }
  

}