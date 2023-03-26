package view;

import java.util.ArrayList;
import java.util.List;

public class mMenu {
    private List<menuPoint> menu;

    public mMenu() {
        this.menu = new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("=======================================\n");
        sb.append("Чтобы выполнить операцию введите номер:\n");
        for (menuPoint pm : this.menu) {
            sb.append(pm.getId() + " - " + pm.getTitle() + "\n");
        }
        sb.append(": ");
        return sb.toString();
    }

    public void addMenuPoint(menuPoint mp) {
        this.menu.add(mp);
    }

    public menuPoint getMenuPointById(int num) {
        for (menuPoint pm : this.menu) {
            if (pm.getId() == num)
                return pm;
        }
        return null;
    }
}
