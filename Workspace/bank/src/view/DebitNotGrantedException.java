
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class DebitNotGrantedException extends view.DebitException{
    
    public static DebitNotGrantedException fromHashtableToDebitNotGrantedException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new DebitNotGrantedException(message);
    }
    
    public DebitNotGrantedException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(DebitExceptionVisitor visitor) throws ModelException {
        visitor.handleDebitNotGrantedException(this);
    }
    public <R> R accept(DebitExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitNotGrantedException(this);
    }
    public <E extends UserException>  void accept(DebitExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitNotGrantedException(this);
    }
    public <R, E extends UserException> R accept(DebitExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitNotGrantedException(this);
    }
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleDebitNotGrantedException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebitNotGrantedException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebitNotGrantedException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebitNotGrantedException(this);
    }
    
    
}
