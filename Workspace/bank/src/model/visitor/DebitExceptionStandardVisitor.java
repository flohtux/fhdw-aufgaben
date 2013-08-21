
package model.visitor;

import persistence.*;

public abstract class DebitExceptionStandardVisitor implements DebitExceptionVisitor {
    
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException{
        this.standardHandling(limitViolatedException);
    }
    public void handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException{
        this.standardHandling(debitNotGrantedException);
    }
    protected abstract void standardHandling(model.DebitException debitException) throws PersistenceException;
}
