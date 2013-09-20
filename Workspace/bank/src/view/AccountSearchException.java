
package view;


import view.visitor.AccountSearchExceptionExceptionVisitor;
import view.visitor.AccountSearchExceptionReturnExceptionVisitor;
import view.visitor.AccountSearchExceptionReturnVisitor;
import view.visitor.AccountSearchExceptionVisitor;


/* Additional import section end */

@SuppressWarnings("serial")
public abstract class AccountSearchException extends view.ExecuteException{
    
    
    public AccountSearchException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    abstract public void accept(AccountSearchExceptionVisitor visitor) throws ModelException;
    abstract public <R> R accept(AccountSearchExceptionReturnVisitor<R>  visitor) throws ModelException;
    abstract public <E extends UserException>  void accept(AccountSearchExceptionExceptionVisitor<E> visitor) throws ModelException, E;
    abstract public <R, E extends UserException> R accept(AccountSearchExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    
}
