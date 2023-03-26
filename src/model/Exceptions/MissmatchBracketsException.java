package model.Exceptions;

public class MissmatchBracketsException extends Exception {
        public MissmatchBracketsException() {
            super("Ошиблись, в выражении есть несоответствие скобок!");
        }
}
