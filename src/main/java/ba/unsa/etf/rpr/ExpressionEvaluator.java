package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    /**
     * stacks for transforming our expression
     */
    static Stack<String> operators = new Stack<String>();
    static Stack<Double> values = new Stack<Double>();

    /**
     * evaluates expression that we input
     * @param expression
     * @return
     */
    public static Double evaluate(String expression) {

        for (String el : expression.split(" ")) {
            //   System.out.println(s);
            switch (el) {
                case "(":
                    ;
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    operators.push(el);
                    break;
                case ")":
                    String op = operators.pop();
                    double value = values.pop();
                    switch (op) {
                        case "+":
                            value = values.pop() + value;
                            break;
                        case "-":
                            value = values.pop() - value;
                            break;
                        case "*":
                            value = values.pop() * value;
                            break;
                        case "/":
                            value = values.pop() / value;
                            break;
                        case "sqrt":
                            value = Math.sqrt(value);
                            break;
                    }
                    values.push(value);
                    break;
                case " ":
                    continue;
                default:
                    try {
                        double val2 = Double.parseDouble(el);
                        values.push(val2);
                    } catch (Exception e) {
                        throw new RuntimeException("Bad input!");
                    }
                    break;
            }
        }

        return values.pop();
    }
}