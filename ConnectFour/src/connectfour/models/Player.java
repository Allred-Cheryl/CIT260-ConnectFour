/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour.models;

import java.io.Serializable;


/**
 *
 * @author Luis Peck
 */
public class Player implements Serializable{
    
    public static final String REGULAR_PLAYER = "REGULAR";
    public static final String COMPUTER_PLAYER = "COMPUTER"; 
    
     public String name;
     public String playerType;
     public long wins = 0;
     public long losses = 0;
     public long ties = 0;
     public String marker;
    
        
    

    public Player() {
    }

    public Player(String playerType, String marker) {
        this.playerType = playerType;
        this.marker = marker;
    }
    
    private double getWinningStatistics(){
        
        char oneHundred = 100;
        
       if (wins < 0){
            System.out.println("The number of wins must be "
                    + "greater than or equal to zero.\r\n");
            return -1;
        }
        
        if (losses < 0){
            System.out.println("The number of losses must be "
                    + "greater than or equal to zero.\r\n");
            return -1;
        }
 
        if (ties < 0){
            System.out.println("The number of ties must be "
                    + "greater than or equal to zero.\r\n");
            return -1;
        } 
        
        double totalScore = this.wins + this.losses + ties;
        
        if (totalScore == 0){
            return 0;
        }
        
        double winRatio = this.wins/totalScore * oneHundred;
        
        return winRatio;
        }
    
    public String getPlayerStastics(){
        String playerStatistics =
                this.name + "has won "
                + this.getWinningStatistics() + "% of the games."
                + "\n\t" + this.wins + "wins, "
                + this.losses + " losses and "
                + ties + " ties.";
        
        return playerStatistics;
    }
    
    
    public double getLosingStatistics(long wins,long losses,long ties){
        double percentage = 100;
        if (wins < 0){
            System.out.println("The number of wins must be "
                    + "greater than or equal to zero.\r\n");
            return -1;
        }
        
        if (losses < 0){
            System.out.println("The number of losses must be "
                    + "greater than or equal to zero.\r\n");
            return -1;
        }
 
        if (ties < 0){
            System.out.println("The number of ties must be "
                    + "greater than or equal to zero.\r\n");
            return -1;
        } 
        double losingPercentage = (losses/(wins+losses+ties))*percentage;
        return losingPercentage;
    }

    String getPlayerStatistics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }


   
