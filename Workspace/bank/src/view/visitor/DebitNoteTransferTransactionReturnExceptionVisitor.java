
package view.visitor;
import view.UserException;
import view.*;

public interface DebitNoteTransferTransactionReturnExceptionVisitor<R, E extends UserException> extends DebitNoteTransferReturnExceptionVisitor<R, E> {
    
    public R handleTransaction(TransactionView transaction) throws ModelException, E;
    
}
