import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);

//    private  Scanner scanner;
//    public Input() {
//        sc = new Scanner(System.in).useDelimiter("\n");
//    }

    public String getString() {
        return this.sc.next();
    }

    public String getString(String prompt) {
//        prompt = "yes or no?";
        System.out.println(prompt);
        return getString();
    }

    public boolean yesNo() {
        String answer = this.sc.next();
        return "y".equalsIgnoreCase(answer) || "yes".equalsIgnoreCase(answer);
    }

    public boolean yesNo(String prompt) {
        System.out.print(prompt);
        return yesNo();
    }

    public int getInt(int min, int max) {
        System.out.println("Enter an integer between " + min + " and " + max);
        int value = getInt();
        if (value < min || value > max) {
            return getInt(min, max);
        }
        return value;
    }

    public int getInt() {
        String input = getString();
        try {
            return Integer.valueOf(input);
        } catch(NumberFormatException e) {
            System.out.println("Must input an integer.");
            return getInt();
        }
    }

    public double getDouble(double min, double max) {
        System.out.printf("Enter a number between %f and %f%n", min, max);
        double value = getDouble();
        if (value < min || value > max) {
            return getDouble(min, max);
        }
        return value;
    }
    public double getDouble() {
        String input = getString();

        try {
            return Double.valueOf(input);
        } catch(NumberFormatException e) {
            System.out.println("Input must be a number.");
            return getDouble();
        }
    }

}
