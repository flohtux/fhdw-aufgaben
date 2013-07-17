
package model.visitor;
import model.UserException;
import persistence.*;

public interface LimitStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMinLimitState(PersistentMinLimitState minLimitState) throws PersistenceException, E;
    public R handleMaxLimitState(PersistentMaxLimitState maxLimitState) throws PersistenceException, E;
    
}
