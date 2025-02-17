package model.exceptions;

public class DomainException extends Exception {
    //a classe pode extender a Exception e a RuntimeException
    //RuntimeException é um tipo de exceção que o compilador não obrigad você a tratar.
    //Já na Exception, o compilador obriga você a tratar.
    public DomainException(String msg){
        super(msg);
    }
}
