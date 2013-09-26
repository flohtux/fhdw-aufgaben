
package model.visitor;

import model.*;
import persistence.*;

public abstract class UserExceptionDirectVisitor implements UserExceptionVisitor {
    
    public abstract void handleDoubleRuleDefinitionException(model.DoubleRuleDefinitionException doubleRuleDefinitionException) throws PersistenceException;
    
    public abstract void handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException;
    
    public abstract void handleNoPermissionToAnswerRequestOfForeignAccountException(model.NoPermissionToAnswerRequestOfForeignAccountException noPermissionToAnswerRequestOfForeignAccountException) throws PersistenceException;
    
    public abstract void handleNoValidFeeValueException(model.NoValidFeeValueException noValidFeeValueException) throws PersistenceException;
    
    public abstract void handlePasswordException(model.PasswordException passwordException) throws PersistenceException;
    
    public abstract void handleNoValidPercentValueException(model.NoValidPercentValueException noValidPercentValueException) throws PersistenceException;
    
    public abstract void handleMinLimitHigherMaxLimitException(model.MinLimitHigherMaxLimitException minLimitHigherMaxLimitException) throws PersistenceException;
    
    public abstract void handleNoRuleDefinitionException(model.NoRuleDefinitionException noRuleDefinitionException) throws PersistenceException;
    
    public abstract void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    
    public abstract void handleExecuteException(model.ExecuteException executeException) throws PersistenceException;
    
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException{
        this.handleExecuteException(invalidBankNumberException);
    }
    public void handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException{
        this.handleExecuteException(noPermissionToExecuteDebitTransferException);
    }
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException{
        this.handleExecuteException(limitViolatedException);
    }
    public void handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException{
        this.handleExecuteException(triggerCyclicException);
    }
    public void handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException{
        this.handleExecuteException(debitNotGrantedException);
    }
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException{
        this.handleExecuteException(invalidAccountNumberException);
    }
    public abstract void handleRuleNotMatchedException(model.RuleNotMatchedException ruleNotMatchedException) throws PersistenceException;
    
    public abstract void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    
    public abstract void handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException;
    
    public abstract void handleNoPermissionToRemoveDebitGrantException(model.NoPermissionToRemoveDebitGrantException noPermissionToRemoveDebitGrantException) throws PersistenceException;
    
    public abstract void handleMaxLimitLowerThenMinLimitException(model.MaxLimitLowerThenMinLimitException maxLimitLowerThenMinLimitException) throws PersistenceException;
    
    public abstract void handleGrantAlreadyGivenException(model.GrantAlreadyGivenException grantAlreadyGivenException) throws PersistenceException;
    
    public abstract void handleCompensationAbortedException(model.CompensationAbortedException compensationAbortedException) throws PersistenceException;
    
    
}
