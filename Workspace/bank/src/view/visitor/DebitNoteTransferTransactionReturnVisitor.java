
package view.visitor;

import view.*;

public interface DebitNoteTransferTransactionReturnVisitor<R> extends DebitNoteTransferReturnVisitor<R> {
    
    public R handleTransaction(TransactionView transaction) throws ModelException;
    
}
