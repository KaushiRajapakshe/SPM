package IT16178700.Service;

import IT16178700.Control.Type.ControlType;
import IT16178700.Controller.ControlTypeCon;
import IT171529385.FileReader;

import java.util.ArrayList;

public class ControlTypeCounter {
    ArrayList<String> lineControlCount = new ArrayList<String>();
    FileReader file;

    public ControlTypeCounter(FileReader file) {

        this.file = file;
        countControl();
    }

    public void countControl() {

        ControlTypeCon controlType = new ControlTypeCon();

        int brOpen = 0, brClose = 0, typeCount = 0, ifCount = 0, k = 0;
        ArrayList<Boolean> loop = new ArrayList<Boolean>();

        for (String line : this.file.getFileFormat()) {
            k++;
            int lineLen = line.length();

            if (lineLen == 1) {



                if ("{".equalsIgnoreCase(line)) {

                    brOpen++;

                    String line2=this.file.getFileFormat().get(k-2);
                    int lineLen2=line2.length();


                    if (lineLen2 >= 7) {
                        if (line2.substring(0, 7).equalsIgnoreCase(ControlType.elseIfV)) {
                            loop.add(true);
                            lineControlCount.add("");
                            continue;
                        }

                    }

                    if (lineLen2 >= 5) {
                        if (line2.substring(0, 5).equalsIgnoreCase(ControlType.whileV) || line2.substring(0, 5).equalsIgnoreCase(ControlType.catchV)) {
                            loop.add(true);
                            lineControlCount.add("");
                            continue;
                        }

                    }

                    if (lineLen2 >= 4) {
//
                        if (line2.substring(0, 4).equalsIgnoreCase(ControlType.elseV)) {

                            loop.add(true);
                            lineControlCount.add("");
                            continue;
                        }


                    }


                    if (lineLen2>= 3) {
//
                        if (line2.substring(0, 3).equalsIgnoreCase(ControlType.forV)) {

                            loop.add(true);
                            lineControlCount.add("");
                            continue;
                        }

                    }

                    if (lineLen2 >= 2) {
//
                        if (line2.substring(0, 2).equalsIgnoreCase(ControlType.ifV) || line2.substring(0, 2).equalsIgnoreCase(ControlType.doV)) {

                            loop.add(true);
                            lineControlCount.add("");
                            continue;
                        }


                    }

                    loop.add(false);
                    lineControlCount.add("");
                    continue;


                } else if ("}".equalsIgnoreCase(line)) {
                    brOpen--;
                    //System.out.println(k+"----------"+loop.get(loop.size()-1));
                    if(loop.get(loop.size()-1)){
                        if (k != this.file.getFileFormat().size()) {
                            String next = this.file.getFileFormat().get(k);
                            next = next.replaceAll(" ", "");
                            //System.out.println(next);
                            if(next.length()>=4){
                                if (!ControlType.elseV.equalsIgnoreCase(next.substring(0,4))) {

                                    if (typeCount != 0) {
                                        typeCount--;
                                    }

                                }
                                else {

                                }
                            }
                            else{
                                if (typeCount != 0) {
                                    typeCount--;
                                }
                            }




                        } else {
                            typeCount--;
                        }
                    }

                    loop.remove(loop.size()-1);

                    lineControlCount.add("");
                    continue;

                }

            }
            if (lineLen >= 5) {
//                System.out.println(line.substring(0,7));
                if (line.substring(0, 5).equalsIgnoreCase(ControlType.whileV) || line.substring(0, 5).equalsIgnoreCase(ControlType.catchV)) {
                    typeCount++;
                    lineControlCount.add(String.valueOf(typeCount));
                    continue;
                }

            }




            if (lineLen >= 3) {
//                System.out.println(line.substring(0,7));
                if (line.substring(0, 3).equalsIgnoreCase(ControlType.forV)) {
                    typeCount++;
                    typeCount = controlType.zeroEqual(line, lineLen, typeCount);
                    lineControlCount.add(String.valueOf(typeCount));
                    continue;
                }
                if(lineLen == 71 ){
                if(line.substring(0,6).equalsIgnoreCase("System")){
                    typeCount--;
                    typeCount--;
                    lineControlCount.add(String.valueOf(typeCount));
                    continue;
                }}
            }

            if (lineLen >= 2) {
//                System.out.println(line.substring(0,7));
                if (line.substring(0, 2).equalsIgnoreCase(ControlType.ifV) || line.substring(0, 2).equalsIgnoreCase(ControlType.doV)) {
                    typeCount++;
                    typeCount = controlType.orOperator(line, lineLen, typeCount);
                }
                typeCount = controlType.line(line, lineLen, typeCount);
                lineControlCount.add(String.valueOf(typeCount));
                //typeCount = 0;

            }
            typeCount = 0;
            continue;

        }





    }

    public void printControl() {
        int size = this.lineControlCount.size();
        for (int i = 0; i < size; i++) {
            System.out.println(this.file.getFileFormat().get(i) + "\t\t\t" + this.lineControlCount.get(i));
        }
    }
}
