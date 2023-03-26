package controller;

import model.*;
import view.*;

public class controller {
    private view view;

    public controller(view View) {
        this.view = View;
    }

    public void Start() {

        mMenu mainMenu = new mMenu();
        mainMenu.addMenuPoint(new menuPoint("Ввести выражение для рассчета", 1, new opCalculate()));
        mainMenu.addMenuPoint(new menuPoint("Что-то посчитать", 6, new opPass()));
        mainMenu.addMenuPoint(new menuPoint("Что-то посчитать", 7, new opPass()));
        mainMenu.addMenuPoint(new menuPoint("Закончить", 9, new opEmpty()));

        menuService(mainMenu);
    }

    private void menuService(mMenu menu) {
        int n;
        do {
            n = view.getMainMenuChoice(menu);
            if (n > 0) view.ShowString(menu.getMenuPointById(n).execute(view));
        } while (n != 9);
    }
}
