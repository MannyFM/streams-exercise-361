package kz.edu.nu.cs.teaching;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author marks1024
 *
 */
public class App {
    public static void main(String[] args) {
        Stream<String> s = getTestLinesStream();
        
        // s.forEach(System.out::println);
        // s.close();
        
        //s = getTestLinesStream();
        //s.map((x) -> x.toUpperCase()).forEach(System.out::println);
        //s.close();
        
        
        
        // getTestLinesStream().flatMap((x) -> Stream.of(x.split(" "))).forEach(System.out::println);
        
        // long l = getTestLinesStream().flatMap((x) -> Stream.of(x.split(" "))).count();
        // System.out.println(l);
        
        System.out.println(getTestLinesStream().collect(Collectors.groupingBy((x) -> x.length())));

    }
    
    public static Stream<String> getTestLinesStream() {
        File file = new File("lambtest.txt");
        
        try {
            return Files.lines(file.toPath());
        } catch (Exception e) {
            System.out.println("Error reading from file");
            return null;
        }
    }
}
