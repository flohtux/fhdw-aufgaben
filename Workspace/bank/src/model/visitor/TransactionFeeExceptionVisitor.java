
package model.visitor;
import model.UserException;
import persistence.*;

public interface TransactionFeeExceptionVisitor<E extends UserException> {
    
    public void handleMixedFee(PersistentMixedFee mixedFee) throws PersistenceException, E;
    public void handleFixTransactionFee(PersistentFixTransactionFee fixTransactionFee) throws PersistenceException, E;
    public void handleProcentualFee(PersistentProcentualFee procentualFee) throws PersistenceException, E;
    
}
