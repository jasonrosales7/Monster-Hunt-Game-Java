import java.util.Map;
import java.util.Random;

public class User {

    public Location userLocation;
    public ScorableItems inventory = new ScorableItems();
    public String[] items;

    private Map<String, Integer> tempItems;

    private boolean pathUsed = false;
    private boolean boulderUsed = false;
    private boolean beachUsed = false;
    private boolean treeUsed = false;
    private boolean pondUsed = false;
    private boolean forestUsed = false;

    public User(){
        userLocation = new Location();
    }

    //Accessor method that returns user's current location
    public String getUserLocation(){return userLocation.getCurrentLocation();}

    //Method that takes the user's direction input and handles it based on their current location
    public void move(String direction){
        userLocation.move(direction);
    }

    /**
     * "looks" for any items(weapons/tools) or scorable items(points) uses 
     * random numbers to decide if there are any other items besides scorable
     */
    public void look() {
        Random random = new Random();
        int chance = random.nextInt(101);
        if(chance<=50) {
            int item = random.nextInt(5);
            String actualItem;
            switch(item) {
                case 1:
                actualItem = "sword";
                break;
                
                case 2: 
                actualItem = "stone";
                break;

                case 3:
                actualItem = "used underwear";
                break;

                case 4:
                actualItem = "ball of dried up mud";
                break;

                case 5:
                actualItem = "crown";
                break;

                default:
                actualItem = "nuke";
                break;
            }
            userLocation.updateNonScorableItems(userLocation.getCurrentLocation(), actualItem);
            System.out.println("You see something of use! \n It's a " + actualItem + "!");
        }
        System.out.println("You see some coins:");
        userLocation.getScorableItems(userLocation.getCurrentLocation());
        System.out.println("You should probably pick those up.");
    }

    /**
     * picks up any items / scorableItems in the room and puts them in inventory/ items.
     */
    public void pickUp(String location) {
        switch(location) {
            case "Path":
            if (!pathUsed)
            {
                if (this.userLocation.itemsPath != null) {this.items = updateItems(this.items, this.userLocation.itemsPath[0]);}  
                tempItems = this.userLocation.scorableItemsPath.removeItems();
                this.inventory.addItems(tempItems);   
                if (this.userLocation.itemsPath != null)
                    System.out.println("Success! You have added a " + this.userLocation.itemsPath[0] + " to your items and " + tempItems.toString() +" to your inventory.");      
                else
                    System.out.println("Success! You have added " + tempItems.toString() +" to your inventory.");     
                tempItems.clear(); 
                pathUsed = true;
            }
            else
                System.out.println("You don't see anything here. Maybe try somewhere else.");
            break;

            case "Boulder":
            if (!boulderUsed)
            {
                if (this.userLocation.itemsBoulder != null) {this.items = updateItems(this.items, this.userLocation.itemsBoulder[0]);}  
                tempItems = this.userLocation.scorableItemsBoulder.removeItems();
                this.inventory.addItems(tempItems);   
                if (this.userLocation.itemsBoulder != null)
                    System.out.println("Success! You have added a " + this.userLocation.itemsBoulder[0] + " to your items and " + tempItems.toString() +" to your inventory.");      
                else
                    System.out.println("Success! You have added " + tempItems.toString() +" to your inventory.");     
                tempItems.clear(); 
                boulderUsed = true;
            }
            else
                System.out.println("You don't see anything here. Maybe try somewhere else.");
            break;

            case "Beach":
            if (!beachUsed)
            {
                if (this.userLocation.itemsBeach != null) {this.items = updateItems(this.items, this.userLocation.itemsBeach[0]);}  
                tempItems = this.userLocation.scorableItemsBeach.removeItems();
                this.inventory.addItems(tempItems);   
                if (this.userLocation.itemsBeach != null)
                    System.out.println("Success! You have added a " + this.userLocation.itemsBeach[0] + " to your items and " + tempItems.toString() +" to your inventory.");      
                else
                    System.out.println("Success! You have added " + tempItems.toString() +" to your inventory.");     
                tempItems.clear(); 
                beachUsed = true;
            }
            else
                System.out.println("You don't see anything here. Maybe try somewhere else.");
            break;

            case "Tree":
            if (!treeUsed)
            {
                if (this.userLocation.itemsTree != null) {this.items = updateItems(this.items, this.userLocation.itemsTree[0]);}  
                tempItems = this.userLocation.scorableItemsTree.removeItems();
                this.inventory.addItems(tempItems);   
                if (this.userLocation.itemsTree != null)
                    System.out.println("Success! You have added a " + this.userLocation.itemsTree[0] + " to your items and " + tempItems.toString() +" to your inventory.");      
                else
                    System.out.println("Success! You have added " + tempItems.toString() +" to your inventory.");     
                tempItems.clear(); 
                treeUsed = true;
            }
            else
                System.out.println("You don't see anything here. Maybe try somewhere else.");
            break;

            case "Pond":
            if (!pondUsed)
            {
                if (this.userLocation.itemsPond != null) {this.items = updateItems(this.items, this.userLocation.itemsPond[0]);}  
                tempItems = this.userLocation.scorableItemsPond.removeItems();
                this.inventory.addItems(tempItems);   
                if (this.userLocation.itemsPond != null)
                    System.out.println("Success! You have added a " + this.userLocation.itemsPond[0] + " to your items and " + tempItems.toString() +" to your inventory.");      
                else
                    System.out.println("Success! You have added " + tempItems.toString() +" to your inventory.");     
                tempItems.clear(); 
                pondUsed = true;
            }
            else
                System.out.println("You don't see anything here. Maybe try somewhere else.");
            break;

            case "Forest":
            if (!forestUsed)
            {
                if (this.userLocation.itemsForest != null) {this.items = updateItems(this.items, this.userLocation.itemsForest[0]);}  
                tempItems = this.userLocation.scorableItemsForest.removeItems();
                this.inventory.addItems(tempItems);   
                if (this.userLocation.itemsForest != null)
                    System.out.println("Success! You have added a " + this.userLocation.itemsForest[0] + " to your items and " + tempItems.toString() +" to your inventory.");      
                else
                    System.out.println("Success! You have added " + tempItems.toString() +" to your inventory.");     
                tempItems.clear(); 
                forestUsed = true;
            }
            else
                System.out.println("You don't see anything here. Maybe try somewhere else.");
            break;

            default:
            System.out.println("nothing");
        }
    }

    /**
     * Loops through user inventory and prints contents. If empty a string is printed telling the user.
     */
    public void printItems() {
        if(this.items == null ) {
            System.out.println("\n Sorry! Your items is empty! \n");
        } else {
            int spot = 1;
            for (int x = 0; x < this.items.length; x++) {
                if (this.items[x].isEmpty() || this.items[x] == null) {
                    continue;
                }
                System.out.println("\n" + spot + ": " + this.items[x] + "\n");
                spot++;
            }
        }
    }

    /**
     *  loops through the users current inventory, if empty creates an array of length 1
     *  If not empty, new array is created with 1 more space and new item is inserted at the end
     *
     * @param items
     * @param item
     */
    public static String[] updateItems(String[] items, String item) {
        String[] itemsNew;
        if(items == null) {
            itemsNew = new String[]{item};
        } else {

            int itemsSize = items.length;
            itemsNew = new String[itemsSize + 1];
            for (int x = 0; x < itemsSize; x++) {
                itemsNew[x] = items[x];
            }
            itemsNew[itemsSize] = item;
        }
        return itemsNew;
    }

    public int dumpItems()
    {
        int returnScore = 0;

        returnScore += inventory.getItem("Gold") * 3;
        returnScore += inventory.getItem("Silver") * 2;
        returnScore += inventory.getItem("Copper");

        inventory = new ScorableItems();

        return returnScore;
    }
}