
package view.visitor;

import view.*;

public interface CompensationRequestStateVisitor {
    
    public void handleAcceptedState(AcceptedStateView acceptedState) throws ModelException;
    public void handleWaitingState(WaitingStateView waitingState) throws ModelException;
    public void handleDeclinedState(DeclinedStateView declinedState) throws ModelException;
    
}
