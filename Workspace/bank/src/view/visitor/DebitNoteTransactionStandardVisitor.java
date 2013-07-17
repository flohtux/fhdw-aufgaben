
package view.visitor;

import view.*;

public abstract class DebitNoteTransactionStandardVisitor implements DebitNoteTransactionVisitor {
    
    public void handleTrancaction(TrancactionView trancaction) throws ModelException{
        this.standardHandling(trancaction);
    }
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException{
        this.standardHandling(debitNote);
    }
    protected abstract void standardHandling(DebitNoteTransactionView debitNoteTransaction) throws ModelException;
}
