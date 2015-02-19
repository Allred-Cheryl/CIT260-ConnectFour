/*
 Example only; please correct as needed
 */
package connectfour;

/**
 *
 * @author Erin
 */
public class displayNames {
    
    public static void main (String[] names) {
        System.out.println("\n\t===============================================================");
        System.out.println("\tHere is the list of players in the game");

        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                break;
            }
                
            int namePosition = i+1;
            System.out.println("\t   " + namePosition + "\t" + names[i]);
        }
        System.out.println("\t===============================================================\n");
    }
    
    
}
