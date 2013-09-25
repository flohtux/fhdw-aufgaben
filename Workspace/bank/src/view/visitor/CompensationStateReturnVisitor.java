
package view.visitor;

import view.*;

public interface CompensationStateReturnVisitor<R> {
    
    public R handleWaitingCompensationState(WaitingCompensationStateView waitingCompensationState) throws ModelException;
    public R handleSuccessfulCompensationState(SuccessfulCompensationStateView successfulCompensationState) throws ModelException;
    public R handleDeclinedCompensationState(DeclinedCompensationStateView declinedCompensationState) throws ModelException;
    
}
