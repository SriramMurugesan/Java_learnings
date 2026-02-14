// Day 2 Revision: Control Flow & Arrays

public class day2 {
    public static void main(String[] args) {
        
        // 1. If-Else
        System.out.println("=== IF-ELSE ===");
        int age = 20;
        if (age >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Minor");
        }
        
        // 2. Switch
        System.out.println("\n=== SWITCH ===");
        int day = 3;
        switch (day) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            default: System.out.println("Other day");
        }
        
        // 3. For Loop
        System.out.println("\n=== FOR LOOP ===");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
        
        // 4. While Loop
        System.out.println("\n=== WHILE LOOP ===");
        int count = 1;
        while (count <= 3) {
            System.out.println("While: " + count);
            count++;
        }
        
        // 5. 1D Array
        System.out.println("\n=== 1D ARRAY ===");
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Array elements:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // 6. 2D Array
        System.out.println("\n=== 2D ARRAY ===");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // 7. Pattern
        System.out.println("\n=== PATTERN ===");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
