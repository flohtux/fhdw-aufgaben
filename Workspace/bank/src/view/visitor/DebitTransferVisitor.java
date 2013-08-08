
package view.visitor;

import view.*;

public interface DebitTransferVisitor {
    
    public void handleTransfer(TransferView transfer) throws ModelException;
    public void handleDebit(DebitView debit) throws ModelException;
    
}
