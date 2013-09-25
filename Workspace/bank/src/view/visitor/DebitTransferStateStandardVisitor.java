
package view.visitor;

import view.*;

public abstract class DebitTransferStateStandardVisitor implements DebitTransferStateVisitor {
    
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException{
        this.standardHandling(executedState);
    }
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException{
        this.standardHandling(notExecutableState);
    }
    public void handleCompensatedState(CompensatedStateView compensatedState) throws ModelException{
        this.standardHandling(compensatedState);
    }
    public void handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException{
        this.standardHandling(notSuccessfulState);
    }
    public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException{
        this.standardHandling(successfulState);
    }
    public void handleNotExecutedState(NotExecutedStateView notExecutedState) throws ModelException{
        this.standardHandling(notExecutedState);
    }
    public void handleTemplateState(TemplateStateView templateState) throws ModelException{
        this.standardHandling(templateState);
    }
    protected abstract void standardHandling(DebitTransferStateView debitTransferState) throws ModelException;
}
