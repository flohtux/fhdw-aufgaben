
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsInterfaceReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAccountServiceSuccessfullStates(PersistentAccountServiceSuccessfullStates accountServiceSuccessfullStates) throws PersistenceException, E;
    public R handleAccountServiceNotSuccessfullStates(PersistentAccountServiceNotSuccessfullStates accountServiceNotSuccessfullStates) throws PersistenceException, E;
    public R handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    public R handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException, E;
    public R handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException, E;
    
}
