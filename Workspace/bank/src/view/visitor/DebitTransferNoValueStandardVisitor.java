
package view.visitor;

import view.*;

public abstract class DebitTransferNoValueStandardVisitor implements DebitTransferNoValueVisitor {
    
    public void handleNoDebitTransfer(NoDebitTransferView noDebitTransfer) throws ModelException{
        this.standardHandling(noDebitTransfer);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    public void handleDebit(DebitView debit) throws ModelException{
        this.standardHandling(debit);
    }
    protected abstract void standardHandling(DebitTransferNoValue debitTransferNoValue) throws ModelException;
}
