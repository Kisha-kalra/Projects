// Define a class named NHLStats
public class NHLStats {
    // Declare a list to store PlayerRecord objects
    private  List<PlayerRecord> playerRecords;

    // Constructor to initialize the NHLStats object
    public NHLStats(){
        playerRecords=new List<PlayerRecord>();
    }

    // Method to add a PlayerRecord to the list
    public void add(PlayerRecord playerRecord) {
        playerRecords.add(playerRecord);
    }

    // Method to find players with the maximum points
    public void maxPoints(){
        PlayerRecord record=playerRecords.first();
        PlayerRecord recordMax=null;
        int max=0;
        while(record != null){
            int sum=record.getAssists()+record.getGoalsScored();
            if(sum>max){
                max=sum;
                recordMax=record;
            }
            record=playerRecords.next();
        }
        record=playerRecords.first();
        while(record != null){
            int sum=record.getAssists()+record.getGoalsScored();
            if(sum==max) {
                System.out.println(record.toString());
            }
            record =playerRecords.next();
        }

    }

    // Method to find the most aggressive player
    public void mostAggressivePlayer(){
        PlayerRecord record=playerRecords.first();
        PlayerRecord recordMax=null;
        int max=0;
        while(record != null){
            int penalty=record.getPenaltyMinutes();
            if(penalty>max){
                max=penalty;
                recordMax=record;
            }
            record=playerRecords.next();
        }
        record=playerRecords.first();
        while(record != null){
            int penalty=record.getPenaltyMinutes();
            if(penalty == max) {
                System.out.println(record.toString() + " Position: " + record.getPosition());
            }
            record =playerRecords.next();
        }
    }

    // Method to find the Most Valuable Player (MVP)
    public void mvp(){
        PlayerRecord record=playerRecords.first();
        PlayerRecord recordMax=null;
        int max=0;
        while(record != null){
            int winningGoal=record.getWinningGoal();
            if(winningGoal>max){
                max=winningGoal;
                recordMax=record;
            }
            record=playerRecords.next();
        }
        record=playerRecords.first();
        while(record != null){
            int winningGoal=record.getWinningGoal();
            if(winningGoal == max) {
                System.out.println(record.toString());
            }
            record =playerRecords.next();
        }
    }

    // Method to find the most promising player
    public void promisingPlayer(){
        PlayerRecord record=playerRecords.first();
        PlayerRecord recordMax=null;
        int max=0;
        while(record != null){
            int shots=record.getGoalShots();
            if(shots>max){
                max=shots;
                recordMax=record;
            }
            record=playerRecords.next();
        }
        record=playerRecords.first();
        while(record != null){
            int shots =record.getGoalShots();
            if(shots == max) {
                System.out.println(record.toString());
            }
            record =playerRecords.next();
        }
    }

    // Method to find teams with the highest total penalty minutes
    public void teamPenaltyMinutes() {
        List<String> maxList = new List<>();
        PlayerRecord record = playerRecords.first();
        List<String> teams = new List<>();
        while (record != null) {
            if (!teams.contains(record.getTeamName())) {
                teams.add(record.getTeamName());
            }
            record = playerRecords.next();
        }
        String name = teams.first();
        int max = 0;

        while (name != null) {
            //System.out.print(name + ", ");
            record = playerRecords.first();
            int penalty = 0;
            while (record != null) {
                if (record.getTeamName().equals(name)) {
                    penalty += record.getPenaltyMinutes();
                }
                record=playerRecords.next();
            }
            if (penalty > max) {
                max = penalty;
               // maxList.add(name);
            }
            name = teams.next();
        }
        name = teams.first();
        while (name != null) {
            record = playerRecords.first();
            int penalty = 0;
            while (record != null) {
                if (record.getTeamName().equals(name)) {
                    penalty += record.getPenaltyMinutes();
                }
                record=playerRecords.next();
            }
            if (penalty==max) {
                maxList.add(name);
            }
            name = teams.next();
        }
        String str=maxList.first();
        while (str != null){
            System.out.println("Team Name: " + str + " ");
            str=maxList.next();
        }
    }

    // Method to find teams with the highest total winning goals
    public void teamWinningGoals(){
        List<String> maxList = new List<>();
        PlayerRecord record = playerRecords.first();
        List<String> teams = new List<>();
        while (record != null) {
            if (!teams.contains(record.getTeamName())) {
                teams.add(record.getTeamName());
            }
            record = playerRecords.next();
        }
        String name = teams.first();
        int max = 0;
        while (name != null) {
            record = playerRecords.first();
            int winningGoal = 0;
            while (record != null) {
                if (record.getTeamName().equals(name)) {
                    winningGoal += record.getWinningGoal();
                }
                record=playerRecords.next();
            }
            if (winningGoal > max) {
                max = winningGoal;
            }
            name = teams.next();
        }
        name = teams.first();
        while (name != null) {
            record = playerRecords.first();
            int winningGoal = 0;
            while (record != null) {
                if (record.getTeamName().equals(name)) {
                    winningGoal += record.getWinningGoal();
                }
                record=playerRecords.next();
            }
            if (winningGoal == max) {
                 maxList.add(name);
            }
            name = teams.next();
        }
        String str=maxList.first();
        while (str != null){
            System.out.println("Team Name: " + str+ " ");
            str=maxList.next();
        }
    }



}
