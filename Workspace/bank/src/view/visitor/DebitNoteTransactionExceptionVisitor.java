
package view.visitor;
import view.UserException;
import view.*;

public interface DebitNoteTransactionExceptionVisitor<E extends UserException> {
    
    public void handleDebitNote(DebitNoteView debitNote) throws ModelException, E;
    public void handleTrancaction(TrancactionView trancaction) throws ModelException, E;
    
}
