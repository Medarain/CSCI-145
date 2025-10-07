public class StarPower {
    // Recursive method to print stars
    public static void star(int n) {
        // Base case: if n is 0, print one star
        if (n == 0) {
            System.out.print("*");
        } else {
            // Recursive case: print stars for 2^(n-1) twice
            star(n - 1);
            star(n - 1);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.print("print(0): ");
        star(0);
        System.out.println();

        System.out.print("print(1): ");
        star(1);
        System.out.println();

        System.out.print("print(2): ");
        star(2);
        System.out.println();

        System.out.print("print(3): ");
        star(3);
        System.out.println();
    }
}