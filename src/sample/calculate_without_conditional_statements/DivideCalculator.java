package sample.calculate_without_conditional_statements;

/**
 * @author Gyumin Kim
 * @since 2019-05-09
 */
public class DivideCalculator implements Calculator {

    @Override
    public double calculate(double num1, double num2) {
        return num1 / num2;
    }
}