
package model.visitor;

import persistence.*;

public abstract class CompensationRequestStateStandardVisitor implements CompensationRequestStateVisitor {
    
    public void handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException{
        this.standardHandling(waitingState);
    }
    public void handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException{
        this.standardHandling(declinedState);
    }
    public void handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException{
        this.standardHandling(acceptedState);
    }
    protected abstract void standardHandling(PersistentCompensationRequestState compensationRequestState) throws PersistenceException;
}
