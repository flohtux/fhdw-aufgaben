
package view.visitor;

import view.*;

public interface DebitNoteTransactionReturnVisitor<R> {
    
    public R handleDebitNote(DebitNoteView debitNote) throws ModelException;
    public R handleTrancaction(TrancactionView trancaction) throws ModelException;
    
}
