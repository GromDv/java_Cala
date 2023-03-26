package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class view {
    private Scanner sc;

    public view(Scanner scanner) {
        this.sc = scanner;
    }

    public int getMainMenuChoice(mMenu nm) {
        System.out.print(nm);
        int res;
        try {
            res = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введено что-то не то, попробуйте ещё раз!");
            res = -1;
        }
        sc.nextLine();
        return res;
    }

    public String getUserExpression() {
        String res;
        System.out.print("Введите выражение : ");
        res = sc.nextLine();
        return res.trim();
    }

    public void ShowString(String res) {
        System.out.printf("Результат: %s\n", res);
    }
}
