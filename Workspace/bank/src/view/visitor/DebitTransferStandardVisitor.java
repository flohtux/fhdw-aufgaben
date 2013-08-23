
package view.visitor;

import view.*;

public abstract class DebitTransferStandardVisitor implements DebitTransferVisitor {
    
    public void handleDebit(DebitView debit) throws ModelException{
        this.standardHandling(debit);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    protected abstract void standardHandling(DebitTransferView debitTransfer) throws ModelException;
}
