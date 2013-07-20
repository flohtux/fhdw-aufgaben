
package view.visitor;

import view.*;

public interface DebitNoteTransferStateReturnVisitor<R> {
    
    public R handleTemplateState(TemplateStateView templateState) throws ModelException;
    public R handleNotExecutetState(NotExecutetStateView notExecutetState) throws ModelException;
    public R handleExecutedState(ExecutedStateView executedState) throws ModelException;
    public R handleNotSuccessfullState(NotSuccessfullStateView notSuccessfullState) throws ModelException;
    public R handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException;
    public R handleSuccessfullState(SuccessfullStateView successfullState) throws ModelException;
    
}
