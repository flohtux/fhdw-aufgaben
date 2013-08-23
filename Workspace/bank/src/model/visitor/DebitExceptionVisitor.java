
package model.visitor;

import persistence.*;

public interface DebitExceptionVisitor {
    
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException;
    public void handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException;
    
}
