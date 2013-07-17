
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountLimitStateExceptionVisitor<E extends UserException> extends LimitStateExceptionVisitor<E>{
    
    public void handleNoLimitState(PersistentNoLimitState noLimitState) throws PersistenceException, E;
    
}
