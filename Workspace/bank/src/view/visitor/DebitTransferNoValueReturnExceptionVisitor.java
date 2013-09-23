
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferNoValueReturnExceptionVisitor<R, E extends UserException> extends DebitTransferReturnExceptionVisitor<R, E> {
    
    public R handleNoDebitTransfer(NoDebitTransferView noDebitTransfer) throws ModelException, E;
    
}
