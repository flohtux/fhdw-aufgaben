
package model.visitor;

import persistence.*;

public interface CompensationRequestStateReturnVisitor<R> {
    
    public R handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException;
    public R handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException;
    public R handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException;
    
}
