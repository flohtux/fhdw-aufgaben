
package model.visitor;

import persistence.*;

public interface ExecuteExceptionReturnVisitor<R> extends AccountSearchExceptionReturnVisitor<R> ,DebitExceptionReturnVisitor<R> {
    
    public R handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException;
    public R handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException;
    
}
