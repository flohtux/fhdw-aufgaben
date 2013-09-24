
package view.visitor;

import view.*;

public interface CompensationStateVisitor {
    
    public void handleWaitingCompensationState(WaitingCompensationStateView waitingCompensationState) throws ModelException;
    public void handleSuccessfulCompensationState(SuccessfulCompensationStateView successfulCompensationState) throws ModelException;
    public void handleDeclinedCompensationState(DeclinedCompensationStateView declinedCompensationState) throws ModelException;
    
}
