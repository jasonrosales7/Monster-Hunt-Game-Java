import java.util.Random;

public class Location {

    public final String FORWARD = "Forward";
    public final String BACK = "Back";
    public final String RIGHT = "Right";
    public final String LEFT = "Left";
    private String currentLocation = "Forest";

    Random random = new Random();
    public ScorableItems scorableItemsForest = new ScorableItems(random.nextInt(10), random.nextInt(10), random.nextInt(10));
    public ScorableItems scorableItemsBeach = new ScorableItems(random.nextInt(10), random.nextInt(10), random.nextInt(10));
    public ScorableItems scorableItemsBoulder = new ScorableItems(random.nextInt(10), random.nextInt(10), random.nextInt(10));
    public ScorableItems scorableItemsPond = new ScorableItems(random.nextInt(10), random.nextInt(10), random.nextInt(10));
    public ScorableItems scorableItemsTree = new ScorableItems(random.nextInt(10), random.nextInt(10), random.nextInt(10));
    public ScorableItems scorableItemsPath = new ScorableItems(random.nextInt(10), random.nextInt(10), random.nextInt(10));

    public String[] itemsForest;
    public String[] itemsBeach;
    public String[] itemsBoulder;
    public String[] itemsPond;
    public String[] itemsTree;
    public String[] itemsPath;


    //Accessor method that returns user's current location
    public String getCurrentLocation() { return currentLocation; }

    //Method that takes the user's direction input and handles it based on their current location
    public void move(String direction){
        System.out.println("\nYou're moving from the [" + currentLocation + "] in the following direction: [" + direction + "]");

        if (currentLocation.equals("Forest")){
            handleForestMove(direction);
        }
        else if (currentLocation.equals("Path")){
            handlePathMove(direction);
        }
        else if (currentLocation.equals("Boulder")){
            handleBoulderMove(direction);
        }
        else if (currentLocation.equals("Pond")){
            handlePondMove(direction);
        }
        else if (currentLocation.equals("Tree")){
            handleTreeMove(direction);
        }
        else if (currentLocation.equals("Beach")){
            handleBeachMove(direction);
        }
    }

    //Mutator method that updates the user's location from "Forest" depending on their chosen direction
    public void handleForestMove(String direction){
        if (direction.equalsIgnoreCase(FORWARD)){
            currentLocation = "Path";
        }
        else{
            System.out.println("\nAll that can be seen that way is deep forest. Ominous noises can be heard in " + "the distance. Better go another way...");
        }
    }

    //Mutator method that updates the user's location from "Path" depending on their chosen direction
    public void handlePathMove(String direction){
        if (direction.equalsIgnoreCase(BACK)){
            currentLocation = "Forest";
        }
        else if (direction.equalsIgnoreCase(FORWARD)){
            currentLocation = "Tree";
        }
        else if (direction.equalsIgnoreCase(RIGHT)){
            currentLocation = "Boulder";
        }
        else if (direction.equalsIgnoreCase(LEFT)){
            currentLocation = "Pond";
        }
    }

    //Mutator method that updates the user's location from "Boulder" depending on their chosen direction
    public void handleBoulderMove(String direction){
        if (direction.equalsIgnoreCase(LEFT)){
            currentLocation = "Path";
        }
        else{
            System.out.println("You cannot go that way.");
        }
    }

    //Mutator method that updates the user's location from "Pond" depending on their chosen direction
    public void handlePondMove(String direction) {
        if (direction.equalsIgnoreCase(FORWARD)) {
            currentLocation = "Beach";
        } else if (direction.equalsIgnoreCase(RIGHT)) {
            currentLocation = "Path";
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    //Mutator method that updates the user's location from "Beach" depending on their chosen direction
    public void handleBeachMove(String direction) {
        if (direction.equalsIgnoreCase(BACK)) {
            currentLocation = "Pond";
        } else if (direction.equalsIgnoreCase(RIGHT)) {
            currentLocation = "Tree";
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    //Mutator method that updates the user's location from "Tree" depending on their chosen direction
    public void handleTreeMove(String direction) {
        if (direction.equalsIgnoreCase(BACK)) {
            currentLocation = "Path";
        } else if (direction.equalsIgnoreCase(LEFT)) {
            currentLocation = "Beach";
        } else {
            System.out.println("You cannot go that way.");
        }
    }

    public void getScorableItems(String location) {
        switch(location) {
            case "Path":
            scorableItemsPath.displayScorableItems();
            break;

            case "Boulder":
            scorableItemsBoulder.displayScorableItems();
            break;

            case "Beach":
            scorableItemsBeach.displayScorableItems();
            break;

            case "Tree":
            scorableItemsTree.displayScorableItems();
            break;

            case "Pond":
            scorableItemsPond.displayScorableItems();
            break;

            case "Forest":
            scorableItemsForest.displayScorableItems();
            break;

            default:
            System.out.println("nothing");
        }
    }

    public void updateNonScorableItems(String location, String item) {
        if (item != null)
        {
            switch(location) {
                case "Path":
                itemsPath = User.updateItems(itemsPath, item);
                break;

                case "Boulder":
                itemsBoulder = User.updateItems(itemsBoulder, item);
                break;

                case "Beach":
                itemsBeach = User.updateItems(itemsBeach, item);
                break;

                case "Tree":
                itemsTree = User.updateItems(itemsTree, item);
                break;

                case "Pond":
                itemsPond = User.updateItems(itemsPond, item);
                break;

                case "Forest":
                itemsForest = User.updateItems(itemsForest, item);
                break;

                default:
                System.out.println("nothing");
            }
        }
    }
}