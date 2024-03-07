import com.sun.source.doctree.SystemPropertyTree;

import javax.xml.transform.stream.StreamSource;
import java.io.PrintStream;
import java.util.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int DISTANCE =100;
    public static int STEP =2;

    public static void main(String[] args) {

        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");

        Thread thread1 = new Thread(carA);
        Thread thread2 = new Thread(carB);
        Thread thread3 = new Thread(carC);

        System.out.println("Distance: 100KM");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}