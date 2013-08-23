
package view.visitor;

import view.*;

public interface DebitTransferReturnVisitor<R> {
    
    public R handleTransfer(TransferView transfer) throws ModelException;
    public R handleDebit(DebitView debit) throws ModelException;
    
}
