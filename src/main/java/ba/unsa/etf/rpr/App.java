package ba.unsa.etf.rpr;

import java.util.Scanner;

/**
 * @author: Edis Jasarevic
 * Main class
 */
public class App  {
    /**
     *
     * main method
     * @throws  if expression is not valid
     */
    public static void main(String[] args) throws RuntimeException{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the expression: ");
        String expression = input.nextLine();

        try {
            System.out.println("Result is : " + ExpressionEvaluator.evaluate(String.valueOf(expression)));
        } catch (RuntimeException e) {
            System.out.println("Not valid expression");
        }
    }
}

