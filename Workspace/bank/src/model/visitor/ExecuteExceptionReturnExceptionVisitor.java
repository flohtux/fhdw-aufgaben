
package model.visitor;
import model.UserException;
import persistence.*;

public interface ExecuteExceptionReturnExceptionVisitor<R, E extends UserException> extends DebitExceptionReturnExceptionVisitor<R, E> ,AccountSearchExceptionReturnExceptionVisitor<R, E> {
    
    public R handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException, E;
    public R handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException, E;
    
}
