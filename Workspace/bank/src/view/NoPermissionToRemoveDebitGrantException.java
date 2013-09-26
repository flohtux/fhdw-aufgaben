
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class NoPermissionToRemoveDebitGrantException extends view.UserException{
    
    public static NoPermissionToRemoveDebitGrantException fromHashtableToNoPermissionToRemoveDebitGrantException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new NoPermissionToRemoveDebitGrantException(message);
    }
    
    public NoPermissionToRemoveDebitGrantException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleNoPermissionToRemoveDebitGrantException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoPermissionToRemoveDebitGrantException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoPermissionToRemoveDebitGrantException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoPermissionToRemoveDebitGrantException(this);
    }
    
    
}
