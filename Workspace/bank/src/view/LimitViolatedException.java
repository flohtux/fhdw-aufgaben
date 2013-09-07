
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class LimitViolatedException extends view.DebitException{
    
    public static LimitViolatedException fromHashtableToLimitViolatedException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new LimitViolatedException(message);
    }
    
    public LimitViolatedException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(DebitExceptionVisitor visitor) throws ModelException {
        visitor.handleLimitViolatedException(this);
    }
    public <R> R accept(DebitExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLimitViolatedException(this);
    }
    public <E extends UserException>  void accept(DebitExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLimitViolatedException(this);
    }
    public <R, E extends UserException> R accept(DebitExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLimitViolatedException(this);
    }
    public void accept(ExecuteExceptionVisitor visitor) throws ModelException {
        visitor.handleLimitViolatedException(this);
    }
    public <R> R accept(ExecuteExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLimitViolatedException(this);
    }
    public <E extends UserException>  void accept(ExecuteExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLimitViolatedException(this);
    }
    public <R, E extends UserException> R accept(ExecuteExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLimitViolatedException(this);
    }
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleLimitViolatedException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleLimitViolatedException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleLimitViolatedException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleLimitViolatedException(this);
    }
    
    
}
