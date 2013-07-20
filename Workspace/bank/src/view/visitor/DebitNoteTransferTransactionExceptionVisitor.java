
package view.visitor;
import view.UserException;
import view.*;

public interface DebitNoteTransferTransactionExceptionVisitor<E extends UserException> extends DebitNoteTransferExceptionVisitor<E>{
    
    public void handleTransaction(TransactionView transaction) throws ModelException, E;
    
}
