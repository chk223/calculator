import java.util.ArrayList;
import java.util.List;

public class Calculator<T extends Number> {
    private Operation operator;
    private List<Double> results;
    public Calculator() {
        results = new ArrayList<Double>();
    }
    /**람다식을 이용하여 리팩터링. 연산자 설정*/
    public void setOperator(char operator) {
        switch (operator) {
            case '+' -> this.operator = Operation.ADDITION;
            case '-' -> this.operator = Operation.SUBTRACTION;
            case '*' -> this.operator = Operation.MULTIPLICATION;
            case '/' -> this.operator = Operation.DIVISION;
            default -> throw new IllegalArgumentException("연산자가 잘못 입력됐어요. 다시 입력해주세요. 입력한 연산자: " + operator);
        }
    }
    /**리스트에 결과 값 저장*/
    public void addResult(double result) {
        results.add(result);
    }
    /**컬렉션의 첫 번째 값(FIFO) 제거*/
    public void removeResult() throws CalculatorException {
        if(results.isEmpty()) throw new CalculatorException("값 제거", "결과 값 저장 후 해당 기능을 ");
        else {
            System.out.println("지울 결과 값:" + results.get(0));
            results.remove(0);
        }
    }
    /**람다&스트림을 사용해서 조건에 따라 출력 값을 모아둔 컬렉션 출력*/
    public void getResults(T a) throws CalculatorException {
        try {
            results.stream().filter(result -> result > a.doubleValue())
                    .forEach(result -> System.out.print(result + " "));
            System.out.println("결과 값 모음 중 " + a.doubleValue() + "보다 큰 값들 출력 완료.");
        } catch (Exception e) {
            throw new CalculatorException("출력 컬렉션", "올바른 결과값");
        }
    }
    /**모든 값 출력*/
    public void getAllResults() {
        if(results.isEmpty()) System.out.println("저장 된 결과 값이 없습니다.");
        else {
            results.stream().forEach(result -> System.out.print(result+" "));
            System.out.println();
        }
    }
    /**계산 로직*/
    public double calculate(T a, T b) throws CalculatorException {
        double result = 0;
        /**커스텀 인터페이스, 람다식을 통해 부동 소수점 문제 해결(소수점 2번째 자리 반올림)*/
        RoundDoubleValue roundResult = (doubleValue) -> {
            double range = Math.pow(10,2);
            return Math.round(doubleValue*range)/range;
        };
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
        result = roundResult.round(result);
        this.addResult(result);
        return result;
    }
}