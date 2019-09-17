import IT16178700.Service.ControlTypeCounter;
import IT171529385.FileReader;

public class AppMain {
    public static void main(String[] args) {
//        System.out.println("sachin");
        FileReader freader=new FileReader("test01.java");
//        freader.printfile();
       // NestingCounter ncount=new NestingCounter(freader);
        //ncount.printnesting();

        // Control Type Counter
        ControlTypeCounter ccount = new ControlTypeCounter(freader);
        ccount.printControl();

    }
}
