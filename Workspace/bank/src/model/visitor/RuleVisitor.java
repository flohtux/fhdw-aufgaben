
package model.visitor;

import persistence.*;

public interface RuleVisitor {
    
    public void handleIncomingAccountRule(PersistentIncomingAccountRule incomingAccountRule) throws PersistenceException;
    public void handleSubjectRule(PersistentSubjectRule subjectRule) throws PersistenceException;
    public void handleMoneyRule(PersistentMoneyRule moneyRule) throws PersistenceException;
    
}
