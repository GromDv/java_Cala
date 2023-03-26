package model;

import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import model.Exceptions.UnknownOperatorException;

public class ParsedExpression {

    static Logger logger = Logger.getLogger(ParsedExpression.class.getName());
    private List<String> nums;
    private List<String> opers;

    public ParsedExpression() {
        this.nums = new ArrayList<>(0);
        this.opers = new ArrayList<>(0);
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

    public List<String> getNums() {
        return this.nums;
    }

    public List<String> getOpers() {
        return this.opers;
    }

    public static ParsedExpression parseSingleExpr(String ex) throws UnknownOperatorException {
//        logger.info(ex);
        ParsedExpression expr = new ParsedExpression();
        StringBuilder dig = new StringBuilder(10);

        for (int i = 0; i < ex.length(); i++) {
//            logger.info(("look: " + ex.charAt(i)));
            if (Character.isDigit(ex.charAt(i)) || ex.charAt(i) == '.') {
//                logger.info(("dig: " + ex.charAt(i)));
                dig.append(ex.charAt(i));
            } else if (ex.charAt(i) == '+' || ex.charAt(i) == '-' || ex.charAt(i) == '*' || ex.charAt(i) == '/') {
//                logger.info(("oper: " + ex.charAt(i)));
                expr.opers.add(String.valueOf(ex.charAt(i)));
                if (dig.length() > 0) {
                    expr.nums.add(String.valueOf(dig));
                    dig.delete(0, dig.length());
                }
            } else if (ex.charAt(i) == ' ') {
            } else {
                throw new UnknownOperatorException("\"" + ex.charAt(i) + "\"");
//                logger.info(("unknown op: " + ex.charAt(i)));
            }
            if (i == ex.length() - 1) {
                expr.nums.add(String.valueOf(dig));
            }
        }
        return expr;
    }
}
