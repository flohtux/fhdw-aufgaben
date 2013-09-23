
package view.visitor;

import view.*;

public abstract class DebitTransferNoValueDirectVisitor implements DebitTransferNoValueVisitor {
    
    public abstract void handleDebitTransfer(DebitTransferView debitTransfer) throws ModelException;
    
    public void handleDebit(DebitView debit) throws ModelException{
        this.handleDebitTransfer(debit);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.handleDebitTransfer(transfer);
    }
    public abstract void handleNoDebitTransfer(NoDebitTransferView noDebitTransfer) throws ModelException;
    
    
}
