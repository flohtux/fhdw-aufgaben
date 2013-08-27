
package view;


import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public abstract class DebitException extends view.ExecuteException{
    
    
    public DebitException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    abstract public void accept(DebitExceptionVisitor visitor) throws ModelException;
    abstract public <R> R accept(DebitExceptionReturnVisitor<R>  visitor) throws ModelException;
    abstract public <E extends UserException>  void accept(DebitExceptionExceptionVisitor<E> visitor) throws ModelException, E;
    abstract public <R, E extends UserException> R accept(DebitExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    
}
