
package model.visitor;
import model.UserException;
import persistence.*;

public interface CompensationStateExceptionVisitor<E extends UserException> {
    
    public void handleWaitingCompensationState(PersistentWaitingCompensationState waitingCompensationState) throws PersistenceException, E;
    public void handleSuccessfulCompensationState(PersistentSuccessfulCompensationState successfulCompensationState) throws PersistenceException, E;
    public void handleDeclinedCompensationState(PersistentDeclinedCompensationState declinedCompensationState) throws PersistenceException, E;
    
}
