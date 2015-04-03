//renamed packages to show hierarchy--Erin
package byui.cit260.connectfour.controls;

import byui.cit260.connectfour.enums.ErrorType;
import byui.cit260.connectfour.frames.MainFrame;
import byui.cit260.connectfour.models.Player;
import byui.cit260.connectfour.views.MainMenuView;
import byui.cit260.connectfour.views.HelpMenuView;
import byui.cit260.connectfour.views.GamePreferencesMenuView;
import java.io.Serializable;
import java.util.Scanner;
/**
 *
 * @author Luis
 * Fixed minor spelling issue/grammar by Kevin on 03/07/15
 */
public class ConnectFour implements Serializable {
            public static MainFrame mainFrame = null;

         
    private static final Scanner inFile = new Scanner(System.in);
    private static final HelpMenuView helpMenu = new HelpMenuView();
    
    private static final GamePreferencesMenuView GamePreferencesMenu = new GamePreferencesMenuView();

    private static Player[] playerList;


    //Instance variables
    private final static String instructions = 
                     "This is a game of Connect 4\n"
                    +"You will play against another player. Player 1 is \n"
                    +"black and Player 2 is red. Players will select a \n"
                    +"coordinate and keep alternating until one has four \n"
                    +"in a row.";
    
    private Player[] players = new Player[10];
    public ConnectFour(){
        
    }
    public static Scanner getInputFile() {
        return ConnectFour.inFile;
    }
    
    public static HelpMenuView getHelpMenu() {
        return ConnectFour.helpMenu;
    }


    public static GamePreferencesMenuView getGamePreferencesMenu() {
        return GamePreferencesMenu;
    }

    public static Player[] getPlayerList(){
        return playerList;
    }

    public static void setPlayerList(Player[] playerList){
        ConnectFour.playerList = playerList;
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //Cheryl was here
          ConnectFour connectFour = null;
        try {  
            connectFour = new ConnectFour();
            
              /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    ConnectFour.mainFrame = new MainFrame();
                    ConnectFour.mainFrame.setVisible(true);
                }
            });
        } 

        catch (Throwable ex) {     
            ErrorType.displayErorrMsg("Unexpected error: " + ex.getMessage());
            ErrorType.displayErorrMsg(ex.getStackTrace().toString());           
        } 
        finally {
            if (ConnectFour.mainFrame != null) {
                ConnectFour.mainFrame.dispose();
            }
        }
        
      
    }  
        public void display(){
            System.out.println(instructions);

}
        private String[] getPlayerNames() {
        
        String[] playerNames = new String[10];
        Scanner inFile = ConnectFour.getInputFile();
        
        System.out.println("\n\t---------------------------------------------------------------");
        System.out.println("\t Enter a list of names of those who will be playing ConnectFour. ");
        System.out.println("\t---------------------------------------------------------------");
        
        int playerIndex = 0;
        boolean done = false;
        while (playerIndex < 10  && !done) { 
            System.out.println("\tPlease enter the name of a player or enter \"Q\" to quit.");
            String name;
            name = inFile.nextLine();
            name = name.trim();

            if (name.length() < 1) {
                new ConnectFourError().displayError("\tA name must be at least one character long. Try again.");
                continue;
            }

            if (name.toUpperCase().equals("Q")) { // quit?
                done = true;
                break;
            } 
            
            // add name to list of player names
            playerNames[playerIndex] = name;
            playerIndex++;

        }
        
        String[] newNameList = new String[playerIndex];
        for (int i = 0; i < playerIndex; i++) {
            newNameList[i] = playerNames[i];          
        }
        
        sortList(newNameList);
        
        return newNameList;
    }
    
    public String[] sortList(String[] names) {
        String tmpName;
        boolean notDone = true;
        while(notDone) {
            
            notDone = false; // assume that you done
            for (int i = 0; i < names.length-1; i++) {
                int compareResult = names[i].compareTo(names[i+1]);
                if (compareResult > 0) {
                    // swap names
                    tmpName = names[i];
                    names[i] = names[i+1];
                    names[i+1] = tmpName;
                    notDone = true;
                } 
            }
        }

        return names;
    }

}