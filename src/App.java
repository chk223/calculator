import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while(true) {
            //입력 값
            Number firstNum;
            Number secondNum;
            //입력 값 받는 로직, 1,2번째 입력 값을 람다 함수를 통해 받도록 구현(리팩터링)
            InputDoubleValue getInputValue = (where) -> {
                int inputValueIsPositive = 1;
                Number inputNum;
                while(true) {
                    System.out.println(where + " 번째 수 입력: ");
                    String input_value = scanner.nextLine();
                    try {
                        //양수 음수 구분
                        if(input_value.contains("-") && input_value.length() >1){
                            inputValueIsPositive = -1;
                            input_value = input_value.substring(1);
                        }
                        //정수 실수 구분
                        inputNum = input_value.contains(".")? Double.parseDouble(input_value) * inputValueIsPositive: Integer.parseInt(input_value) * inputValueIsPositive;
                        System.out.println("현재 입력된 값: " + inputNum);
                        break;
                    } catch (NumberFormatException e){
                        System.out.println(where+" 번째 값 입력이 잘못되었습니다. 실수를 입력해주세요.");
                    }
                }
                return inputNum;
            };
            //각 입력 마다 예외처리 -> 예외 발생 시 다시 입력 받도록 구현
            firstNum = getInputValue.getInputValue("첫");
            secondNum = getInputValue.getInputValue("두");

            while(true){
                System.out.println("사칙연산 기호 입력: ");
                char operator = scanner.next().charAt(0);
                try{
                    calculator.setOperator(operator);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            try{//계산 로직
                double result = calculator.calculate(firstNum, secondNum);
                System.out.println("결과: " + result);
            } catch (NumberFormatException | CalculatorException e) {
                System.out.println(e.getMessage());
            }


            System.out.println("더 계산하시겠습니까?(exit: 종료, nlist: 특정 값보다 큰 입력값 출력, alist:모든 결과값 출력,remove: 가장 오래된 입력 지움, 나머지: 계속)");
            scanner.nextLine();
            String consist = scanner.nextLine();
            //계속할 지 여부(안내와 다른 입력 시 계산기 계속 실행)
            if(consist.equals("nlist")) {
                String compareNum = scanner.nextLine();
                try {
                    calculator.getResults(Double.parseDouble(compareNum));
                } catch (CalculatorException e) {
                    System.out.println(e.getMessage());
                }
            }
            if(consist.equals("alist")) calculator.getAllResults();
            if(consist.equals("remove")) calculator.removeResult();
            if (consist.equals("exit")) break;
        }
    }

}