package kz.edu.nu.cs.teaching;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 
 * @author marks1024
 *
 */
public class App {
    public static void main(String[] args) {
        File file = new File("lambtest.txt");

        try {
            Stream<String> s = Files.lines(file.toPath());
            s.forEach(System.out::println);
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
