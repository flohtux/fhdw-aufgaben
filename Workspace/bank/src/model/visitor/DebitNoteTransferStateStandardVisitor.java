
package model.visitor;

import persistence.*;

public abstract class DebitNoteTransferStateStandardVisitor implements DebitNoteTransferStateVisitor {
    
    public void handleNotSuccessfullState(PersistentNotSuccessfullState notSuccessfullState) throws PersistenceException{
        this.standardHandling(notSuccessfullState);
    }
    public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException{
        this.standardHandling(executedState);
    }
    public void handleNotExecutetState(PersistentNotExecutetState notExecutetState) throws PersistenceException{
        this.standardHandling(notExecutetState);
    }
    public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException{
        this.standardHandling(notExecutableState);
    }
    public void handleSuccessfullState(PersistentSuccessfullState successfullState) throws PersistenceException{
        this.standardHandling(successfullState);
    }
    public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException{
        this.standardHandling(templateState);
    }
    protected abstract void standardHandling(PersistentDebitNoteTransferState debitNoteTransferState) throws PersistenceException;
}
