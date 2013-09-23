
package view.visitor;

import view.*;

public interface DebitTransferNoValueReturnVisitor<R> extends DebitTransferReturnVisitor<R> {
    
    public R handleNoDebitTransfer(NoDebitTransferView noDebitTransfer) throws ModelException;
    
}
