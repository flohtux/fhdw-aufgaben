
package view.visitor;
import view.UserException;
import view.*;

public interface DebitTransferNoValueExceptionVisitor<E extends UserException> extends DebitTransferExceptionVisitor<E>{
    
    public void handleNoDebitTransfer(NoDebitTransferView noDebitTransfer) throws ModelException, E;
    
}
