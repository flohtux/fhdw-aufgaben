
package view.visitor;

import view.*;

public abstract class RuleStandardVisitor implements RuleVisitor {
    
    public void handleSubjectRule(SubjectRuleView subjectRule) throws ModelException{
        this.standardHandling(subjectRule);
    }
    public void handleMoneyRule(MoneyRuleView moneyRule) throws ModelException{
        this.standardHandling(moneyRule);
    }
    public void handleIncomingAccountRule(IncomingAccountRuleView incomingAccountRule) throws ModelException{
        this.standardHandling(incomingAccountRule);
    }
    protected abstract void standardHandling(RuleView rule) throws ModelException;
}
