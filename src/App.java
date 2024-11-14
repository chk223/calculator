import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while(true) {
            int firstNumberIsPositive = 1;
            int secondNumberIsPositive = 1;
            String first_input;
            String second_input;
            Number firstNum;
            Number secondNum;
            //각 입력 마다 예외처리 -> 예외 발생 시 다시 입력 받도록 구현
            while(true) {
                System.out.println("첫 번째 수 입력: ");
                first_input = scanner.nextLine();
                try {
                    //양수 음수 구분
                    if(first_input.contains("-")){
                        firstNumberIsPositive = -1;
                        first_input.substring(1);
                    }
                    //정수 실수 구분
                    firstNum = first_input.contains(".")? Double.parseDouble(first_input) * firstNumberIsPositive: Integer.parseInt(first_input) * firstNumberIsPositive;
                    break;
                } catch (NumberFormatException e){
                    System.out.println("첫 번째 값 입력이 잘못되었습니다. 실수를 입력해주세요.");
                }
            }
            while(true) {
                System.out.println("두 번째 수 입력: ");
                second_input = scanner.nextLine();
                try{
                    if(second_input.contains("-")){
                        secondNumberIsPositive = -1;
                        second_input.substring(1);
                    }
                    secondNum = second_input.contains(".")? Double.parseDouble(second_input) * firstNumberIsPositive: Integer.parseInt(second_input) * firstNumberIsPositive;
                    break;
                } catch (NumberFormatException e){
                    System.out.println("두 번째 값 입력이 잘못되었습니다. 실수를 입력해주세요.");
                }
            }
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
            try{
                double result = calculator.calculate(firstNum, secondNum);
                System.out.println("결과: " + result);
            } catch (NumberFormatException | CalculatorException e) {
                System.out.println(e.getMessage());
            }


            System.out.println("더 계산하시겠습니까?(exit: 종료, nlist: 특정 값보다 큰 입력값 출력, alist:모든 결과값 출력,remove: 가장 오래된 입력 지움, 나머지: 계속)");
            scanner.nextLine();
            String consist = scanner.nextLine();
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