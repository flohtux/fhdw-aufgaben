
package model.visitor;
import model.UserException;
import persistence.*;

public interface RuleReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleIncomingAccountRule(PersistentIncomingAccountRule incomingAccountRule) throws PersistenceException, E;
    public R handleSubjectRule(PersistentSubjectRule subjectRule) throws PersistenceException, E;
    public R handleMoneyRule(PersistentMoneyRule moneyRule) throws PersistenceException, E;
    
}
