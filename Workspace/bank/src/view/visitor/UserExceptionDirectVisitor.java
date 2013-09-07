
package view.visitor;

import view.*;

public abstract class UserExceptionDirectVisitor implements UserExceptionVisitor {
    
    public abstract void handleDoubleRuleDefinitionException(DoubleRuleDefinitionException doubleRuleDefinitionException) throws ModelException;
    
    public abstract void handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException;
    
    public abstract void handleCycleException(CycleException cycleException) throws ModelException;
    
    public abstract void handlePasswordException(PasswordException passwordException) throws ModelException;
    
    public abstract void handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException;
    
    public abstract void handleNoRuleDefinitionException(NoRuleDefinitionException noRuleDefinitionException) throws ModelException;
    
    public abstract void handleGrantAlreadyGivenException(GrantAlreadyGivenException grantAlreadyGivenException) throws ModelException;
    
    public abstract void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    
    public abstract void handleExecuteException(ExecuteException executeException) throws ModelException;
    
    public void handleInvalidBankNumberException(InvalidBankNumberException invalidBankNumberException) throws ModelException{
        this.handleExecuteException(invalidBankNumberException);
    }
    public void handleNoPermissionToExecuteDebitTransferException(NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws ModelException{
        this.handleExecuteException(noPermissionToExecuteDebitTransferException);
    }
    public void handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException{
        this.handleExecuteException(limitViolatedException);
    }
    public void handleInvalidAccountNumberException(InvalidAccountNumberException invalidAccountNumberException) throws ModelException{
        this.handleExecuteException(invalidAccountNumberException);
    }
    public void handleDebitNotGrantedException(DebitNotGrantedException debitNotGrantedException) throws ModelException{
        this.handleExecuteException(debitNotGrantedException);
    }
    public abstract void handleRuleNotMatchedException(RuleNotMatchedException ruleNotMatchedException) throws ModelException;
    
    
}
