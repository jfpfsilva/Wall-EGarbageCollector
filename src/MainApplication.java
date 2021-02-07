
import java.util.Scanner;
import directions.*;


class MainApplication{

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean proceed = true;
        while(proceed) {
            String moves = scanner.nextLine();
            proceed = checkCloseProgramm(moves);
            long balls = countGarbageBalls(moves);
            System.out.println(balls);
        }
    }

    public static boolean checkCloseProgramm(String move){
        return !move.equalsIgnoreCase("!!");
    }

    public static long countGarbageBalls(String moves){
        if(moves==null) return 0;
        Directions directions = new Directions();
        directions.init();
        for(int i = 0;i<moves.length();i++){
            char c = moves.charAt(i);
            directions.calcNewDirection(c);
        }
        return directions.uniqueBalls();
    }
}

