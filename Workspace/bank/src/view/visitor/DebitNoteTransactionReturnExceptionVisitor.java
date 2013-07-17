
package view.visitor;
import view.UserException;
import view.*;

public interface DebitNoteTransactionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleDebitNote(DebitNoteView debitNote) throws ModelException, E;
    public R handleTrancaction(TrancactionView trancaction) throws ModelException, E;
    
}
