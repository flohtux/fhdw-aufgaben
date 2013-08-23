
package view.visitor;

import view.*;

public interface DebitExceptionVisitor {
    
    public void handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException;
    public void handleDebitNotGrantedException(DebitNotGrantedException debitNotGrantedException) throws ModelException;
    
}
