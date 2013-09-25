
package model.visitor;
import model.UserException;
import persistence.*;

public interface CompensationStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleWaitingCompensationState(PersistentWaitingCompensationState waitingCompensationState) throws PersistenceException, E;
    public R handleSuccessfulCompensationState(PersistentSuccessfulCompensationState successfulCompensationState) throws PersistenceException, E;
    public R handleDeclinedCompensationState(PersistentDeclinedCompensationState declinedCompensationState) throws PersistenceException, E;
    
}
