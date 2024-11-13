import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private char operator;
    private List<Double> results;

    public Calculator() {
        results = new ArrayList<Double>();
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void addResult(double result) {
        results.add(result);
    }

    public void removeResult() {
        System.out.println("지울 결과 값:" + results.get(0));
        results.remove(0);
    }

    public void getResults() {
        for (double result: results) {
            System.out.print(result+" ");
        }
    }

    public double calculate(int a, int b) {
        double result = 0;
        switch (this.operator) {
            case '+' :
                result = (double) a + b;
                break;
            case '-' :
                result = (double) a - b;
                break;
            case '*' :
                result = (double) a * b;
                break;
            case '/' :
                result = (double) a / b;
                break;
            default :
                break;
        };
        this.addResult(result);
        return result;
    }
}
