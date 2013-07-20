
package view.visitor;

import view.*;

public interface DebitNoteTransferTransactionVisitor extends DebitNoteTransferVisitor{
    
    public void handleTransaction(TransactionView transaction) throws ModelException;
    
}
