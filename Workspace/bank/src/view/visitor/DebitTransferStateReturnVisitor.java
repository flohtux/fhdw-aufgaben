
package view.visitor;

import view.*;

public interface DebitTransferStateReturnVisitor<R> {
    
    public R handleTemplateState(TemplateStateView templateState) throws ModelException;
    public R handleNotExecutetState(NotExecutetStateView notExecutetState) throws ModelException;
    public R handleExecutedState(ExecutedStateView executedState) throws ModelException;
    public R handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException;
    public R handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException;
    public R handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException;
    
}
