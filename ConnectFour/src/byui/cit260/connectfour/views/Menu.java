/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.connectfour.views;

import byui.cit260.connectfour.controls.ConnectFour;
import byui.cit260.connectfour.enums.ErrorType;
import byui.cit260.connectfour.exceptions.MenuException;
import byui.cit260.connectfour.exceptions.ConnectFourException;
import java.util.Scanner;
/**
 *
 * @author Erin
 */
public abstract class Menu extends byui.cit260.connectfour.controls.MainMenuControl {
    private String[][] menuItems = null;
    
    public Menu() {
}

    public Menu(String[][] menuItems) {
        this();
        this.menuItems = menuItems;
        
    }
    
//please edit as necessary

public final void display() {
    System.out.println("\n\t=============================================================");
    System.out.println("\tEnter the letter associated with one of the following commands:");

    for (int i = 0; i < this.menuItems.length; i++) {
        System.out.println("\t  " + menuItems[i][0] + "\t" + menuItems[i][1]);
    }
    System.out.println("\t================================================================");
}
private boolean validCommand(String command) {
        String[][] items = this.menuItems;

        for (String[] item : this.menuItems) {
            if (item[0].equals(command)) {
                return true;
            }
        }
        return false;
    }

    protected final String getCommand() throws ConnectFourException {

        Scanner inFile = ConnectFour.getInputFile();
        String command;
        boolean valid = false;
        do {
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            valid = validCommand(command);
            if (!validCommand(command)) {
                throw new ConnectFourException(ErrorType.ERROR105.getMessage());  
            }
            return command;
                
        } while (!valid);
    }

    /**
     *
     */
    public abstract void getInput ();
}
