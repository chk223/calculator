import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("첫 번째 수 입력: ");
            int first_num = scanner.nextInt();
            System.out.println("두 번째 수 입력: ");
            int second_num = scanner.nextInt();
            System.out.println("사칙연산 기호 입력: ");
            char operator = scanner.next().charAt(0);
            switch (operator) {
                case '+':
                    System.out.println("결과: " + (first_num + second_num));
                    break;
                case '-':
                    System.out.println("결과: " + (first_num - second_num));
                    break;
                case '*':
                    System.out.println("결과: " + (first_num * second_num));
                    break;
                case '/':
                    if (second_num == 0) System.out.println("0으로 나눌 수 없음");
                    else System.out.println("결과: " + ((double) first_num/ second_num));
                    break;
            }
            scanner.nextLine();
            System.out.println("더 계산하시겠습니까?(exit 입력 시 종료)");
            String consist = scanner.nextLine();
            if (consist.equals("exit")) break;
        }
    }
}