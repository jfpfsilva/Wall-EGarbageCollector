package directions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Directions {

    private Map<Character, CardinalMoves> moves = new HashMap<>();
    private Set<Long> uniquePositions = new HashSet<>();
    private long x = 0;
    private long y = 0;

    public Directions(){
        this.moves.put('N', CardinalMoves.NORTH);
        this.moves.put('S', CardinalMoves.SOUTH);
        this.moves.put('E', CardinalMoves.EAST);
        this.moves.put('O', CardinalMoves.WEST);
    }

    // Wall-E always starts collecting a garbage ball.
    public void init(){
        long initPosition = szudzikPairing(x, y);
        uniquePositions.add(initPosition);
    }

    public void calcNewDirection(char move) {
        //Ignore all the moves that are not N,S,E and O.
        if(this.moves.containsKey(move)){
            this.x += this.moves.get(move).getX();
            this.y += this.moves.get(move).getY();
            uniquePositions.add(szudzikPairing(x, y));
        }else{
            throw new IllegalArgumentException("Character not valid: " + move);
        }
    }

    public long uniqueBalls(){
        return uniquePositions.size();
    }

    // Szudzik Pairing Function: map two values into a single one in a unique way.
    private static long szudzikPairing(long x, long y){
        long A = x >= 0 ? 2 * x : -2 * x - 1;
        long B = y >= 0 ? 2 * y : -2 * y - 1;
        long C = (A >= B ? A * A + A + B : A + B * B) / 2;
        return x < 0 && y < 0 || x >= 0 && y >= 0 ? C : (-1 * C) - 1;
    }
}
