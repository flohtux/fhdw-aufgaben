
package view.visitor;
import view.UserException;
import view.*;

public interface CompensationStateExceptionVisitor<E extends UserException> {
    
    public void handleWaitingCompensationState(WaitingCompensationStateView waitingCompensationState) throws ModelException, E;
    public void handleSuccessfulCompensationState(SuccessfulCompensationStateView successfulCompensationState) throws ModelException, E;
    public void handleDeclinedCompensationState(DeclinedCompensationStateView declinedCompensationState) throws ModelException, E;
    
}
