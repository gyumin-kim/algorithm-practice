package sample.calculate_without_conditional_statements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gyumin Kim
 * @since 2019-05-09
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, Calculator> calculatorMap = new HashMap<>();
        calculatorMap.put("+", new PlusCalculator());
        calculatorMap.put("-", new MinusCalculator());
        calculatorMap.put("*", new MultiplyCalculator());
        calculatorMap.put("/", new DivideCalculator());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] tokens = line.split(" ");
        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            result = calculatorMap.get(tokens[i])
                        .calculate(result, Double.parseDouble(tokens[i+1]));
        }

        System.out.println(result);
    }
}
