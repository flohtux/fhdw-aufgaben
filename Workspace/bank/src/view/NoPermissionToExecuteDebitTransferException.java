
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class NoPermissionToExecuteDebitTransferException extends view.ExecuteException{
    
    public static NoPermissionToExecuteDebitTransferException fromHashtableToNoPermissionToExecuteDebitTransferException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new NoPermissionToExecuteDebitTransferException(message);
    }
    
    public NoPermissionToExecuteDebitTransferException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(ExecuteExceptionVisitor visitor) throws ModelException {
        visitor.handleNoPermissionToExecuteDebitTransferException(this);
    }
    public <R> R accept(ExecuteExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoPermissionToExecuteDebitTransferException(this);
    }
    public <E extends UserException>  void accept(ExecuteExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoPermissionToExecuteDebitTransferException(this);
    }
    public <R, E extends UserException> R accept(ExecuteExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoPermissionToExecuteDebitTransferException(this);
    }
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleNoPermissionToExecuteDebitTransferException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoPermissionToExecuteDebitTransferException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoPermissionToExecuteDebitTransferException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoPermissionToExecuteDebitTransferException(this);
    }
    
    
}
