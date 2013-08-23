
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferTransactionReturnExceptionVisitor<R, E extends UserException> extends DebitTransferReturnExceptionVisitor<R, E> {
    
    public R handleTransaction(TransactionView transaction) throws ModelException, E;
    
}
