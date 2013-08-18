
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class InvalidBankNumberException extends view.UserException{
    
    public static InvalidBankNumberException fromHashtableToInvalidBankNumberException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        long bn = new Long((String)resultTable.get("bn")).longValue();
        return new InvalidBankNumberException(message, (long)bn);
    }
    protected long bn;
    
    public InvalidBankNumberException(String message, long bn) {
        /* Shall not be used. Objects are created on the server only */
        super(message);
        this.bn = bn;        
    }
    
    public long getBn()throws ModelException{
        return this.bn;
    }
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleInvalidBankNumberException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleInvalidBankNumberException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleInvalidBankNumberException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleInvalidBankNumberException(this);
    }
    
    
}
