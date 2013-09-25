
package model.visitor;

import persistence.*;

public interface CompensationStateVisitor {
    
    public void handleWaitingCompensationState(PersistentWaitingCompensationState waitingCompensationState) throws PersistenceException;
    public void handleSuccessfulCompensationState(PersistentSuccessfulCompensationState successfulCompensationState) throws PersistenceException;
    public void handleDeclinedCompensationState(PersistentDeclinedCompensationState declinedCompensationState) throws PersistenceException;
    
}
