
package view.visitor;

import view.*;

public interface ExecuteExceptionVisitor extends DebitExceptionVisitor,AccountSearchExceptionVisitor{
    
    public void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException;
    public void handleTriggerCyclicException(TriggerCyclicException triggerCyclicException) throws ModelException;
    
}
