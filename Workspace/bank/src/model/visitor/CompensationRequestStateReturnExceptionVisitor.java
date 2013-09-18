
package model.visitor;
import model.UserException;
import persistence.*;

public interface CompensationRequestStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException, E;
    public R handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException, E;
    public R handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException, E;
    public R handleCompensationRequestState(PersistentCompensationRequestState compensationRequestState) throws PersistenceException, E;
    
}
