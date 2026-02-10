import java.util.Scanner;

class wrapperclass{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = 10;
        Integer b = a;

        Integer c = 10;
        int d = c;
        System.out.println("The value of a is variable: "+a);
        System.out.println("The value of b is wrapper class: "+b);
        System.out.println("The value of c is wrapper class: "+c);
        System.out.println("The value of d is variable: "+d);
    }
}

class wrapperclass2{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String a = "10";
        int b = Integer.parseInt(a);
        System.out.println("The value of a is string: "+a);
        System.out.println("The value of b is variable: "+b);
        System.out.println(a+b);
      
    }
}
