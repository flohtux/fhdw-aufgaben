
package view.visitor;
import view.UserException;
import view.*;

public interface RuleExceptionVisitor<E extends UserException> {
    
    public void handleIncomingAccountRule(IncomingAccountRuleView incomingAccountRule) throws ModelException, E;
    public void handleSubjectRule(SubjectRuleView subjectRule) throws ModelException, E;
    public void handleMoneyRule(MoneyRuleView moneyRule) throws ModelException, E;
    
}
