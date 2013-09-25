
package view.visitor;

import view.*;

public interface DebitTransferStateReturnVisitor<R> {
    
    public R handleExecutedState(ExecutedStateView executedState) throws ModelException;
    public R handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException;
    public R handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException;
    public R handleCompensationRequestedState(CompensationRequestedStateView compensationRequestedState) throws ModelException;
    public R handleCompensatedState(CompensatedStateView compensatedState) throws ModelException;
    public R handleNotExecutedState(NotExecutedStateView notExecutedState) throws ModelException;
    public R handleTemplateState(TemplateStateView templateState) throws ModelException;
    public R handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException;
    
}
