
package view.visitor;

import view.*;

public interface DebitNoteTransferStateVisitor {
    
    public void handleTemplateState(TemplateStateView templateState) throws ModelException;
    public void handleNotExecutetState(NotExecutetStateView notExecutetState) throws ModelException;
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException;
    public void handleNotSuccessfullState(NotSuccessfullStateView notSuccessfullState) throws ModelException;
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException;
    public void handleSuccessfullState(SuccessfullStateView successfullState) throws ModelException;
    
}
