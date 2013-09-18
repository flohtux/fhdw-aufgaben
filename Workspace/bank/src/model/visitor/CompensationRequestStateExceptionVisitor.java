
package model.visitor;
import model.UserException;
import persistence.*;

public interface CompensationRequestStateExceptionVisitor<E extends UserException> {
    
    public void handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException, E;
    public void handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException, E;
    public void handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException, E;
    public void handleCompensationRequestState(PersistentCompensationRequestState compensationRequestState) throws PersistenceException, E;
    
}
