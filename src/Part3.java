/**
 * Project Collections (Part 3)
 * @author Mark Garcia 018019103
 *         mark.garcia01@student.csulb.edu
 * @author Brandon Wiitanen
 *         brandon.wiitanen01@student.csulb.edu
 * Nanoseconds it took using ArrayList: 5194595700
 * Nanoseconds it took using LinkedList: 2993986100
 * In conclusion, the most efficient type of list to use in this program would be a LinkedList.
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A Scavenger Hunt is a party game that people play in teams. They are given a list of items to find throughout the surrounding neighborhood. Our challenge is to find the best data structure to store the results of the hunt.
 * Create a list of 100 items that you might have people find on the hunt. These should be items that they have a chance of finding through out the neighboorhood. For example, yesterday's newspaper, a shoelace, a paperbag,.... Load the list anyway you want (console input, flatfile, etc.)
 * You will run the program two times, once using a set of ArrayLists, and once using a set of LinkedLists. Our pupose is to find the more efficient data structure to use for a scavenger hunt.
 * Use an Iterator (you can use the one in the java library) to traverse the Collection from beginning to end. Then iterate through the Collection from end to beginning (backwards).
 * Time the results. Which data structure is more efficient for looping through the entire Collection?
 * Ask the user how many teams will play the game. Create this number of teams. For each team load all of the items from the list. Shuffle the list after loading the items each time. Find the total time it takes to add the items to all of the teams.
 * Ask the user what position in the list to be used for retrieving and inserting elements. Retrieve that element from each of the teams. Find the total time it takes.
 * Next insert a new element at that position in each of the lists. Find the total time it takes.
 * Use the Random class to generate a number between 0 and the 100. Find the element in the scavenger hunt list at that position. Retrieve that element from each of the lists. Find the total time it takes.
 * Display the time for each of these operations.
 * Run the program several times with different input values and see how it affects the output.
 * Important: You cannot use both Collection objects in the run of the program. You must run the program twice -- once for each data structure.
 */
public class Part3 {
    public static void main(String[] args){
        Scanner numTeams = new Scanner(System.in);
        Scanner elementIndex = new Scanner(System.in);
        ArrayList<String> aL = new ArrayList<>();
        LinkedList<String> lL = new LinkedList<>();
        try{
            long start = System.nanoTime();
            File items = new File("100items.txt");
            Scanner itemScanner = new Scanner(items);
            if(args[0].compareToIgnoreCase("arrayList") == 0){
                ArrayList<ArrayList> teams = new ArrayList<>();
                while(itemScanner.hasNextLine()){
                    aL.add(itemScanner.nextLine());
                }
                System.out.println("Beginning to End: ");
                for(int i = 0; i < aL.size(); i++){
                    System.out.println(aL.get(i));
                }
                System.out.println("End to Beginning: ");
                for(int j = aL.size() - 1; j >= 0; j--){
                    System.out.println(aL.get(j));
                }
                System.out.println("Enter a number of teams to play: ");
                int nT = numTeams.nextInt();
                System.out.println("Creating " + nT + " teams...");
                for(int k = 0; k < nT; k++){
                    teams.add(new ArrayList(aL));
                }
                for(ArrayList a : teams){
                    Collections.shuffle(a);
                }
                System.out.println("Enter an index of an element(0-99): ");
                int eI = elementIndex.nextInt();
                System.out.println("Element at that index: ");
                for(ArrayList a : teams){
                    System.out.println(a.get(eI));
                }
                for(ArrayList a : teams){
                    a.add(eI, "rusty nail");
                }
                int randIndex = new Random().nextInt(100);
                System.out.println("Element at random index (" + randIndex + "):");
                for(ArrayList a : teams){
                    System.out.println(a.get(randIndex));
                }
                long end = System.nanoTime();
                System.out.println("The time (nanoseconds) it took to complete all the operations was: " + (end-start));
                //end if
            } else if (args[0].compareToIgnoreCase("linkedlist") == 0){
                ArrayList<LinkedList> teams = new ArrayList<>();
                while(itemScanner.hasNextLine()){
                    lL.add(itemScanner.nextLine());
                }
                System.out.println("Beginning to End: ");
                for(int i = 0; i < lL.size(); i++){
                    System.out.println(lL.get(i));
                }
                System.out.println("End to Beginning: ");
                for(int j = lL.size() - 1; j >= 0; j--){
                    System.out.println(lL.get(j));
                }
                System.out.println("Enter a number of teams to play: ");
                int nT = numTeams.nextInt();
                System.out.println("Creating " + nT + " teams...");
                for(int k = 0; k < nT; k++){
                    LinkedList<String> tempList = (LinkedList) lL.clone();
                    teams.add(tempList);
                }
                for(LinkedList a : teams){
                    Collections.shuffle(a);
                }
                System.out.println("Enter an index of an element(0-99): ");
                int eI = elementIndex.nextInt();
                System.out.println("Element at that index: ");
                for(LinkedList a : teams){
                    System.out.println(a.get(eI));
                }
                for(LinkedList a : teams){
                    a.add(eI, "rusty nail");
                }
                int randIndex = new Random().nextInt(100);
                System.out.println("Element at random index (" + randIndex + "):");
                for(LinkedList a : teams){
                    System.out.println(a.get(randIndex));
                }

                long end = System.nanoTime();
                System.out.println("The time (nanoseconds) it took to complete all the operations was: " + (end-start));
                //end else if
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            //end catch
        }

    }
}
