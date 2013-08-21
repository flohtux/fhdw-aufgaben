
package model.visitor;

import persistence.*;

public interface DebitExceptionReturnVisitor<R> {
    
    public R handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException;
    public R handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException;
    
}
