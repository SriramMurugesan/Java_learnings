// Example 1: Simple for loop
class ForLoopExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}

// Example 2: for loop counting down
class ForLoopCountDown {
    public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
            System.out.println(i);
        }
    }
}

// Example 3: for loop with step 2
class ForLoopStep2 {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i);
        }
    }
}

// Example 4: Sum using for loop
class SumExample {
    public static void main(String[] args) {
        int sum = 0;
        
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        
        System.out.println("Sum of 1 to 10: " + sum);
    }
}

// Example 5: while loop
class WhileLoopExample {
    public static void main(String[] args) {
        int i = 1;
        
        while (i <= 5) {
            System.out.println(i);
            i++;
        }
    }
}

// Example 6: while loop with condition
class WhileConditionExample {
    public static void main(String[] args) {
        int num = 10;
        
        while (num > 0) {
            System.out.println(num);
            num -= 2;
        }
    }
}

// Example 7: do-while loop
class DoWhileExample {
    public static void main(String[] args) {
        int i = 1;
        
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);
    }
}

// Example 8: do-while executes at least once
class DoWhileOnceExample {
    public static void main(String[] args) {
        int i = 10;
        
        do {
            System.out.println("This prints once even though condition is false");
        } while (i < 5);
    }
}

// Example 9: break statement
class BreakExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;  // Stop when i is 5
            }
            System.out.println(i);
        }
    }
}

// Example 10: continue statement
class ContinueExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;  // Skip even numbers
            }
            System.out.println(i);
        }
    }
}

// Example 11: Nested loops
class NestedLoopExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i + "," + j + " ");
            }
            System.out.println();
        }
    }
}

// Example 12: Multiplication table
class MultiplicationTable {
    public static void main(String[] args) {
        int num = 5;
        
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}
