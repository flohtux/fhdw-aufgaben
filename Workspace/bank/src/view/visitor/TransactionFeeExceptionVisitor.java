
package view.visitor;
import view.UserException;
import view.*;

public interface TransactionFeeExceptionVisitor<E extends UserException> {
    
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException, E;
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException, E;
    public void handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException, E;
    
}
