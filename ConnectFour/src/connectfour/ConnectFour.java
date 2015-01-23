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

    //Instance variables
    String name;
    String instructions = "This is a game of Connect 4\n"
                    +"You will play against another player. Player 1 is \n"
                    +"black and Player 2 is red. Players will select a \n"
                    +"coordinate and keep alternating until one has four \n"
                    +" a row.";
            
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //Erin was here
        ConnectFour myGame = new ConnectFour();
        myGame.getName();
        myGame.displayHelp();
    }  
        public void getName(){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your name: ");
            this.name = input.next();
}
        
        public void displayHelp() {
            System.out.println("\nWelcome " + this.name +"\n");
            System.out.println(this.instructions);
        }
}

    

