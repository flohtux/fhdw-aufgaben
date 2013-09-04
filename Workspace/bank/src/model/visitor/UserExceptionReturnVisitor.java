
package model.visitor;

import persistence.*;

public interface UserExceptionReturnVisitor<R> extends ExecuteExceptionReturnVisitor<R> {
    
    public R handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException;
    public R handlePasswordException(model.PasswordException passwordException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleRuleNotMatchedException(model.RuleNotMatchedException ruleNotMatchedException) throws PersistenceException;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException;
    public R handleGrantAlreadyGivenException(model.GrantAlreadyGivenException grantAlreadyGivenException) throws PersistenceException;
    
}
