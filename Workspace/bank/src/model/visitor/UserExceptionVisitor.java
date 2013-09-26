
package model.visitor;

import persistence.*;

public interface UserExceptionVisitor extends ExecuteExceptionVisitor{
    
    public void handleDoubleRuleDefinitionException(model.DoubleRuleDefinitionException doubleRuleDefinitionException) throws PersistenceException;
    public void handlePasswordException(model.PasswordException passwordException) throws PersistenceException;
    public void handleNoValidFeeValueException(model.NoValidFeeValueException noValidFeeValueException) throws PersistenceException;
    public void handleNoValidPercentValueException(model.NoValidPercentValueException noValidPercentValueException) throws PersistenceException;
    public void handleRuleNotMatchedException(model.RuleNotMatchedException ruleNotMatchedException) throws PersistenceException;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException;
    public void handleMaxLimitLowerThenMinLimitException(model.MaxLimitLowerThenMinLimitException maxLimitLowerThenMinLimitException) throws PersistenceException;
    public void handleCompensationAbortedException(model.CompensationAbortedException compensationAbortedException) throws PersistenceException;
    public void handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException;
    public void handleNoRuleDefinitionException(model.NoRuleDefinitionException noRuleDefinitionException) throws PersistenceException;
    public void handleMinLimitHigherMaxLimitException(model.MinLimitHigherMaxLimitException minLimitHigherMaxLimitException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public void handleNoPermissionToRemoveDebitGrantException(model.NoPermissionToRemoveDebitGrantException noPermissionToRemoveDebitGrantException) throws PersistenceException;
    public void handleGrantAlreadyGivenException(model.GrantAlreadyGivenException grantAlreadyGivenException) throws PersistenceException;
    
}
