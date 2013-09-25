
package model.visitor;

import persistence.*;

public interface CompensationStateReturnVisitor<R> {
    
    public R handleWaitingCompensationState(PersistentWaitingCompensationState waitingCompensationState) throws PersistenceException;
    public R handleSuccessfulCompensationState(PersistentSuccessfulCompensationState successfulCompensationState) throws PersistenceException;
    public R handleDeclinedCompensationState(PersistentDeclinedCompensationState declinedCompensationState) throws PersistenceException;
    
}
