
package view.visitor;

import view.*;

public interface DebitNoteTransactionVisitor {
    
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException;
    public void handleTrancaction(TrancactionView trancaction) throws ModelException;
    
}
