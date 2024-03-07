import com.sun.source.doctree.SystemPropertyTree;

import javax.xml.transform.stream.StreamSource;
import java.io.PrintStream;
import java.util.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape("CIRCLE");
        shape.draw();
        ShapeFactory factory = new ShapeFactory();
        factory.getShape("SQUARE").draw();
    }
}