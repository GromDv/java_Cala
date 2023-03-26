package model;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import model.Exceptions.MissmatchBracketsException;
import model.Exceptions.UnknownOperatorException;
import view.*;

public class opCalculate extends Operation {

    static Logger logger = Logger.getLogger(opCalculate.class.getName());

    public opCalculate() {
        FileHandler fh;
        try {
            fh = new FileHandler("logCalc.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
    }

    @Override
    public String execute(view vw) {
        String inputExp = vw.getUserExpression();
//        logger.info("Входное выражение: "+inputExp);
        int numSubs = 0;
        try {
            numSubs = getNumexpr(inputExp);
        } catch (MissmatchBracketsException e) {
            return e.getMessage();
        }
//        logger.info("Всего вложенных выражений: " + numSubs);
        StringBuilder tmp = new StringBuilder(inputExp);
        singleExpession tm = new singleExpession();

        for (int jk = 0; jk < numSubs; jk++) {
            tm.getSingleExpr(tmp);
//            logger.info("Простое: " + tm.getResult());
            String tres = "";
            try {
                tres = calcSimpleExpr(ParsedExpression.parseSingleExpr(tm.getResult()));
            } catch (UnknownOperatorException e) {
                return e.getMessage();
            }
//            logger.info("Посчитано: " + tres);
            tmp.replace(tm.getStart() - 1, tm.getEnd() + 1, tres);
//            logger.info("Итого: " + tmp);
        }
        return String.format("%s = %s", inputExp, tmp);
    }

    private int getNumexpr(String ex) throws MissmatchBracketsException {
        int numOpenBrackets = 1, numCloseBrackets = 1;
        for (int i = 0; i < ex.length(); i++) {
            if (ex.charAt(i) == '(')
                numOpenBrackets++;
            if (ex.charAt(i) == ')')
                numCloseBrackets++;
        }
        if (numOpenBrackets != numCloseBrackets)
            throw new MissmatchBracketsException();
        return numOpenBrackets;
    }

    private String calcSimpleExpr(ParsedExpression lpe) {
        return calcSimpleExpr(lpe.getNums(), lpe.getOpers());
    }

    private String calcSimpleExpr(List<String> num, List<String> opMap) {
//        num.forEach((s) -> logger.info("List: " + s));
        while (opMap.contains("*") || opMap.contains("/")) {
            for (int i = 0; i < opMap.size(); i++) {
                if (Objects.equals(opMap.get(i), "*")) {
//                    logger.info("Считаем: "+opMap.get(i));
                    String result = doMathOperation("*", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                } else if (Objects.equals(opMap.get(i), "/")) {
//                    logger.info("Считаем: "+opMap.get(i));
                    String result = doMathOperation("/", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                }
            }
        }
        while (opMap.contains("+") || opMap.contains("-")) {
            for (int i = 0; i < opMap.size(); i++) {
                if (Objects.equals(opMap.get(i), "+")) {
//                    logger.info("Считаем: "+opMap.get(i));
                    String result = doMathOperation("+", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                } else if (Objects.equals(opMap.get(i), "-")) {
//                    logger.info("Считаем: "+opMap.get(i));
                    String result = doMathOperation("-", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                }
            }
            //
        }
//        num.forEach((s) -> logger.info("List: " + s));
        return num.get(0);
    }

    private String doMathOperation(String op, String as, String bs) {

        double a = Double.parseDouble(as.replace(',', '.'));
        double b = Double.parseDouble(bs.replace(',', '.'));

        Double res = switch (op) {
            case "*" -> a * b;
            case "/" -> a / b;
            case "+" -> a + b;
            case "-" -> a - b;
            default -> throw new IllegalStateException("Unexpected value: " + op);
        };

        //return String.format("%.2f", res);
        return Double.toString(res);
    }
}
