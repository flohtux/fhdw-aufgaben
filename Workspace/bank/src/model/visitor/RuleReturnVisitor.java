
package model.visitor;

import persistence.*;

public interface RuleReturnVisitor<R> {
    
    public R handleIncomingAccountRule(PersistentIncomingAccountRule incomingAccountRule) throws PersistenceException;
    public R handleSubjectRule(PersistentSubjectRule subjectRule) throws PersistenceException;
    public R handleMoneyRule(PersistentMoneyRule moneyRule) throws PersistenceException;
    
}
