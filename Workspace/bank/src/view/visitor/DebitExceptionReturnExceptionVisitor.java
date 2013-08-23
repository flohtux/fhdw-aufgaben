
package view.visitor;
import view.UserException;
import view.*;

public interface DebitExceptionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException, E;
    public R handleDebitNotGrantedException(DebitNotGrantedException debitNotGrantedException) throws ModelException, E;
    
}
