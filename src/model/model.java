package model;

import java.util.*;

public class model {
    public String expressionSolution(String ex) {
        //System.out.println("Входное выражение"+ex);
        int numSubs = getNumexpr(ex);
        //System.out.printf("Влож.выражений: %d\n", numSubs);

        StringBuilder tmp = new StringBuilder(ex);
        singleExpession tm = new singleExpession();

        for (int jk = 0; jk < numSubs; jk++) {
            tm.getSingleExpr(tmp);
            //System.out.printf("Single: %s\n", tm.getResult());
            String tres = calcSimpleExpr(ParcedExpression.parceSingleExpr(tm.getResult()));
            //System.out.printf("Counted: %s\n", tres);
            tmp.replace(tm.getStart(), tm.getEnd(), tres);
            //System.out.println("Itog: " + tmp);
        }
        return String.format("%s = %s", ex, tmp);

    }

    public int getNumexpr(String ex) {
        int numex = 1, numexB = 1;
        for (int i = 0; i < ex.length(); i++) {
            if (ex.charAt(i) == '(')
                numex++;
            if (ex.charAt(i) == ')')
                numexB++;
        }
        if (numex != numexB)
            numex = -1;
        return numex;
    }

    public List<String> calcExpr(ParcedExpression lpe) {
        return calcExpr(lpe.getNums(), lpe.getOpers());
    }

    public List<String> calcExpr(List<String> num, List<String> opMap) {
//        System.out.println("calc");
        while (opMap.contains("*") || opMap.contains("/")) {
//            System.out.println("calc-1");
            for (int i = 0; i < opMap.size(); i++) {
                if (Objects.equals(opMap.get(i), "*")) {
                    String result = doOperation("*", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                } else if (Objects.equals(opMap.get(i), "/")) {
                    String result = doOperation("/", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                }
            }
            //           num.forEach((s) -> System.out.println("ClcN: " + s));
        }
        while (opMap.contains("+") || opMap.contains("-")) {
//            System.out.println("calc-1");
            for (int i = 0; i < opMap.size(); i++) {
                if (Objects.equals(opMap.get(i), "+")) {
                    String result = doOperation("+", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                } else if (Objects.equals(opMap.get(i), "-")) {
                    String result = doOperation("-", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                }
            }
            //           num.forEach((s) -> System.out.println("ClcN: " + s));
        }
        return new ArrayList<>(num);
    }

    public String calcSimpleExpr(ParcedExpression lpe) {
        return calcSimpleExpr(lpe.getNums(), lpe.getOpers());
    }

    public String calcSimpleExpr(List<String> num, List<String> opMap) {
        while (opMap.contains("*") || opMap.contains("/")) {
//            System.out.println("calc-1");
            for (int i = 0; i < opMap.size(); i++) {
                if (Objects.equals(opMap.get(i), "*")) {
                    String result = doOperation("*", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                } else if (Objects.equals(opMap.get(i), "/")) {
                    String result = doOperation("/", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                }
            }
            //           num.forEach((s) -> System.out.println("ClcN: " + s));
        }
        while (opMap.contains("+") || opMap.contains("-")) {
//            System.out.println("calc-1");
            for (int i = 0; i < opMap.size(); i++) {
                if (Objects.equals(opMap.get(i), "+")) {
                    String result = doOperation("+", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                } else if (Objects.equals(opMap.get(i), "-")) {
                    String result = doOperation("-", num.get(i), num.get(i + 1));
                    opMap.remove(i);
                    num.remove(i + 1);
                    num.set(i, result);
                }
            }
            //           num.forEach((s) -> System.out.println("ClcN: " + s));
        }
        return num.get(0);
    }

    public String doOperation(String op, String as, String bs) {

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
