
package view.visitor;

import view.*;

public interface CompensationRequestStateReturnVisitor<R> {
    
    public R handleAcceptedState(AcceptedStateView acceptedState) throws ModelException;
    public R handleWaitingState(WaitingStateView waitingState) throws ModelException;
    public R handleDeclinedState(DeclinedStateView declinedState) throws ModelException;
    
}
