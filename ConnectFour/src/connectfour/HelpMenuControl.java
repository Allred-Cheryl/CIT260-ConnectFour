/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author Cheryl Allred
 */
public class HelpMenuControl {
    
    public HelpMenuControl() {
        
    } 

    public void displayBoardHelp() {
        System.out.println();
        this.displayHelpBorder();             
        System.out.println( 
                "\tThe game board for Connect Four. It consist of a grid of "
                + "\n\tlocations. Players drop their marker from the top of a column "
                + "\n\ton the board in an effort to win the game. The default board is "
                + "\n\t6 rows by 7 columns.");
        displayHelpBorder();
    }
    
    
        
    public void displayGameHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                 "\t The objective of the game is to connect four of one's own"
                + "\n\tdiscs of the same color next to each other vertically,"
                + "\n\thorizontally, or diagonally before your opponent."
                + "\n\tThe first player to get \"four-in-a-row\" is the winner."
                ); 
        displayHelpBorder();
    }
            
    public void displayRealPlayerHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\tA real player manually takes their turn by placing their mark "
                + "\n\tat the top of a column on the board."
                ); 
        displayHelpBorder();
    }
    
                   
    public void displayComputerPlayerHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
                "\tA computer based player automatically takes its turn "
                + "\n\timmediatly after a real player in a single player game."
                ); 
        displayHelpBorder();
    }
             
    public void displayLocationHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
               "\tA location on the board where the disc falls after a player"
             + "\n\tcan place their marker"
                ); 
        displayHelpBorder();
    }
                 
    public void displayMarkerHelp() {
        System.out.println();
        displayHelpBorder();     
        System.out.println( 
               "\tA symbol that \"marks\" the locations in the board that are occupied "
                + "by a player. "
                + "\n\tThe default markers are \"B\" for BLACK and \"R\" for RED."
                ); 
        displayHelpBorder();
    }
    
    
    public void displayHelpBorder() {       
        System.out.println(
        "\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
  
}
