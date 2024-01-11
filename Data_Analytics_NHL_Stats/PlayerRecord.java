// create a class named PlayerRecord
public class PlayerRecord {
    //Initialization of instance variables
    private String teamName;
    private String playerName;
    private String position;
    private String gamesPlayed;
    private String goalsScored;
    private String assists;
    private String penaltyMinutes;
    private String goalShots;
    private String winningGoal;

    // Constructor to initialize the PlayerRecord object
    public PlayerRecord(String playerName,String position,String teamName,String gamesPlayed,String goalsScored,
                        String assists,String penaltyMinutes, String goalShots, String winningGoal){
        this.assists=assists;
        this.goalsScored=goalsScored;
        this.gamesPlayed=gamesPlayed;
        this.penaltyMinutes=penaltyMinutes;
        this.playerName=playerName;
        this.position=position;
        this.teamName=teamName;
        this.winningGoal=winningGoal;
        this.goalShots=goalShots;
    }

    // Getter method to retrieve the team name
    public String getTeamName(){
        return teamName;
    }

    // Getter method to retrieve assists as an integer
    public int getAssists() {
        return Integer.parseInt(assists);
    }

    // Getter method to retrieve games played
    public String getGamesPlayed() {
        return gamesPlayed;
    }

    // Getter method to retrieve goal shots as an integer
    public int getGoalShots() {
        return Integer.parseInt(goalShots);
    }

    // Getter method to retrieve penalty minutes as an integer
    public int getPenaltyMinutes() {
        return Integer.parseInt(penaltyMinutes);
    }

    // Getter method to retrieve player name
    public String getPlayerName() {
        return playerName;
    }

    // Getter method to retrieve goals scored as an integer
    public int getGoalsScored() {
        return Integer.parseInt(goalsScored);
    }

    // Getter method to retrieve player position
    public String getPosition() {
        return position;
    }

    // Getter method to retrieve winning goals as an integer
    public int getWinningGoal() {
        return Integer.parseInt(winningGoal);
    }

    //toString method
    public String toString(){
        return "Player Name: " + this.getPlayerName()+ " Team Name: "+ this.getTeamName();
    }
}
