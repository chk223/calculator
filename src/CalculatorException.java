public class CalculatorException extends Exception {
    public CalculatorException(String where,String type) {
        super(where+"에서 잘못된 입력입니다! " + type + "을 입력해주세요!");
    }
}