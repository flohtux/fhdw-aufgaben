
package view.visitor;
import view.UserException;
import view.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends UserException> extends ExecuteExceptionReturnExceptionVisitor<R, E> {
    
    public R handleDoubleRuleDefinitionException(DoubleRuleDefinitionException doubleRuleDefinitionException) throws ModelException, E;
    public R handleNoAccountsFound(NoAccountsFound noAccountsFound) throws ModelException, E;
    public R handleNoValidFeeValueException(NoValidFeeValueException noValidFeeValueException) throws ModelException, E;
    public R handlePasswordException(PasswordException passwordException) throws ModelException, E;
    public R handleNoValidPercentValueException(NoValidPercentValueException noValidPercentValueException) throws ModelException, E;
    public R handleMinLimitHigherMaxLimitException(MinLimitHigherMaxLimitException minLimitHigherMaxLimitException) throws ModelException, E;
    public R handleNoRuleDefinitionException(NoRuleDefinitionException noRuleDefinitionException) throws ModelException, E;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException, E;
    public R handleRuleNotMatchedException(RuleNotMatchedException ruleNotMatchedException) throws ModelException, E;
    public R handleCycleException(CycleException cycleException) throws ModelException, E;
    public R handleCloseAccountNoPossibleException(CloseAccountNoPossibleException closeAccountNoPossibleException) throws ModelException, E;
    public R handleMaxLimitLowerThenMinLimitException(MaxLimitLowerThenMinLimitException maxLimitLowerThenMinLimitException) throws ModelException, E;
    public R handleGrantAlreadyGivenException(GrantAlreadyGivenException grantAlreadyGivenException) throws ModelException, E;
    
}
