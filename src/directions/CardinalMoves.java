package directions;

public enum CardinalMoves{
    NORTH(0,1),
    SOUTH(0,-1),
    EAST(1,0),
    WEST(-1,0);

    long x;
    long y;

    CardinalMoves(long x, long y){
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY(){
        return y;
    }

}