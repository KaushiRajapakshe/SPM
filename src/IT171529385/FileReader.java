package IT171529385;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {
    private int linecount;
    private String filepath;
    ArrayList<String> file = new ArrayList<String>();
    ArrayList<String> fileNoSpase = new ArrayList<String>();
    ArrayList<String> fileFormat = new ArrayList<String>();

    public FileReader(String filepath) {
        this.filepath = filepath;
        this.readfile();
        this.formatfile();
    }

    public int getLinecount() {
        return linecount;
    }

    public void setLinecount(int linecount) {
        this.linecount = linecount;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public ArrayList<String> getFile() {
        return file;
    }

    public void setFile(ArrayList<String> file) {
        this.file = file;
    }

    public ArrayList<String> getFileNoSpase() {
        return fileNoSpase;
    }

    public void setFileNoSpase(ArrayList<String> fileNoSpase) {
        this.fileNoSpase = fileNoSpase;
    }

    public ArrayList<String> getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(ArrayList<String> fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void readfile(){
        String full="";
        try{
            Scanner s = new Scanner(new File(this.filepath));
            boolean malti=false;
            while (s.hasNext()){

                String readLine=s.nextLine();
                this.file.add(readLine);
                //format file
                readLine=readLine.replaceAll("\t","");
//                readLine=readLine.replaceAll(" ","");
                int commentstart=readLine.indexOf('/');

                if(commentstart!=-1){

                    if('/'==readLine.charAt(commentstart+1)){
                        readLine=readLine.substring(0,commentstart);
                    }
                    else if('*'==readLine.charAt(commentstart+1)){
                        readLine="";
                        malti=true;
                    }
                    else if('*'==readLine.charAt(commentstart-1)){
                        readLine=readLine=readLine.substring(commentstart+1,readLine.length());;
                        malti=false;
                    }
                }
                if(malti){
                    readLine="";
                }




                this.fileNoSpase.add(readLine);

                full+=readLine;

            }

            this.fileNoSpase.removeAll(Arrays.asList("",null));

            s.close();



        }catch (Exception e){

            e.printStackTrace();

        }


    }

    public  ArrayList<String> format( ArrayList<String> list ,char sep){
        ArrayList<String> fileFormattemp = new ArrayList<String>();

        for (String line:list) {

            int brstrt=line.indexOf(sep);
//            System.out.println(brstrt);
//            int br=0;
            while(brstrt!=-1){
                fileFormattemp.add(line.substring(0,brstrt));
                fileFormattemp.add(String.valueOf(sep));
                if(brstrt!=line.length()){
                    line=line.substring(brstrt+1,line.length());
                }
                brstrt=line.indexOf(sep);
//

            }
            fileFormattemp.add(line);


        }
        return fileFormattemp;
    }

    public void formatfile(){
        ArrayList<String> fileFormattemp = new ArrayList<String>();
        ArrayList<String> fileFormattemp2 = new ArrayList<String>();
        fileFormattemp=format(format(this.fileNoSpase,'{'),'}');

        for (String line:fileFormattemp) {

            int brstrt=line.indexOf(';');
//            System.out.println(brstrt);
//            int br=0;
            while(brstrt!=-1){
                if(line.length()>2){
                    if (line.substring(0,3).equalsIgnoreCase("for")){
//                        this.fileFormat.add(line);
                        break;
                    }
                }
                fileFormattemp2.add(line.substring(0,brstrt+1));

                if(brstrt!=line.length()){
                    line=line.substring(brstrt+1,line.length());
                }
                brstrt=line.indexOf(';');
//

            }
            fileFormattemp2.add(line);


        }

        fileFormattemp2.removeAll(Arrays.asList("",null," "));

        for (String chline:fileFormattemp2) {

            int i=0;

            while(chline.charAt(i)==' '){
                i++;
            }


            this.fileFormat.add(chline.substring(i,chline.length()));

        }


    }

    public void printfile(){
       /* for (String line:this.file) {

            System.out.println(line);

        }*/
        System.out.println("\n\n");
        for (String line:this.fileFormat) {

            System.out.println(line);

        }
    }

}
