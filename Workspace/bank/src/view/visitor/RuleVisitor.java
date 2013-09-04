
package view.visitor;

import view.*;

public interface RuleVisitor {
    
    public void handleIncomingAccountRule(IncomingAccountRuleView incomingAccountRule) throws ModelException;
    public void handleSubjectRule(SubjectRuleView subjectRule) throws ModelException;
    public void handleMoneyRule(MoneyRuleView moneyRule) throws ModelException;
    
}
