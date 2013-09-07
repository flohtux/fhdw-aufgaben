
package model.visitor;
import model.UserException;
import persistence.*;

public interface UserExceptionExceptionVisitor<E extends UserException> extends ExecuteExceptionExceptionVisitor<E>{
    
    public void handleDoubleRuleDefinitionException(model.DoubleRuleDefinitionException doubleRuleDefinitionException) throws PersistenceException, E;
    public void handleNoAccountsFound(model.NoAccountsFound noAccountsFound) throws PersistenceException, E;
    public void handlePasswordException(model.PasswordException passwordException) throws PersistenceException, E;
    public void handleMaximumIsLowerThenMinimumException(model.MaximumIsLowerThenMinimumException maximumIsLowerThenMinimumException) throws PersistenceException, E;
    public void handleNoRuleDefinitionException(model.NoRuleDefinitionException noRuleDefinitionException) throws PersistenceException, E;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public void handleRuleNotMatchedException(model.RuleNotMatchedException ruleNotMatchedException) throws PersistenceException, E;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public void handleCloseAccountNoPossibleException(model.CloseAccountNoPossibleException closeAccountNoPossibleException) throws PersistenceException, E;
    public void handleMinimumIsHigherThenMaximumException(model.MinimumIsHigherThenMaximumException minimumIsHigherThenMaximumException) throws PersistenceException, E;
    public void handleGrantAlreadyGivenException(model.GrantAlreadyGivenException grantAlreadyGivenException) throws PersistenceException, E;
    
}
