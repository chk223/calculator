import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while(true) {
            System.out.println("첫 번째 수 입력: ");
            int first_num = scanner.nextInt();
            System.out.println("두 번째 수 입력: ");
            int second_num = scanner.nextInt();
            System.out.println("사칙연산 기호 입력: ");
            char operator = scanner.next().charAt(0);
            calculator.setOperator(operator);
            double result = calculator.calculate(first_num, second_num);
            System.out.println("결과 : "+ result);
            System.out.println("더 계산하시겠습니까?(exit: 종료, list: 결과값 리스트 출력, remove: 가장 오래된 입력 지움, 나머지: 계속)");
            scanner.nextLine();
            String consist = scanner.nextLine();
            if(consist.equals("list")) calculator.getResults();
            if(consist.equals("remove")) calculator.removeResult();
            if (consist.equals("exit")) break;
        }
    }
}