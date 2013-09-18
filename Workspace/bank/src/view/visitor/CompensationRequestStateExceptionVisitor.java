
package view.visitor;
import view.UserException;
import view.*;

public interface CompensationRequestStateExceptionVisitor<E extends UserException> {
    
    public void handleAcceptedState(AcceptedStateView acceptedState) throws ModelException, E;
    public void handleWaitingState(WaitingStateView waitingState) throws ModelException, E;
    public void handleDeclinedState(DeclinedStateView declinedState) throws ModelException, E;
    public void handleCompensationRequestState(CompensationRequestStateView compensationRequestState) throws ModelException, E;
    
}
