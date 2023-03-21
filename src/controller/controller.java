package controller;

import model.model;
import view.view;

public class controller {
    view mainView = new view();
    model mainModel = new model();

    public void Start() {


        while (true) {
            switch (mainView.getMainMenuChoice()) {
                case 1 -> {
                    String res = mainModel.expressionSolution(mainView.getUserExpression());
                    mainView.ShowString(res);
                }
                case 2 -> {
                    return;
                }
                default -> {
                }
            }
        }
    }


}
