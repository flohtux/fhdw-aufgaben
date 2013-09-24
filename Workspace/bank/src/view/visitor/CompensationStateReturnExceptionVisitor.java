
package view.visitor;
import view.UserException;
import view.*;

public interface CompensationStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleWaitingCompensationState(WaitingCompensationStateView waitingCompensationState) throws ModelException, E;
    public R handleSuccessfulCompensationState(SuccessfulCompensationStateView successfulCompensationState) throws ModelException, E;
    public R handleDeclinedCompensationState(DeclinedCompensationStateView declinedCompensationState) throws ModelException, E;
    
}
