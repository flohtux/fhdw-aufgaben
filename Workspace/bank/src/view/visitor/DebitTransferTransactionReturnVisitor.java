
package view.visitor;

import view.*;

public interface DebitTransferTransactionReturnVisitor<R> extends DebitTransferReturnVisitor<R> {
    
    public R handleTransaction(TransactionView transaction) throws ModelException;
    
}
