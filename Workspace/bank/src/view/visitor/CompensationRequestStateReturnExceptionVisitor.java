
package view.visitor;
import view.UserException;
import view.*;

public interface CompensationRequestStateReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAcceptedState(AcceptedStateView acceptedState) throws ModelException, E;
    public R handleWaitingState(WaitingStateView waitingState) throws ModelException, E;
    public R handleDeclinedState(DeclinedStateView declinedState) throws ModelException, E;
    public R handleCompensationRequestState(CompensationRequestStateView compensationRequestState) throws ModelException, E;
    
}
