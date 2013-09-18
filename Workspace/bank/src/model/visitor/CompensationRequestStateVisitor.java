
package model.visitor;

import persistence.*;

public interface CompensationRequestStateVisitor {
    
    public void handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException;
    public void handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException;
    public void handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException;
    public void handleCompensationRequestState(PersistentCompensationRequestState compensationRequestState) throws PersistenceException;
    
}
