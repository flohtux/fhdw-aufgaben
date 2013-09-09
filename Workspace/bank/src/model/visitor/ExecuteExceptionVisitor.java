
package model.visitor;

import persistence.*;

public interface ExecuteExceptionVisitor extends DebitExceptionVisitor{
    
    public void handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException;
    public void handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException;
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException;
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException;
    
}
