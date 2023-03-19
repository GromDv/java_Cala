package MVC;

import java.util.Scanner;

public class view {
    private Scanner sc = new Scanner(System.in);

    public int getMainMenuChoice() {
        int res = 0;
        System.out.println("======================================================");
        System.out.println("Чтобы выполнить операцию введите номер:");
        System.out.println("   1 - ввести выражение для рассчета");
        System.out.println("   9 - закончить");
        System.out.print(": ");
        res = sc.nextInt();
        sc.nextLine();
        return res;
    }

    public String getUserExpression() {
        String res;
        System.out.print("Введите выражение : ");
        res = sc.nextLine();
        return res;
    }
}
