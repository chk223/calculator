import java.util.ArrayList;
import java.util.List;

public class Calculator<T extends Number> {
    private Operation operator;
    private List<Double> results;

    public Calculator() {
        results = new ArrayList<Double>();
    }

    public Operation getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        switch (operator) {
            case '+':
                this.operator = Operation.ADDITION;
                break;
            case '-':
                this.operator = Operation.SUBTRACTION;
                break;
            case '*':
                this.operator = Operation.MULTIPLICATION;
                break;
            case '/':
                this.operator = Operation.DIVISION;
                break;
            default:
                throw new IllegalArgumentException("연산자가 잘못 입력됐어요. 다시 입력해주세요. 입력한 연산자: " + operator);
        }
    }

    public void addResult(double result) {
        results.add(result);
    }

    public void removeResult() {
        System.out.println("지울 결과 값:" + results.get(0));
        results.remove(0);
    }

    public void getResults(T a) throws CalculatorException {
        try {
            results.stream().filter(result -> result > a.doubleValue())
                    .forEach(result -> System.out.print(result + " "));
            System.out.println("결과 값 모음 중 " + a.doubleValue() + "보다 큰 값들 출력 완료.");
        } catch (Exception e) {
            throw new CalculatorException("출력 컬렉션", "올바른 결과값");
        }
    }

    public void getAllResults() {
        results.stream().forEach(result -> System.out.print(result+" "));
    }

    public double calculate(T a, T b) throws CalculatorException {
        double result = 0;
        switch (this.operator) {
            case ADDITION:
                result = a.doubleValue() + b.doubleValue();
                break;
            case SUBTRACTION:
                result = a.doubleValue()- b.doubleValue();
                break;
            case MULTIPLICATION:
                result = a.doubleValue() * b.doubleValue();
                break;
            case DIVISION:
                if(b.doubleValue() == 0) throw new CalculatorException("나눗셈","두 번째 값은 0이 아닌 값");
                result = a.doubleValue() / b.doubleValue();
                break;
            default :
                throw new CalculatorException("연산자", "올바른 연산자(+,-,*,/)");
        };
        this.addResult(result);
        return result;
    }
}
