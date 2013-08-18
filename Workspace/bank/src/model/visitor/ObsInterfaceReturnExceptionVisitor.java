
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsInterfaceReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    public R handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException, E;
    public R handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException, E;
    
}
