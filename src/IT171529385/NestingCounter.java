package IT171529385;

import java.util.ArrayList;
import java.util.Arrays;

public class NestingCounter {
    ArrayList<String> lineNestingCount = new ArrayList<String>();
    FileReader file;

    public NestingCounter(FileReader file) {
        this.file = file;
        countnesting();
    }

    public ArrayList<String> getLineNestingCount() {
        return lineNestingCount;
    }

    public void setLineNestingCount(ArrayList<String> lineNestingCount) {
        this.lineNestingCount = lineNestingCount;
    }



    public ArrayList<Integer> loopmin(ArrayList<Integer> loop){

        for(int i=0;i<loop.size();i++){
            loop.set(i,loop.get(i)-1);
            //System.out.println(loop.get(i));

        }

        return loop;
    }

    public void countnesting() {

        int bropen = 0, brclose = 0, neting = 0, ifcount = 0,o=0;
        ArrayList<Boolean> loop = new ArrayList<Boolean>();

        int k = 0;
        for (String line : this.file.getFileFormat()) {
            k++;
            int lineLen = line.length();
            /*if(lineLen>=7){
//                System.out.println(line.substring(0,7));
                if(line.substring(0,7).equalsIgnoreCase("else if")){

                }

            }*/
            if (lineLen == 1) {



                if ("{".equalsIgnoreCase(line)) {

                    bropen++;

                    String line2=this.file.getFileFormat().get(k-2);
                    int lineLen2=line2.length();


                    if (lineLen2 >= 7) {
//
                        if (line2.substring(0, 7).equalsIgnoreCase("else if")) {
                            loop.add(true);
                            lineNestingCount.add("");
                            continue;
                        }

                    }

                    if (lineLen2 >= 5) {
//
                        if (line2.substring(0, 5).equalsIgnoreCase("while") || line2.substring(0, 5).equalsIgnoreCase("catch")) {
                            loop.add(true);
                            lineNestingCount.add("");
                            continue;
                        }

                    }

                    if (lineLen2 >= 4) {
//
                        if (line2.substring(0, 4).equalsIgnoreCase("else")) {

                            loop.add(true);
                            lineNestingCount.add("");
                            continue;
                        }


                    }


                    if (lineLen2>= 3) {
//
                        if (line2.substring(0, 3).equalsIgnoreCase("for")) {

                            loop.add(true);
                            lineNestingCount.add("");
                            continue;
                        }

                    }

                    if (lineLen2 >= 2) {
//
                        if (line2.substring(0, 2).equalsIgnoreCase("if") || line2.substring(0, 2).equalsIgnoreCase("do")) {

                            loop.add(true);
                            lineNestingCount.add("");
                            continue;
                        }


                    }

                    loop.add(false);
                    lineNestingCount.add("");
                    continue;


                } else if ("}".equalsIgnoreCase(line)) {
                    bropen--;
                    //System.out.println(k+"----------"+loop.get(loop.size()-1));
                    if(loop.get(loop.size()-1)){
                        if (k != this.file.getFileFormat().size()) {
                            String next = this.file.getFileFormat().get(k);
                            next = next.replaceAll(" ", "");
                            //System.out.println(next);
                            if(next.length()>=4){
                                if (!"else".equalsIgnoreCase(next.substring(0,4))) {

                                    if (neting != 0) {
                                        neting--;
                                    }

                                }
                                else {
                                    //System.out.println("sachin");
                                }
                            }
                            else{
                                if (neting != 0) {
                                    neting--;
                                }
                            }




                        } else {
                            neting--;
                        }
                    }

                    loop.remove(loop.size()-1);


                    lineNestingCount.add("");
                    continue;

                }

            }
            if (lineLen >= 5) {
//                System.out.println(line.substring(0,7));
                if (line.substring(0, 5).equalsIgnoreCase("while") || line.substring(0, 5).equalsIgnoreCase("catch")) {
                    neting++;
                    lineNestingCount.add(String.valueOf(neting));
                    continue;
                }

            }

            if (lineLen >= 4) {
//                System.out.println(line.substring(0,7));
                if (line.substring(0, 4).equalsIgnoreCase("else")) {

                    lineNestingCount.add("");
                    continue;
                }


            }


            if (lineLen >= 3) {
//                System.out.println(line.substring(0,7));
                if (line.substring(0, 3).equalsIgnoreCase("for")) {
                    neting++;
                    lineNestingCount.add(String.valueOf(neting));
                    continue;
                }

            }

            if (lineLen >= 2) {
//                System.out.println(line.substring(0,7));
                if (line.substring(0, 2).equalsIgnoreCase("if") || line.substring(0, 2).equalsIgnoreCase("do")) {
                    neting++;
                    lineNestingCount.add(String.valueOf(neting));
                    continue;
                }


            }

            lineNestingCount.add(String.valueOf(neting));


//            System.out.println(line.length());

        }





    }

    public void printnesting() {
        int size = this.lineNestingCount.size();
        for (int i = 0; i < size; i++) {
            System.out.println(this.file.getFileFormat().get(i) + "\t\t\t" + this.lineNestingCount.get(i));
        }
    }
}
