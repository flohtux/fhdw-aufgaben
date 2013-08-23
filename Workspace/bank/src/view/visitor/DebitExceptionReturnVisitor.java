
package view.visitor;

import view.*;

public interface DebitExceptionReturnVisitor<R> {
    
    public R handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException;
    public R handleDebitNotGrantedException(DebitNotGrantedException debitNotGrantedException) throws ModelException;
    
}
