import java.util.Scanner;

// Example 1: Basic jagged array
class JaggedArrayBasic {
    public static void main(String[] args) {
        int[][] jagged = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        
        System.out.println("Jagged array elements:");
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Example 2: Creating jagged array step by step
class JaggedArrayStepByStep {
    public static void main(String[] args) {
        int[][] jagged = new int[3][];
        
        jagged[0] = new int[2];
        jagged[1] = new int[4];
        jagged[2] = new int[1];
        
        jagged[0][0] = 1;
        jagged[0][1] = 2;
        jagged[1][0] = 3;
        jagged[1][1] = 4;
        jagged[1][2] = 5;
        jagged[1][3] = 6;
        jagged[2][0] = 7;
        
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Example 3: Print row lengths
class JaggedArrayRowLengths {
    public static void main(String[] args) {
        int[][] jagged = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        
        System.out.println("Number of rows: " + jagged.length);
        for (int i = 0; i < jagged.length; i++) {
            System.out.println("Row " + i + " length: " + jagged[i].length);
        }
    }
}

// Example 4: Sum of all elements
class JaggedArraySum {
    public static void main(String[] args) {
        int[][] jagged = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        
        int sum = 0;
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                sum += jagged[i][j];
            }
        }
        
        System.out.println("Sum of all elements: " + sum);
    }
}

// Example 5: Find maximum element
class JaggedArrayMax {
    public static void main(String[] args) {
        int[][] jagged = {
            {10, 50, 30},
            {40, 20},
            {60, 15, 25, 35}
        };
        
        int max = jagged[0][0];
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                if (jagged[i][j] > max) {
                    max = jagged[i][j];
                }
            }
        }
        
        System.out.println("Maximum element: " + max);
    }
}

// Example 6: Count total elements
class JaggedArrayCount {
    public static void main(String[] args) {
        int[][] jagged = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        
        int count = 0;
        for (int i = 0; i < jagged.length; i++) {
            count += jagged[i].length;
        }
        
        System.out.println("Total elements: " + count);
    }
}

// Example 7: Taking input for jagged array
class JaggedArrayInput {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int rows = scn.nextInt();
        
        int[][] jagged = new int[rows][];
        
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter number of columns for row " + i + ": ");
            int cols = scn.nextInt();
            jagged[i] = new int[cols];
            
            System.out.println("Enter " + cols + " elements:");
            for (int j = 0; j < cols; j++) {
                jagged[i][j] = scn.nextInt();
            }
        }
        
        System.out.println("You entered:");
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Example 8: Sum of each row
class JaggedArrayRowSum {
    public static void main(String[] args) {
        int[][] jagged = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        
        for (int i = 0; i < jagged.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < jagged[i].length; j++) {
                rowSum += jagged[i][j];
            }
            System.out.println("Row " + i + " sum: " + rowSum);
        }
    }
}

// Example 9: Enhanced for loop with jagged array
class JaggedArrayEnhanced {
    public static void main(String[] args) {
        int[][] jagged = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        
        for (int[] row : jagged) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

// Example 10: Staircase pattern using jagged array
class JaggedArrayStaircase {
    public static void main(String[] args) {
        int n = 5;
        int[][] staircase = new int[n][];
        
        for (int i = 0; i < n; i++) {
            staircase[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                staircase[i][j] = j + 1;
            }
        }
        
        System.out.println("Staircase pattern:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < staircase[i].length; j++) {
                System.out.print(staircase[i][j] + " ");
            }
            System.out.println();
        }
    }
}
