package model;

import model.Interfaces.Execute;
import view.view;

public class opPass extends Operation implements Execute {

    @Override
    public String execute(view vw) {
        return "Пустая операция (для примера)";
    }
}
