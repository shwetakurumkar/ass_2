import java.util.Scanner;
class CricketPlayer {
    int pid;
    String pname;
    int totalRun;
    int inningsPlayed;
    int notOutTimes;
    public CricketPlayer(int pid, String pname, int totalRun, int inningsPlayed, int notOutTimes) {
        this.pid = pid;
        this.pname = pname;
        this.totalRun = totalRun;
        this.inningsPlayed = inningsPlayed;
        this.notOutTimes = notOutTimes;
    }
    public double calculateAverage() {
        if (inningsPlayed == notOutTimes) {
            return totalRun;
        } else {
            return (double) totalRun / (inningsPlayed - notOutTimes);
        }
    }
    public void displayPlayer() {
        System.out.println("Player ID: " + pid);
        System.out.println("Player Name: " + pname);
        System.out.println("Total Runs: " + totalRun);
        System.out.println("Innings Played: " + inningsPlayed);
        System.out.println("Not Out Times: " + notOutTimes);
        System.out.println("Average: " + calculateAverage());
    }
}
public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int n = sc.nextInt();
        CricketPlayer[] players = new CricketPlayer[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for player " + (i + 1));
            System.out.print("ID: ");
            int pid = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Name: ");
            String pname = sc.nextLine();
            System.out.print("Total Runs: ");
            int totalRun = sc.nextInt();
            System.out.print("Innings Played: ");
            int inningsPlayed = sc.nextInt();
            System.out.print("Not Out Times: ");
            int notOutTimes = sc.nextInt();
            players[i] = new CricketPlayer(pid, pname, totalRun, inningsPlayed, notOutTimes);
        }
        CricketPlayer maxAvgPlayer = players[0];
        for (int i = 1; i < n; i++) {
            if (players[i].calculateAverage() > maxAvgPlayer.calculateAverage()) {
                maxAvgPlayer = players[i];
            }
        }
        System.out.println("Player with the maximum average:");
        maxAvgPlayer.displayPlayer();
    }
}