
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleTransfer(TransferView transfer) throws ModelException, E;
    public R handleDebit(DebitView debit) throws ModelException, E;
    
}
