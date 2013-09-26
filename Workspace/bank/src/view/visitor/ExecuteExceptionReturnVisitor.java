
package view.visitor;

import view.*;

public interface ExecuteExceptionReturnVisitor<R> extends AccountSearchExceptionReturnVisitor<R> ,DebitExceptionReturnVisitor<R> {
    
    public R handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException;
    public R handleTriggerCyclicException(TriggerCyclicException triggerCyclicException) throws ModelException;
    
}
