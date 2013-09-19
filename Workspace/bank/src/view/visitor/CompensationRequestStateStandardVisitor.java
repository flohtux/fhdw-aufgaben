
package view.visitor;

import view.*;

public abstract class CompensationRequestStateStandardVisitor implements CompensationRequestStateVisitor {
    
    public void handleWaitingState(WaitingStateView waitingState) throws ModelException{
        this.standardHandling(waitingState);
    }
    public void handleDeclinedState(DeclinedStateView declinedState) throws ModelException{
        this.standardHandling(declinedState);
    }
    public void handleAcceptedState(AcceptedStateView acceptedState) throws ModelException{
        this.standardHandling(acceptedState);
    }
    protected abstract void standardHandling(CompensationRequestStateView compensationRequestState) throws ModelException;
}
