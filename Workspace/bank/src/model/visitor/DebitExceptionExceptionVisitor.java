
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitExceptionExceptionVisitor<E extends UserException> {
    
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException, E;
    public void handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException, E;
    
}
