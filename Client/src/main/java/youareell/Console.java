package youareell;

import java.util.Scanner;

/**
 * Created by leon on 2/9/18.
 */
public class Console {

    public static void print(String output, Object... args) {
        System.out.printf(output, args);
    }

    public static void println(String output, Object... args) {
        print(output + "\n", args);
    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Integer getIntegerInput(String prompt) {
        String userString = Console.getStringInput(prompt);
        Integer result = 0;
        try {
            result =  Integer.parseInt(userString);
          } catch (NumberFormatException e) {
            System.out.println("Unable to parse integer!");
            return 0;
          }
        return result;
    }

    public static Double getDoubleInput(String prompt) {
        String userString = Console.getStringInput(prompt);
        Double result = 0.0;
        try {
            result =  Double.parseDouble(userString);
          } catch (NumberFormatException e) {
            System.out.println("Unable to parse double!");
            return Double.NaN;
          }
        return result;    }
}