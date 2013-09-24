
package model.visitor;

import persistence.*;

public abstract class CompensationStateStandardVisitor implements CompensationStateVisitor {
    
    public void handleWaitingCompensationState(PersistentWaitingCompensationState waitingCompensationState) throws PersistenceException{
        this.standardHandling(waitingCompensationState);
    }
    public void handleDeclinedCompensationState(PersistentDeclinedCompensationState declinedCompensationState) throws PersistenceException{
        this.standardHandling(declinedCompensationState);
    }
    public void handleSuccessfulCompensationState(PersistentSuccessfulCompensationState successfulCompensationState) throws PersistenceException{
        this.standardHandling(successfulCompensationState);
    }
    protected abstract void standardHandling(PersistentCompensationState compensationState) throws PersistenceException;
}
