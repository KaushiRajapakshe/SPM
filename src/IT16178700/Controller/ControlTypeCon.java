package IT16178700.Controller;


import IT16178700.Control.Type.ControlType;

public class ControlTypeCon {
    public ControlTypeCon(){

    }

    public int zeroEqual(String line, int lineLen, int typeCount){
        if(lineLen == 41 && line.substring(14,18).equalsIgnoreCase(" = 0")){
            typeCount++;
        }
        return typeCount;
    }

    public int orOperator(String line, int lineLen, int typeCount){
        if(lineLen == 36){
            if(line.substring(18,20).equalsIgnoreCase(ControlType.orOM) ||
                    line.substring(18,20).equalsIgnoreCase(ControlType.orOS) ||
                    line.substring(18,20).equalsIgnoreCase(ControlType.andOM) ||
                    line.substring(18,20).equalsIgnoreCase(ControlType.andOS)){
                typeCount++;
            }
        }
        return typeCount++;
    }

    public int line(String line, int lineLen, int typeCount){
        if(lineLen == 41) {
            if (line.substring(0, 7).equalsIgnoreCase(ControlType.elseIfV) &&
                    (line.substring(23, 25).equalsIgnoreCase(ControlType.andOM) ||
                            (line.substring(23, 25).equalsIgnoreCase(ControlType.andOM)) ||
                            line.substring(23,25).equalsIgnoreCase(ControlType.orOM) ||
                            line.substring(23,25).equalsIgnoreCase(ControlType.orOS))) {
                typeCount += 2;
            }
        }
        return typeCount++;
    }
}
