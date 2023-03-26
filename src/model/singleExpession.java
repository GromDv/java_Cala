package model;

public class singleExpession {
    private int start;
    private int end;
    private String result;

    public String getResult() {
        return this.result;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public void getSingleExpr(StringBuilder ex) {
        int start = -1, end = 0;
        for (int i = 0; i < ex.length(); i++)
            if (ex.charAt(i) == '(')
                start = i;
        if (start >= 0) {
            start++;
            this.start = start;
            for (int i = start; i < ex.length(); i++) {
                if (ex.charAt(i) == ')') {
                    end = i;
                    break;
                }
            }
            this.end = end;
            this.result = ex.substring(this.start, this.end);
        } else {
            this.start = 1;
            this.end = ex.length() - 1;
            this.result = ex.toString();
        }
    }
}
