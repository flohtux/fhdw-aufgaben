
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleDoubleRuleDefinitionException(model.DoubleRuleDefinitionException doubleRuleDefinitionException) throws PersistenceException{
        this.standardHandling(doubleRuleDefinitionException);
    }
    public void handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException{
        this.standardHandling(noAccountsFound);
    }
    public void handleNoValidFeeValueException(model.NoValidFeeValueException noValidFeeValueException) throws PersistenceException{
        this.standardHandling(noValidFeeValueException);
    }
    public void handlePasswordException(model.PasswordException passwordException) throws PersistenceException{
        this.standardHandling(passwordException);
    }
    public void handleNoValidPercentValueException(model.NoValidPercentValueException noValidPercentValueException) throws PersistenceException{
        this.standardHandling(noValidPercentValueException);
    }
    public void handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException{
        this.standardHandling(noPermissionToExecuteDebitTransferException);
    }
    public void handleMinLimitHigherMaxLimitException(model.MinLimitHigherMaxLimitException minLimitHigherMaxLimitException) throws PersistenceException{
        this.standardHandling(minLimitHigherMaxLimitException);
    }
    public void handleNoRuleDefinitionException(model.NoRuleDefinitionException noRuleDefinitionException) throws PersistenceException{
        this.standardHandling(noRuleDefinitionException);
    }
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException{
        this.standardHandling(limitViolatedException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    public void handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException{
        this.standardHandling(debitNotGrantedException);
    }
    public void handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException{
        this.standardHandling(triggerCyclicException);
    }
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException{
        this.standardHandling(invalidAccountNumberException);
    }
    public void handleRuleNotMatchedException(model.RuleNotMatchedException ruleNotMatchedException) throws PersistenceException{
        this.standardHandling(ruleNotMatchedException);
    }
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException{
        this.standardHandling(closeAccountNoPossibleException);
    }
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException{
        this.standardHandling(invalidBankNumberException);
    }
    public void handleMaxLimitLowerThenMinLimitException(model.MaxLimitLowerThenMinLimitException maxLimitLowerThenMinLimitException) throws PersistenceException{
        this.standardHandling(maxLimitLowerThenMinLimitException);
    }
    public void handleGrantAlreadyGivenException(model.GrantAlreadyGivenException grantAlreadyGivenException) throws PersistenceException{
        this.standardHandling(grantAlreadyGivenException);
    }
    public void handleCompensationAbortedException(model.CompensationAbortedException compensationAbortedException) throws PersistenceException{
        this.standardHandling(compensationAbortedException);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}
