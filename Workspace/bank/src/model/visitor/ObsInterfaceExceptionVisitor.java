
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsInterfaceExceptionVisitor<E extends UserException> {
    
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    public void handleAccountServiceSuccessful(PersistentAccountServiceSuccessful accountServiceSuccessful) throws PersistenceException, E;
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException, E;
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException, E;
    public void handleAccountServiceNotExecuted(PersistentAccountServiceNotExecuted accountServiceNotExecuted) throws PersistenceException, E;
    
}
