
package view.visitor;

import view.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleDoubleRuleDefinitionException(DoubleRuleDefinitionException doubleRuleDefinitionException) throws ModelException{
        this.standardHandling(doubleRuleDefinitionException);
    }
    public void handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException{
        this.standardHandling(noAccountsFound);
    }
    public void handlePasswordException(PasswordException passwordException) throws ModelException{
        this.standardHandling(passwordException);
    }
    public void handleMaximumIsLowerThenMinimumException(MaximumIsLowerThenMinimumException maximumIsLowerThenMinimumException) throws ModelException{
        this.standardHandling(maximumIsLowerThenMinimumException);
    }
    public void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException{
        this.standardHandling(noPermissionToExecuteDebitTransferException);
    }
    public void handleNoRuleDefinitionException(NoRuleDefinitionException noRuleDefinitionException) throws ModelException{
        this.standardHandling(noRuleDefinitionException);
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
    public void handleDebitNotGrantedException(DebitNotGrantedException debitNotGrantedException) throws ModelException{
        this.standardHandling(debitNotGrantedException);
    }
    public void handleRuleNotMatchedException(RuleNotMatchedException ruleNotMatchedException) throws ModelException{
        this.standardHandling(ruleNotMatchedException);
    }
    public void handleCycleException(CycleException cycleException) throws ModelException{
        this.standardHandling(cycleException);
    }
    public void handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException{
        this.standardHandling(closeAccountNoPossibleException);
    }
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException{
        this.standardHandling(invalidBankNumberException);
    }
    public void handleMinimumIsHigherThenMaximumException(MinimumIsHigherThenMaximumException minimumIsHigherThenMaximumException) throws ModelException{
        this.standardHandling(minimumIsHigherThenMaximumException);
    }
    public void handleGrantAlreadyGivenException(GrantAlreadyGivenException grantAlreadyGivenException) throws ModelException{
        this.standardHandling(grantAlreadyGivenException);
    }
    protected abstract void standardHandling(UserException userException) throws ModelException;
}
