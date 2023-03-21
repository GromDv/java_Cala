package model;

public class singleExpession {
    private int start;
    private int end;
    private int len;
    private String result, newExp;

    public singleExpession() {
        this.start = 0;
        this.end = 0;
        this.len = 0;
        this.newExp = "";
        this.result = "";
    }

    public String getResult() {
        return this.result;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public void getSingleExpr(String expr) {
        StringBuilder ex = new StringBuilder(expr);
        getSingleExpr(ex);
    }

    public void getSingleExpr(StringBuilder ex) {
        int start = 0, end = 0;
        for (int i = 0; i < ex.length(); i++)
            if (ex.charAt(i) == '(')
                start = i;
        this.start = start;
        for (int i = start; i < ex.length(); i++) {
            if (ex.charAt(i) == ')') {
                end = i;
                break;
            }
        }
        this.end = end + 1;
        if (this.end == 1) {
            this.start = 0;
            this.end = ex.length();
        }
        //System.out.println("st: "+this.start+" e: "+this.end+"len: "+ex.length());
        this.result = ex.substring(this.start, this.end);
    }
}
