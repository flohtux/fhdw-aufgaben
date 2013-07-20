
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitNoteTransferReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException, E;
    public R handleTransfer(PersistentTransfer transfer) throws PersistenceException, E;
    
}
