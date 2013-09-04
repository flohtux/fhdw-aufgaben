
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException{
        this.standardHandling(noAccountsFound);
    }
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handlePasswordException(model.PasswordException passwordException) throws PersistenceException{
        this.standardHandling(passwordException);
    }
    public void handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException{
        this.standardHandling(closeAccountNoPossibleException);
    }
    public void handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException{
        this.standardHandling(noPermissionToExecuteDebitTransferException);
    }
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException{
        this.standardHandling(invalidBankNumberException);
    }
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException{
        this.standardHandling(limitViolatedException);
    }
    public void handleGrantAlreadyGivenException(model.GrantAlreadyGivenException grantAlreadyGivenException) throws PersistenceException{
        this.standardHandling(grantAlreadyGivenException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    public void handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException{
        this.standardHandling(debitNotGrantedException);
    }
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException{
        this.standardHandling(invalidAccountNumberException);
    }
    public void handleRuleNotMatchedException(model.RuleNotMatchedException ruleNotMatchedException) throws PersistenceException{
        this.standardHandling(ruleNotMatchedException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
