package model;

import model.Interfaces.Execute;
import view.view;

public class opEmpty extends Operation implements Execute {
    @Override
    public String execute(view vw) {
        return "Спасибо, заходите ещё!";
    }
}
