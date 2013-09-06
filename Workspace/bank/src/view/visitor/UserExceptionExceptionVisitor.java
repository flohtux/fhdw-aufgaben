
package view.visitor;
import view.UserException;
import view.*;

public interface UserExceptionExceptionVisitor<E extends UserException> extends ExecuteExceptionExceptionVisitor<E>{
    
    public void handleDoubleRuleDefinitionException(DoubleRuleDefinitionException doubleRuleDefinitionException) throws ModelException, E;
    public void handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException, E;
    public void handlePasswordException(PasswordException passwordException) throws ModelException, E;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    public void handleRuleNotMatchedException(RuleNotMatchedException ruleNotMatchedException) throws ModelException, E;
    public void handleCycleException(CycleException cycleException) throws ModelException, E;
    public void handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException, E;
    public void handleGrantAlreadyGivenException(GrantAlreadyGivenException grantAlreadyGivenException) throws ModelException, E;
    
}
