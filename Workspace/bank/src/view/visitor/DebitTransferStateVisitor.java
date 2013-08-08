
package view.visitor;

import view.*;

public interface DebitTransferStateVisitor {
    
    public void handleTemplateState(TemplateStateView templateState) throws ModelException;
    public void handleNotExecutetState(NotExecutetStateView notExecutetState) throws ModelException;
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException;
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException;
    public void handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException;
    public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException;
    
}
