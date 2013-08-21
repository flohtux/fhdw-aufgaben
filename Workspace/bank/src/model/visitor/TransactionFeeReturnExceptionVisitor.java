
package model.visitor;
import model.UserException;
import persistence.*;

public interface TransactionFeeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException, E;
    public R handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException, E;
    public R handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException, E;
    
}
