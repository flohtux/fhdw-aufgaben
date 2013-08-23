
package view.visitor;

import view.*;

public abstract class UserExceptionDirectVisitor implements UserExceptionVisitor {
    
    public abstract void handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException;
    
    public abstract void handleCycleException(CycleException cycleException) throws ModelException;
    
    public abstract void handlePasswordException(PasswordException passwordException) throws ModelException;
    
    public abstract void handleDebitException(DebitException debitException) throws ModelException;
    
    public void handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException{
        this.handleDebitException(limitViolatedException);
    }
    public void handleDebitNotGrantedException(DebitNotGrantedException debitNotGrantedException) throws ModelException{
        this.handleDebitException(debitNotGrantedException);
    }
    public abstract void handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException;
    
    public abstract void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException;
    
    public abstract void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException;
    
    public abstract void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
    public abstract void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException;
    
    
}
