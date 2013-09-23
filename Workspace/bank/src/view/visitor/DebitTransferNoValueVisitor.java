
package view.visitor;

import view.*;

public interface DebitTransferNoValueVisitor extends DebitTransferVisitor{
    
    public void handleNoDebitTransfer(NoDebitTransferView noDebitTransfer) throws ModelException;
    
}
