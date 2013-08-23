
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferTransactionExceptionVisitor<E extends UserException> extends DebitTransferExceptionVisitor<E>{
    
    public void handleTransaction(TransactionView transaction) throws ModelException, E;
    
}
