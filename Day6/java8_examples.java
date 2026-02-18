// Java 8 Features Examples - Lambda and Optional

import java.util.*;
import java.util.function.*;

public class java8_examples {
    public static void main(String[] args) {
        System.out.println("=== JAVA 8 FEATURES EXAMPLES ===\n");
        
        // LAMBDA EXPRESSIONS
        System.out.println("=== LAMBDA EXPRESSIONS ===\n");
        
        // Example 1: Simple Lambda
        System.out.println("Example 1: Simple Lambda");
        Runnable r = () -> System.out.println("Hello from lambda");
        r.run();
        
        // Example 2: Lambda with Parameters
        System.out.println("\nExample 2: Lambda with Parameters");
        Java8Calculator add = (a, b) -> a + b;
        Java8Calculator multiply = (a, b) -> a * b;
        System.out.println("5 + 3 = " + add.calculate(5, 3));
        System.out.println("5 * 3 = " + multiply.calculate(5, 3));
        
        // Example 3: Lambda with forEach
        System.out.println("\nExample 3: Lambda with forEach");
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        names.forEach(name -> System.out.println("Hello " + name));
        
        // Example 4: Lambda with filter
        System.out.println("\nExample 4: Lambda with filter");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Even numbers:");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(n -> System.out.println(n));
        
        // Example 5: Lambda with map
        System.out.println("\nExample 5: Lambda with map");
        System.out.println("Doubled numbers:");
        numbers.stream()
               .map(n -> n * 2)
               .forEach(n -> System.out.println(n));
        
        // Example 6: Lambda with Thread
        System.out.println("\nExample 6: Lambda with Thread");
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread: " + i);
            }
        });
        t.start();
        try {
            t.join();
        } catch (Exception e) {}
        
        // OPTIONAL CLASS
        System.out.println("\n=== OPTIONAL CLASS ===\n");
        
        // Example 7: Creating Optional
        System.out.println("Example 7: Creating Optional");
        Optional<String> opt1 = Optional.of("Hello");
        Optional<String> opt2 = Optional.empty();
        System.out.println("opt1 present: " + opt1.isPresent());
        System.out.println("opt2 present: " + opt2.isPresent());
        
        // Example 8: get() and orElse()
        System.out.println("\nExample 8: get() and orElse()");
        System.out.println("opt1 value: " + opt1.get());
        System.out.println("opt2 value: " + opt2.orElse("Default"));
        
        // Example 9: ifPresent()
        System.out.println("\nExample 9: ifPresent()");
        opt1.ifPresent(value -> System.out.println("Value: " + value));
        opt2.ifPresent(value -> System.out.println("Value: " + value));
        
        // Example 10: map()
        System.out.println("\nExample 10: map()");
        Optional<Integer> length = opt1.map(String::length);
        System.out.println("Length: " + length.orElse(0));
        
        // Example 11: ofNullable()
        System.out.println("\nExample 11: ofNullable()");
        String nullValue = null;
        Optional<String> opt3 = Optional.ofNullable(nullValue);
        System.out.println("opt3 present: " + opt3.isPresent());
        System.out.println("opt3 value: " + opt3.orElse("Null was provided"));
        
        // Example 12: Practical Example
        System.out.println("\nExample 12: Practical Example");
        Optional<String> name = getName(true);
        name.ifPresent(n -> System.out.println("Name: " + n));
        
        Optional<String> noName = getName(false);
        System.out.println("Name: " + noName.orElse("Unknown"));
        
        System.out.println("\n=== ALL EXAMPLES COMPLETED ===");
    }
    
    static Optional<String> getName(boolean exists) {
        if (exists) {
            return Optional.of("John");
        } else {
            return Optional.empty();
        }
    }
}

@FunctionalInterface
interface Java8Calculator {
    int calculate(int a, int b);
}
