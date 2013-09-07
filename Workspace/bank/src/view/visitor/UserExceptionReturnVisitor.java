
package view.visitor;

import view.*;

public interface UserExceptionReturnVisitor<R> extends ExecuteExceptionReturnVisitor<R> {
    
    public R handleDoubleRuleDefinitionException(DoubleRuleDefinitionException doubleRuleDefinitionException) throws ModelException;
    public R handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException;
    public R handlePasswordException(PasswordException passwordException) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public R handleRuleNotMatchedException(RuleNotMatchedException ruleNotMatchedException) throws ModelException;
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException;
    public R handleGrantAlreadyGivenException(GrantAlreadyGivenException grantAlreadyGivenException) throws ModelException;
    
}
