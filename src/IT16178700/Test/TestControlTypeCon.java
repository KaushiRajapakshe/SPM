package IT16178700.Test;

import IT16178700.Control.Type.ControlType;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestControlTypeCon {
    @Test
    public void TestLine(){
        String line = "else if ((number == 0) && (number == 1))";
        int lineLen = 41;
        int typeCount = 0;
            if(lineLen == 41) {
            if (line.substring(0, 7).equalsIgnoreCase(ControlType.elseIfV) &&
                    (line.substring(23, 25).equalsIgnoreCase(ControlType.andOM) ||
                            (line.substring(23, 25).equalsIgnoreCase(ControlType.andOM)) ||
                            line.substring(23,25).equalsIgnoreCase(ControlType.orOM) ||
                            line.substring(23,25).equalsIgnoreCase(ControlType.orOS))) {
                typeCount += 2;
            }
        }
        assertEquals(2, typeCount);
        }

        @Test
        public void zeroEqual(){
            String line ="for (int count = 0; count <= 10; count++)";
            int lineLen = 41;
            int typeCount = 1;
        if(lineLen == 41 && line.substring(14,18).equalsIgnoreCase(" = 0")){
            typeCount++;
        }
            assertEquals(2, typeCount);
        }

        @Test
        public void orOperator(){
            String line ="if ((number == 0) || (number == 1)) ";
            int lineLen = 36;
            int typeCount = 1;
            if(lineLen == 36){
                if(line.substring(18,20).equalsIgnoreCase(ControlType.orOM) ||
                    line.substring(18,20).equalsIgnoreCase(ControlType.orOS) ||
                    line.substring(18,20).equalsIgnoreCase(ControlType.andOM) ||
                    line.substring(18,20).equalsIgnoreCase(ControlType.andOS)){
                typeCount++;
            }
        }
            assertEquals(2, typeCount);
    }
}
