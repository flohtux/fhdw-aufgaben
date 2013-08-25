
package view.visitor;

import view.*;

public abstract class ExecuteExceptionStandardVisitor implements ExecuteExceptionVisitor {
    
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException{
        this.standardHandling(invalidBankNumberException);
    }
    public void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException{
        this.standardHandling(noPermissionToExecuteDebitTransferException);
    }
    public void handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException{
        this.standardHandling(limitViolatedException);
    }
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException{
        this.standardHandling(invalidAccountNumberException);
    }
    public void handleDebitNotGrantedException(DebitNotGrantedException debitNotGrantedException) throws ModelException{
        this.standardHandling(debitNotGrantedException);
    }
    protected abstract void standardHandling(ExecuteException executeException) throws ModelException;
}
