import java.util.Scanner;

public class Fibonacci {

    public static void fibonacciNonrecursiveSeries(int n) {
        if (n >= 1)
            System.out.print(0);
        if (n >= 2)
            System.out.print(" " + 1);
        int p1 = 0, p2 = 1, c;
        for (int i = 2; i < n; ++i) {
            c = p1 + p2;
            System.out.print(" " + c);
            p1 = p2;
            p2 = c;
        }
        System.out.println();
    }

    public static int fibonacciNonrecursive(int n) {
        if (n <= 1)
            return n;
        int p1 = 0, p2 = 1, c = 0;
        for (int i = 2; i <= n; ++i) {
            c = p1 + p2;
            p1 = p2;
            p2 = c;
        }
        return c;
    }

    public static void fibonacciRecursiveSeries(int n, int a, int b, int count) {
        if (count == 1)
            System.out.print(a);
        if (count == 2)
            System.out.print(" " + b);
        if (count >= n) {
            System.out.println();
            return;
        }
        System.out.print(" " + (a + b));
        fibonacciRecursiveSeries(n, b, a + b, count + 1);
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, choice;

        while (true) {
            System.out.println("\nFibonacci Number");
            System.out.println("1. Non-Recursive Method");
            System.out.println("2. Recursive Method");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.print("\nEnter a number: ");
            n = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Fibonacci series up to " + n + " numbers: ");
                fibonacciNonrecursiveSeries(n);
                System.out.println("Fibonacci(" + n + ") = " + fibonacciNonrecursive(n));
            } else if (choice == 2) {
                System.out.print("Fibonacci series up to " + n + " numbers: ");
                fibonacciRecursiveSeries(n, 0, 1, 1);
                System.out.println("Fibonacci(" + n + ") = " + fibonacciRecursive(n));
            } else {
                System.out.println("Invalid choice! Please select a valid option.");
            }
        }

        scanner.close();
    }
}

/*
 * Fibonacci Number
 * 1. Non-Recursive Method
 * 2. Recursive Method
 * 3. Exit
 * Enter your choice: 1
 * 
 * Enter a number: 9
 * Fibonacci series up to 9 numbers: 0 1 1 2 3 5 8 13 21
 * Fibonacci(9) = 34
 * 
 * Fibonacci Number
 * 1. Non-Recursive Method
 * 2. Recursive Method
 * 3. Exit
 * Enter your choice: 2
 * 
 * Enter a number: 9
 * Fibonacci series up to 9 numbers: 0 1 1 2 3 5 8 13 21 34
 * Fibonacci(9) = 34
 * 
 * Fibonacci Number
 * 1. Non-Recursive Method
 * 2. Recursive Method
 * 3. Exit
 * Enter your choice: 3
 * Exiting the program.
 */