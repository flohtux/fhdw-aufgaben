
package model.visitor;

import persistence.*;

public abstract class ExecuteExceptionStandardVisitor implements ExecuteExceptionVisitor {
    
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException{
        this.standardHandling(invalidBankNumberException);
    }
    public void handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException{
        this.standardHandling(noPermissionToExecuteDebitTransferException);
    }
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException{
        this.standardHandling(limitViolatedException);
    }
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException{
        this.standardHandling(invalidAccountNumberException);
    }
    public void handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException{
        this.standardHandling(triggerCyclicException);
    }
    public void handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException{
        this.standardHandling(debitNotGrantedException);
    }
    protected abstract void standardHandling(model.ExecuteException executeException) throws PersistenceException;
}
