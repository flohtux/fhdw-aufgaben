
package view.visitor;
import view.UserException;
import view.*;

public interface RuleReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleIncomingAccountRule(IncomingAccountRuleView incomingAccountRule) throws ModelException, E;
    public R handleSubjectRule(SubjectRuleView subjectRule) throws ModelException, E;
    public R handleMoneyRule(MoneyRuleView moneyRule) throws ModelException, E;
    
}
