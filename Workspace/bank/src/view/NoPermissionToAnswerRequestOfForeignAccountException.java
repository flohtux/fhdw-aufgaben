
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class NoPermissionToAnswerRequestOfForeignAccountException extends view.UserException{
    
    public static NoPermissionToAnswerRequestOfForeignAccountException fromHashtableToNoPermissionToAnswerRequestOfForeignAccountException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new NoPermissionToAnswerRequestOfForeignAccountException(message);
    }
    
    public NoPermissionToAnswerRequestOfForeignAccountException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleNoPermissionToAnswerRequestOfForeignAccountException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoPermissionToAnswerRequestOfForeignAccountException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoPermissionToAnswerRequestOfForeignAccountException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoPermissionToAnswerRequestOfForeignAccountException(this);
    }
    
    
}
