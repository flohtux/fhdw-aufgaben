
package view.visitor;

import view.*;

public abstract class DebitNoteTransferStateStandardVisitor implements DebitNoteTransferStateVisitor {
    
    public void handleNotSuccessfullState(NotSuccessfullStateView notSuccessfullState) throws ModelException{
        this.standardHandling(notSuccessfullState);
    }
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException{
        this.standardHandling(executedState);
    }
    public void handleNotExecutetState(NotExecutetStateView notExecutetState) throws ModelException{
        this.standardHandling(notExecutetState);
    }
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException{
        this.standardHandling(notExecutableState);
    }
    public void handleSuccessfullState(SuccessfullStateView successfullState) throws ModelException{
        this.standardHandling(successfullState);
    }
    public void handleTemplateState(TemplateStateView templateState) throws ModelException{
        this.standardHandling(templateState);
    }
    protected abstract void standardHandling(DebitNoteTransferStateView debitNoteTransferState) throws ModelException;
}
