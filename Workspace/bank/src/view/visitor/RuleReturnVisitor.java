
package view.visitor;

import view.*;

public interface RuleReturnVisitor<R> {
    
    public R handleIncomingAccountRule(IncomingAccountRuleView incomingAccountRule) throws ModelException;
    public R handleSubjectRule(SubjectRuleView subjectRule) throws ModelException;
    public R handleMoneyRule(MoneyRuleView moneyRule) throws ModelException;
    
}
