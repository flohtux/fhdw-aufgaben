
package model.visitor;
import model.UserException;
import persistence.*;

public interface LimitStateExceptionVisitor<E extends UserException> {
    
    public void handleMinLimitState(PersistentMinLimitState minLimitState) throws PersistenceException, E;
    public void handleMaxLimitState(PersistentMaxLimitState maxLimitState) throws PersistenceException, E;
    
}
