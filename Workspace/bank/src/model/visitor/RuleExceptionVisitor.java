
package model.visitor;
import model.UserException;
import persistence.*;

public interface RuleExceptionVisitor<E extends UserException> {
    
    public void handleIncomingAccountRule(PersistentIncomingAccountRule incomingAccountRule) throws PersistenceException, E;
    public void handleSubjectRule(PersistentSubjectRule subjectRule) throws PersistenceException, E;
    public void handleMoneyRule(PersistentMoneyRule moneyRule) throws PersistenceException, E;
    
}
