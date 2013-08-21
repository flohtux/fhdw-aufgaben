
package view.visitor;

import view.*;

public abstract class DebitExceptionStandardVisitor implements DebitExceptionVisitor {
    
    public void handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException{
        this.standardHandling(limitViolatedException);
    }
    public void handleDebitNotGrantedException(DebitNotGrantedException debitNotGrantedException) throws ModelException{
        this.standardHandling(debitNotGrantedException);
    }
    protected abstract void standardHandling(DebitException debitException) throws ModelException;
}
