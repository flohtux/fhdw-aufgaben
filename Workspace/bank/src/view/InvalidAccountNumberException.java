
package view;


import view.visitor.AccountSearchExceptionExceptionVisitor;
import view.visitor.AccountSearchExceptionReturnExceptionVisitor;
import view.visitor.AccountSearchExceptionReturnVisitor;
import view.visitor.AccountSearchExceptionVisitor;
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
public class InvalidAccountNumberException extends view.AccountSearchException{
    
    public static InvalidAccountNumberException fromHashtableToInvalidAccountNumberException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new InvalidAccountNumberException(message);
    }
    
    public InvalidAccountNumberException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(AccountSearchExceptionVisitor visitor) throws ModelException {
        visitor.handleInvalidAccountNumberException(this);
    }
    public <R> R accept(AccountSearchExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public <E extends UserException>  void accept(AccountSearchExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleInvalidAccountNumberException(this);
    }
    public <R, E extends UserException> R accept(AccountSearchExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public void accept(ExecuteExceptionVisitor visitor) throws ModelException {
        visitor.handleInvalidAccountNumberException(this);
    }
    public <R> R accept(ExecuteExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public <E extends UserException>  void accept(ExecuteExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleInvalidAccountNumberException(this);
    }
    public <R, E extends UserException> R accept(ExecuteExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleInvalidAccountNumberException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleInvalidAccountNumberException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleInvalidAccountNumberException(this);
    }
    
    
}
