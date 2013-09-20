
package model.visitor;

import persistence.*;

public interface ExecuteExceptionReturnVisitor<R> extends DebitExceptionReturnVisitor<R> ,AccountSearchExceptionReturnVisitor<R> {
    
    public R handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException;
    public R handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException;
    
}
