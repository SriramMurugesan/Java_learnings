import java.util.Scanner;

// Example 1: Declare and initialize 2D array
class Array2DBasic {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Element at [0][0]: " + matrix[0][0]);
        System.out.println("Element at [1][2]: " + matrix[1][2]);
        System.out.println("Element at [2][1]: " + matrix[2][1]);
    }
}

// Example 2: Print 2D array using nested loops
class Array2DPrint {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Example 3: Sum of all elements
class Array2DSum {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        
        System.out.println("Sum of all elements: " + sum);
    }
}

// Example 4: Sum of each row
class Array2DRowSum {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Row " + i + " sum: " + rowSum);
        }
    }
}

// Example 5: Sum of each column
class Array2DColumnSum {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int columns = matrix[0].length;
        for (int j = 0; j < columns; j++) {
            int colSum = 0;
            for (int i = 0; i < matrix.length; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Column " + j + " sum: " + colSum);
        }
    }
}

// Example 6: Taking input for 2D array
class Array2DInput {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[][] matrix = new int[2][3];
        
        System.out.println("Enter 6 elements:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scn.nextInt();
            }
        }
        
        System.out.println("You entered:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Example 7: Find maximum element
class Array2DMax {
    public static void main(String[] args) {
        int[][] matrix = {
            {10, 50, 30},
            {40, 20, 60},
            {15, 25, 35}
        };
        
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        
        System.out.println("Maximum element: " + max);
    }
}

// Example 8: Diagonal elements (square matrix)
class Array2DDiagonal {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Diagonal elements:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
    }
}

// Example 9: Transpose of matrix
class Array2DTranspose {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        System.out.println("Original matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Transpose:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Example 10: Identity matrix
class Array2DIdentity {
    public static void main(String[] args) {
        int n = 4;
        int[][] identity = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    identity[i][j] = 1;
                } else {
                    identity[i][j] = 0;
                }
            }
        }
        
        System.out.println("Identity matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(identity[i][j] + " ");
            }
            System.out.println();
        }
    }
}
