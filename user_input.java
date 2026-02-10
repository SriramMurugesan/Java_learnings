import java.lang.System;
import java.util.Scanner;

class user_input_int{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        System.out.println("The value of a is: "+a);
    }
}

class user_input_float{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        float a = scn.nextFloat();
        System.out.println("The value of a is: "+a);
    }
}

class user_input_string{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String a = scn.nextLine();
        System.out.println("The value of a is: "+a);
    }
}


class user_input_boolean{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean a = scn.nextBoolean();
        System.out.println("The value of a is: "+a);
    }
}

class user_input_double{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double a = scn.nextDouble();
        System.out.println("The value of a is: "+a);
    }
}

