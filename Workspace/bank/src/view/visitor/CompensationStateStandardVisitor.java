
package view.visitor;

import view.*;

public abstract class CompensationStateStandardVisitor implements CompensationStateVisitor {
    
    public void handleWaitingCompensationState(WaitingCompensationStateView waitingCompensationState) throws ModelException{
        this.standardHandling(waitingCompensationState);
    }
    public void handleDeclinedCompensationState(DeclinedCompensationStateView declinedCompensationState) throws ModelException{
        this.standardHandling(declinedCompensationState);
    }
    public void handleSuccessfulCompensationState(SuccessfulCompensationStateView successfulCompensationState) throws ModelException{
        this.standardHandling(successfulCompensationState);
    }
    protected abstract void standardHandling(CompensationStateView compensationState) throws ModelException;
}
