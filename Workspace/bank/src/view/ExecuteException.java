
package view;


import view.visitor.ExecuteExceptionExceptionVisitor;
import view.visitor.ExecuteExceptionReturnExceptionVisitor;
import view.visitor.ExecuteExceptionReturnVisitor;
import view.visitor.ExecuteExceptionVisitor;


/* Additional import section end */

@SuppressWarnings("serial")
public abstract class ExecuteException extends view.UserException{
    
    
    public ExecuteException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    abstract public void accept(ExecuteExceptionVisitor visitor) throws ModelException;
    abstract public <R> R accept(ExecuteExceptionReturnVisitor<R>  visitor) throws ModelException;
    abstract public <E extends UserException>  void accept(ExecuteExceptionExceptionVisitor<E> visitor) throws ModelException, E;
    abstract public <R, E extends UserException> R accept(ExecuteExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    
}
