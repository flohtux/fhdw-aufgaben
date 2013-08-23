
package view.visitor;

import view.*;

public interface DebitTransferTransactionVisitor extends DebitTransferVisitor{
    
    public void handleTransaction(TransactionView transaction) throws ModelException;
    
}
