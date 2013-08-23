
package view.visitor;

import view.*;

public abstract class DebitTransferStateStandardVisitor implements DebitTransferStateVisitor {
    
    public void handleNotExecutetState(NotExecutetStateView notExecutetState) throws ModelException{
        this.standardHandling(notExecutetState);
    }
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException{
        this.standardHandling(executedState);
    }
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException{
        this.standardHandling(notExecutableState);
    }
    public void handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException{
        this.standardHandling(notSuccessfulState);
    }
    public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException{
        this.standardHandling(successfulState);
    }
    public void handleTemplateState(TemplateStateView templateState) throws ModelException{
        this.standardHandling(templateState);
    }
    protected abstract void standardHandling(DebitTransferStateView debitTransferState) throws ModelException;
}
