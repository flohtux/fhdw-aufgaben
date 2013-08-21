
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsInterfaceExceptionVisitor<E extends UserException> {
    
    public void handleAccountServiceSuccessfullStates(PersistentAccountServiceSuccessfullStates accountServiceSuccessfullStates) throws PersistenceException, E;
    public void handleAccountServiceNotSuccessfullStates(PersistentAccountServiceNotSuccessfullStates accountServiceNotSuccessfullStates) throws PersistenceException, E;
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException, E;
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException, E;
    
}
