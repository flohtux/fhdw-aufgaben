
package model.visitor;

import persistence.*;

public interface ExecuteExceptionVisitor extends DebitExceptionVisitor,AccountSearchExceptionVisitor{
    
    public void handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException;
    public void handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException;
    
}
