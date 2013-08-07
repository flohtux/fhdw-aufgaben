
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleCycleException(CycleException cycleException) throws ModelException{
        this.standardHandling(cycleException);
    }
    public void handlePasswordException(PasswordException passwordException) throws ModelException{
        this.standardHandling(passwordException);
    }
    public void handleNoPermissionToExecuteDebitNoteTransferException(NoPermissionToExecuteDebitNoteTransferException noPermissionToExecuteDebitNoteTransferException) throws ModelException{
        this.standardHandling(noPermissionToExecuteDebitNoteTransferException);
    }
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException{
        this.standardHandling(invalidBankNumberException);
    }
    public void handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException{
        this.standardHandling(closeAccountNoPossibleException);
    }
    public void handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException{
        this.standardHandling(limitViolatedException);
    }
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException{
        this.standardHandling(restrictionException);
    }
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException{
        this.standardHandling(invalidAccountNumberException);
    }
    protected abstract void standardHandling(UserException userException) throws ModelException;
}
