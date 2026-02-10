import java.util.Scanner;

// Example 1: Declare and initialize 1D array
class Array1DBasic {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println("First element: " + numbers[0]);
        System.out.println("Third element: " + numbers[2]);
        System.out.println("Last element: " + numbers[4]);
    }
}

// Example 2: Print all elements using for loop
class Array1DPrint {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}

// Example 3: Print using enhanced for loop
class Array1DEnhanced {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}

// Example 4: Sum of array elements
class Array1DSum {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int sum = 0;
        
        for (int num : numbers) {
            sum += num;
        }
        
        System.out.println("Sum: " + sum);
    }
}

// Example 5: Find maximum element
class Array1DMax {
    public static void main(String[] args) {
        int[] numbers = {10, 50, 30, 40, 20};
        int max = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        
        System.out.println("Maximum: " + max);
    }
}

// Example 6: Find minimum element
class Array1DMin {
    public static void main(String[] args) {
        int[] numbers = {10, 50, 30, 40, 20};
        int min = numbers[0];
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        
        System.out.println("Minimum: " + min);
    }
}

// Example 7: Taking input from user
class Array1DInput {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scn.nextInt();
        }
        
        System.out.println("You entered:");
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}

// Example 8: Search element in array
class Array1DSearch {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int target = 30;
        boolean found = false;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("Found at index: " + i);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Not found");
        }
    }
}

// Example 9: Reverse array
class Array1DReverse {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println("Original array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        
        System.out.println("\nReversed array:");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}

// Example 10: Count even and odd numbers
class Array1DCountEvenOdd {
    public static void main(String[] args) {
        int[] numbers = {10, 15, 20, 25, 30, 35};
        int evenCount = 0;
        int oddCount = 0;
        
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
    }
}
