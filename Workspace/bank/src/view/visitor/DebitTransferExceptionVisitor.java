
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferExceptionVisitor<E extends UserException> {
    
    public void handleTransfer(TransferView transfer) throws ModelException, E;
    public void handleDebit(DebitView debit) throws ModelException, E;
    
}
