package model;

import java.util.*;

public class ParcedExpression {
    private List<String> nums;
    private List<String> opers;

    public ParcedExpression() {
        this.nums = new ArrayList<>(0);
        this.opers = new ArrayList<>(0);
    }

    public int getNumsSize() {
        return this.nums.size();
    }

    public int getOpersSize() {
        return this.opers.size();
    }

    public List<String> getNums() {
        return this.nums;
    }

    public List<String> getOpers() {
        return this.opers;
    }

    public static ParcedExpression parceSingleExpr(String ex) {
        ParcedExpression expr = new ParcedExpression();
        StringBuilder dig = new StringBuilder(10);

        for (int i = 0; i < ex.length(); i++) {

            if (Character.isDigit(ex.charAt(i)) || ex.charAt(i) == '.') {
                dig.append(ex.charAt(i));
            } else if (ex.charAt(i) == '+' || ex.charAt(i) == '-' || ex.charAt(i) == '*' || ex.charAt(i) == '/') {
                expr.opers.add(String.valueOf(ex.charAt(i)));
                if (dig.length() > 0) {
                    expr.nums.add(String.valueOf(dig));
                    dig.delete(0, dig.length());
                }
            }
            if (i == ex.length() - 1) {
                expr.nums.add(String.valueOf(dig));
            }
        }
        return expr;
    }


}
