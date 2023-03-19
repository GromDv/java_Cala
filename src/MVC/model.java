package MVC;

import java.util.ArrayList;
import java.util.List;

public class model {
    public String expressionSolution(String expr) {
        String result = null;
        String dig = "";
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int indexAbc = 0;
        List<String> nums = new ArrayList<>(0);
        List<String> opers = new ArrayList<>(0);

        String ex = expr;

        System.out.println(expr);
        System.out.printf("Выражений: %d\n",getNumExpr(expr));
        System.out.printf("В скобках: %s\n",getSubExpr(expr));

        for (int i = 0; i < expr.length(); i++) {

            if (Character.isDigit(ex.charAt(i))) {
                dig += ex.charAt(i);
            } else if (ex.charAt(i) == '+' || ex.charAt(i) == '-' || ex.charAt(i) == '*' || ex.charAt(i) == '/' || ex.charAt(i) == '(' || ex.charAt(i) == ')') {
                opers.add(String.valueOf(ex.charAt(i)));
                if(dig.length() > 0) {
    //                System.out.printf("1dig=%s, i=%d\n", dig, i);
                    nums.add(abc.charAt(indexAbc++)+":"+dig);
                    //indexAbc++;
                    dig = "";
    //                System.out.println("----------------------------");
    //                System.out.printf("size=%d", nums.size());
//                    for (String num : nums) {
//                        System.out.println(num);
//                    }
                }
            }
            if (i == expr.length() - 1) {
    //            System.out.printf("1dig=%s, i=%d\n", dig, i);
                nums.add(abc.charAt(indexAbc)+":"+dig);
            }
        }
//        for (String st : nums) {
//            System.out.printf("- %s\n", st);
//        }
        System.out.printf("Операндов: %d\n",nums.size());
        for (String num : nums) {
            System.out.println(num);
        }
        return result;
    }

    public  int getNumExpr(String expr) {
        int numExpr = 1;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(')
                numExpr++;
        }
        return numExpr;
    }
    public String getSubExpr(String ex) {
        StringBuilder expr = new StringBuilder(ex);
        String res;
        int start = 0, end = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                start = i;
                break;
            }
            start = -1;
            return "no";
        }
        for (int i = expr.length()-1; i >= 0; i--) {
            if (expr.charAt(i) == ')') {
                end = i;
                break;
            }
        }
        res = expr.substring(start+1,end);
        return  res;
    }
}
