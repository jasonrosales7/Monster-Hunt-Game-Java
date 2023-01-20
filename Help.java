public class Help {

    public static void help() {
        System.out.println("You have reached the help portion of this game");
        System.out.println("To move around, you must type either of the following words into the terminal: ");
        System.out.println("Right, Left, Forward, Backward");
        System.out.println("To see your inventory type \"inventory\"");
        System.out.println("To see your items type \"items\"");
        System.out.println("To look for loot in a room, type \"look\"");
        System.out.println("To pick up loot in a room, type \"pick up\"");
        System.out.println("To deposit loot into a pot, type \"deposit loot\"");
        System.out.println("To exit press q");
        System.out.println("After any input, press Enter/Return for the game to recieve it");
    }

            //Help menu option that prints out the map
    public static void printMap(){
        System.out.println("\nBeach -- Tree\n  |      |    \nPond -- Path -- Boulder \n       Entrance         \n");
    }
}