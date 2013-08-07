
package view;


import viewClient.*;
import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class NoPermissionToExecuteDebitNoteTransferException extends view.UserException{
    
    public static NoPermissionToExecuteDebitNoteTransferException fromHashtableToNoPermissionToExecuteDebitNoteTransferException(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String message = (String)resultTable.get("?Message?");
        return new NoPermissionToExecuteDebitNoteTransferException(message);
    }
    
    public NoPermissionToExecuteDebitNoteTransferException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws ModelException {
        visitor.handleNoPermissionToExecuteDebitNoteTransferException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoPermissionToExecuteDebitNoteTransferException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoPermissionToExecuteDebitNoteTransferException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoPermissionToExecuteDebitNoteTransferException(this);
    }
    
    
}
