
package view.visitor;
import view.UserException;
import view.*;

public interface DebitExceptionExceptionVisitor<E extends UserException> {
    
    public void handleLimitViolatedException(LimitViolatedException limitViolatedException) throws ModelException, E;
    public void handleDebitNotGrantedException(DebitNotGrantedException debitNotGrantedException) throws ModelException, E;
    
}
