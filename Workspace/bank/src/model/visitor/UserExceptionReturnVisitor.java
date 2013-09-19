
package model.visitor;

import persistence.*;

public interface UserExceptionReturnVisitor<R> extends ExecuteExceptionReturnVisitor<R> {
    
    public R handleDoubleRuleDefinitionException(model.DoubleRuleDefinitionException doubleRuleDefinitionException) throws PersistenceException;
    public R handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException;
    public R handleNoValidFeeValueException(model.NoValidFeeValueException noValidFeeValueException) throws PersistenceException;
    public R handlePasswordException(model.PasswordException passwordException) throws PersistenceException;
    public R handleNoValidPercentValueException(model.NoValidPercentValueException noValidPercentValueException) throws PersistenceException;
    public R handleMinLimitHigherMaxLimitException(model.MinLimitHigherMaxLimitException minLimitHigherMaxLimitException) throws PersistenceException;
    public R handleNoRuleDefinitionException(model.NoRuleDefinitionException noRuleDefinitionException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleRuleNotMatchedException(model.RuleNotMatchedException ruleNotMatchedException) throws PersistenceException;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException;
    public R handleMaxLimitLowerThenMinLimitException(model.MaxLimitLowerThenMinLimitException maxLimitLowerThenMinLimitException) throws PersistenceException;
    public R handleCompensationAbortedException(model.CompensationAbortedException compensationAbortedException) throws PersistenceException;
    public R handleGrantAlreadyGivenException(model.GrantAlreadyGivenException grantAlreadyGivenException) throws PersistenceException;
    
}
