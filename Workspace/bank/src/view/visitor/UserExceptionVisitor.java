
package view.visitor;

import view.*;

public interface UserExceptionVisitor extends ExecuteExceptionVisitor{
    
    public void handleDoubleRuleDefinitionException(DoubleRuleDefinitionException doubleRuleDefinitionException) throws ModelException;
    public void handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException;
    public void handleNoValidFeeValueException(NoValidFeeValueException noValidFeeValueException) throws ModelException;
    public void handlePasswordException(PasswordException passwordException) throws ModelException;
    public void handleNoValidPercentValueException(NoValidPercentValueException noValidPercentValueException) throws ModelException;
    public void handleMinLimitHigherMaxLimitException(MinLimitHigherMaxLimitException minLimitHigherMaxLimitException) throws ModelException;
    public void handleNoRuleDefinitionException(NoRuleDefinitionException noRuleDefinitionException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public void handleRuleNotMatchedException(RuleNotMatchedException ruleNotMatchedException) throws ModelException;
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException;
    public void handleMaxLimitLowerThenMinLimitException(MaxLimitLowerThenMinLimitException maxLimitLowerThenMinLimitException) throws ModelException;
    public void handleGrantAlreadyGivenException(GrantAlreadyGivenException grantAlreadyGivenException) throws ModelException;
    
}
