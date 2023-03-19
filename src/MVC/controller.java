package MVC;

public class controller {
    view mainView = new view();
    model mainModel = new model();
    public void Start() {


        while (true) {
            switch (mainView.getMainMenuChoice()) {
                case 1 -> {
                    mainModel.expressionSolution(mainView.getUserExpression());
                }
                case 9 -> {
                    return;
                }
                default -> {
                }
            }
        }
    }


}
