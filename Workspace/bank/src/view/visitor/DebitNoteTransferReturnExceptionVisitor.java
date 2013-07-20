
package view.visitor;
import view.UserException;
import view.*;

public interface DebitNoteTransferReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleDebitNote(DebitNoteView debitNote) throws ModelException, E;
    public R handleTransfer(TransferView transfer) throws ModelException, E;
    
}
