
package model.visitor;

import persistence.*;

public abstract class RuleStandardVisitor implements RuleVisitor {
    
    public void handleSubjectRule(PersistentSubjectRule subjectRule) throws PersistenceException{
        this.standardHandling(subjectRule);
    }
    public void handleMoneyRule(PersistentMoneyRule moneyRule) throws PersistenceException{
        this.standardHandling(moneyRule);
    }
    public void handleIncomingAccountRule(PersistentIncomingAccountRule incomingAccountRule) throws PersistenceException{
        this.standardHandling(incomingAccountRule);
    }
    protected abstract void standardHandling(PersistentRule rule) throws PersistenceException;
}
