
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountLimitStateReturnExceptionVisitor<R, E extends UserException> extends LimitStateReturnExceptionVisitor<R, E> {
    
    public R handleNoLimitState(PersistentNoLimitState noLimitState) throws PersistenceException, E;
    
}
