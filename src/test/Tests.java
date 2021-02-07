package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import directions.Directions;

public class Tests {

    public static long countGarbageBalls(String moves){
        if(moves==null) return 1;
        Directions directions = new Directions();
        directions.init();
        for(int i = 0;i<moves.length();i++){
            char c = moves.charAt(i);
            directions.calcNewDirection(c);
        }
        return directions.uniqueBalls();
    }

    @Test
    public void testNullGarbageBalls(){
        assertEquals(1,countGarbageBalls(null));
    }

    @Test
    public void testEmptyGarbageBalls(){
        assertEquals(1,countGarbageBalls(""));
    } 

    @Test
    public void testGarbageBalls_1(){
        assertEquals(2,countGarbageBalls("N"));
    }

    @Test
    public void testGarbageBalls_2(){
        assertEquals(4,countGarbageBalls("NESO"));
    }

    @Test
    public void testGarbageBalls_3(){
        assertEquals(2,countGarbageBalls("NSNSNSNSNS"));
    } 

    @Test
    public void testGarbageBalls_symmetric(){
        assertEquals(countGarbageBalls("NESO"),countGarbageBalls("NOSE"));
    } 


    @Test()
    public void testGarbageBalls_CasoBicudo(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            countGarbageBalls("NSNSNSNSNSxdNSEO>!2334?NS");
        });
        String expectedMessage = "Character not valid: x";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGarbageBalls_VeryLong(){
        StringBuilder strN = new StringBuilder();
        for(int i = 0;i<10000;i++){
            strN.append("N");
        }
        for(int i = 0;i<10000;i++){
            strN.append("S");
        }
        for(int i = 0;i<10000;i++){
            strN.append("O");
        }
        for(int i = 0;i<10000;i++){
            strN.append("E");
        }
        assertEquals(20001,countGarbageBalls(strN.toString()));
    }

    @Test
    public void testGarbageBalls_VeryLong_1(){
        StringBuilder strN = new StringBuilder();
        for(int i = 0;i<10000;i++){
            strN.append("N");
            strN.append("O");
        }
        for(int i = 0;i<10000;i++){
            strN.append("E");
            strN.append("S");
        }
        assertEquals(20001,countGarbageBalls(strN.toString()));
    }

}
