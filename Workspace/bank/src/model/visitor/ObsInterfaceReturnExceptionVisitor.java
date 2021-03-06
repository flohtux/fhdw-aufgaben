
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsInterfaceReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAccountReceivedDebitGrant(PersistentAccountReceivedDebitGrant accountReceivedDebitGrant) throws PersistenceException, E;
    public R handleAccountServiceSuccessful(PersistentAccountServiceSuccessful accountServiceSuccessful) throws PersistenceException, E;
    public R handleAccountAllCompensation(PersistentAccountAllCompensation accountAllCompensation) throws PersistenceException, E;
    public R handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException, E;
    public R handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException, E;
    public R handleAllCompensationListeOutgoingCompensations(PersistentAllCompensationListeOutgoingCompensations allCompensationListeOutgoingCompensations) throws PersistenceException, E;
    public R handleAccountServiceNotExecuted(PersistentAccountServiceNotExecuted accountServiceNotExecuted) throws PersistenceException, E;
    public R handleAccountGrantedDebitGrant(PersistentAccountGrantedDebitGrant accountGrantedDebitGrant) throws PersistenceException, E;
    public R handleAccountServiceTemplate(PersistentAccountServiceTemplate accountServiceTemplate) throws PersistenceException, E;
    public R handleCompensationPendingRequests(PersistentCompensationPendingRequests compensationPendingRequests) throws PersistenceException, E;
    public R handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    public R handleAccountTriggerListe(PersistentAccountTriggerListe accountTriggerListe) throws PersistenceException, E;
    public R handleAllCompensationListePendingCompensationRequests(PersistentAllCompensationListePendingCompensationRequests allCompensationListePendingCompensationRequests) throws PersistenceException, E;
    public R handleAccountServiceBankFees(PersistentAccountServiceBankFees accountServiceBankFees) throws PersistenceException, E;
    
}
