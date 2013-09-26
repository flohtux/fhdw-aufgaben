
package view.visitor;

import view.*;

public interface ExecuteExceptionVisitor extends AccountSearchExceptionVisitor,DebitExceptionVisitor{
    
    public void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException;
    public void handleTriggerCyclicException(TriggerCyclicException triggerCyclicException) throws ModelException;
    
}
