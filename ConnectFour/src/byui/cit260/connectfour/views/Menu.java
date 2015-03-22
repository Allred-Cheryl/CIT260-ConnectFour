/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.connectfour.views;
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

    /**
     *
     */
    public abstract void getInput ();
}