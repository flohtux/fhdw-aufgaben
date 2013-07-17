
package model.visitor;
import model.UserException;
import persistence.*;

public interface DebitNoteTransactionReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleDebitNote(PersistentDebitNote debitNote) throws PersistenceException, E;
    public R handleTrancaction(PersistentTrancaction trancaction) throws PersistenceException, E;
    
}
