package kz.edu.nu.cs.teaching;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author marks1024
 */
public class App {

    public static void main(String[] args) {
        Stream<String> s;
        s = getTestLinesStream();

        if (s == null) {
            return;
        }
        s.forEach(System.out::println);
        System.out.println("---------------------------------");
        s.close();
        countWords();
        filterLines();
        groupByExample();
    }

    public static void countWords() {
        Stream<String> s = getTestLinesStream();
        if (s == null)
            return;
        long result = s.map((String x) -> x.split("\\s").length).reduce(0, (x, y) -> x + y);
        System.out.println(result);
        System.out.println("---------------------------------");
        s.close();
    }

    public static void filterLines() {
        Stream<String> s = getTestLinesStream();
        if (s == null)
            return;
        s.filter((String x) -> Arrays.stream(x.split("\\s"))
            .map(y -> y.length() > 7)
            .reduce(false, (a, b) -> a || b)).forEach(System.out::println);
        System.out.println("---------------------------------");
        s.close();
    }

    public static void groupByExample() {
        Stream<String> s = getTestLinesStream();
        if (s == null)
            return;
        Map<Character, Long> result = s.map(x -> x.split("\\s"))
            .flatMap(Arrays::stream)
            .collect(Collectors.groupingBy((String x) -> x.charAt(0), Collectors.counting()));
        result.forEach((x, y) -> System.out.println(x + ":" + y));
        System.out.println("---------------------------------");
        s.close();
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
