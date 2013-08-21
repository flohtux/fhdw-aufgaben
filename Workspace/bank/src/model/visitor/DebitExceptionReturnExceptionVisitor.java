
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitExceptionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException, E;
    public R handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException, E;
    
}
