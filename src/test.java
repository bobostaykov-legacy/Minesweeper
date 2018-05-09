import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a;
        System.out.println("Въведи стойност за а:");
        a = scan.nextInt();
        double b;
        b = 6.8;
        double c;
        c = 7563/56 + 6592;
        double d;
        d = a + b + c;

        char e;
        e = 't';
        char ee;
        ee = 'a';
        String f;
        f = "kuche";
        String g;
        g = f + e + ee;
        System.out.println(g);

        if (a == 10){
            System.out.println("А е равно на 10");
        } else {
            System.out.println("А НЕ е равно на 10");
        }

        while (a > 0){
            System.out.print(a + " ");
            a = a - 1;
        }
    }
}
