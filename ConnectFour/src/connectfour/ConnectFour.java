/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class ConnectFour {
    
    private static Player[] playerList;


    //Instance variables
    private final static String instructions = 
                     "This is a game of Connect 4\n"
                    +"You will play against another player. Player 1 is \n"
                    +"black and Player 2 is red. Players will select a \n"
                    +"coordinate and keep alternating until one has four \n"
                    +" a row.";
    
    public ConnectFour(){
        
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
        //Erin was here
        ConnectFour connectFour = new ConnectFour();
        connectFour.display();
        
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.getInput();
    }  
        public void display(){
            System.out.println(instructions);

}

}