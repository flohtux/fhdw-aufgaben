
package view.visitor;

import view.*;

public interface DebitTransferStateVisitor {
    
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException;
    public void handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException;
    public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException;
    public void handleCompensationRequestedState(CompensationRequestedStateView compensationRequestedState) throws ModelException;
    public void handleCompensatedState(CompensatedStateView compensatedState) throws ModelException;
    public void handleNotExecutedState(NotExecutedStateView notExecutedState) throws ModelException;
    public void handleTemplateState(TemplateStateView templateState) throws ModelException;
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException;
    
}
