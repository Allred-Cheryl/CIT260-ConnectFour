/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author Luis Peck
 */
public class Player {
    String name;
    String playerType;
    long wins = 0;
    long losses = 0;
    String marker;
    
    
    public Player(){
    }
    
    
    public void displayName(){
        System.out.println("Greetings, my name is "+ this.name);
    }
}
