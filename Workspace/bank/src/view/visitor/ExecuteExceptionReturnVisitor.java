
package view.visitor;

import view.*;

public interface ExecuteExceptionReturnVisitor<R> extends DebitExceptionReturnVisitor<R> ,AccountSearchExceptionReturnVisitor<R> {
    
    public R handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException;
    public R handleTriggerCyclicException(TriggerCyclicException triggerCyclicException) throws ModelException;
    
}
