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
    
    public String getName() {
        return name;
    }

  
    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public long getLosses() {
        return losses;
    }

    public void setLosses(long losses) {
        this.losses = losses;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public long getTies() {
        return ties;
    }

    public void setTies(long ties) {
        this.ties = ties;
    }
    
    public static void main(String[] args) {
        
        
        
    }
    
    
    public void displayName(){
        System.out.println("I have " + wins + "wins and " + losses + "losses.\r\n");
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
        
        double winRatio = wins/totalScore * oneHundred;
        
        return winRatio;
        }
    
    public String getPlayerStatics(){
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
    }


   
