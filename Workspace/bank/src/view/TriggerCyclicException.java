
package view;


import view.visitor.ExecuteExceptionExceptionVisitor;
import view.visitor.ExecuteExceptionReturnExceptionVisitor;
import view.visitor.ExecuteExceptionReturnVisitor;
import view.visitor.ExecuteExceptionVisitor;
import view.visitor.UserExceptionExceptionVisitor;
import view.visitor.UserExceptionReturnExceptionVisitor;
import view.visitor.UserExceptionReturnVisitor;
import view.visitor.UserExceptionVisitor;
import viewClient.ExceptionAndEventHandler;


/* Additional import section end */

@SuppressWarnings("serial")
public class TriggerCyclicException extends view.ExecuteException{
    
    public static TriggerCyclicException fromHashtableToTriggerCyclicException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new TriggerCyclicException(message);
    }
    
    public TriggerCyclicException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(ExecuteExceptionVisitor visitor) throws ModelException {
        visitor.handleTriggerCyclicException(this);
    }
    public <R> R accept(ExecuteExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTriggerCyclicException(this);
    }
    public <E extends UserException>  void accept(ExecuteExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTriggerCyclicException(this);
    }
    public <R, E extends UserException> R accept(ExecuteExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTriggerCyclicException(this);
    }
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleTriggerCyclicException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTriggerCyclicException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTriggerCyclicException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTriggerCyclicException(this);
    }
    
    
}
