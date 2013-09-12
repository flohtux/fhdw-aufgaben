
package view.visitor;

import view.*;

public abstract class ExecuteExceptionDirectVisitor implements ExecuteExceptionVisitor {
    
    public abstract void handleDebitException(DebitException debitException) throws ModelException;
    
    public void handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException{
        this.handleDebitException(limitViolatedException);
    }
    public void handleDebitNotGrantedException(DebitNotGrantedException debitNotGrantedException) throws ModelException{
        this.handleDebitException(debitNotGrantedException);
    }
    public abstract void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException;
    
    public abstract void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException;
    
    public abstract void handleTriggerCyclicException(TriggerCyclicException triggerCyclicException) throws ModelException;
    
    public abstract void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException;
    
    
}
