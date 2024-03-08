import com.sun.source.doctree.SystemPropertyTree;

import javax.xml.transform.stream.StreamSource;
import java.io.PrintStream;
import java.util.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Gun gun=new Gun();
        System.out.println("Start");
        gun.fireInPool();
        System.out.println("Game over");
        System.out.println("Tocal bullet created: " + Bullet.count);
    }
}