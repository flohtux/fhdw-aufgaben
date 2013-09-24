
package model.visitor;
import model.UserException;
import persistence.*;

public interface ObsInterfaceExceptionVisitor<E extends UserException> {
    
    public void handleAccountReceivedDebitGrant(PersistentAccountReceivedDebitGrant accountReceivedDebitGrant) throws PersistenceException, E;
    public void handleAccountGrantedDebitGrant(PersistentAccountGrantedDebitGrant accountGrantedDebitGrant) throws PersistenceException, E;
    public void handleAccountServiceTemplate(PersistentAccountServiceTemplate accountServiceTemplate) throws PersistenceException, E;
    public void handleCompensationPendingRequests(PersistentCompensationPendingRequests compensationPendingRequests) throws PersistenceException, E;
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    public void handleAccountServiceSuccessful(PersistentAccountServiceSuccessful accountServiceSuccessful) throws PersistenceException, E;
    public void handleAccountTriggerListe(PersistentAccountTriggerListe accountTriggerListe) throws PersistenceException, E;
    public void handleAccountAllCompensation(PersistentAccountAllCompensation accountAllCompensation) throws PersistenceException, E;
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException, E;
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException, E;
    public void handleAllCompensationListePendingCompensationRequests(PersistentAllCompensationListePendingCompensationRequests allCompensationListePendingCompensationRequests) throws PersistenceException, E;
    public void handleAllCompensationListeOutgoingCompensations(PersistentAllCompensationListeOutgoingCompensations allCompensationListeOutgoingCompensations) throws PersistenceException, E;
    public void handleAccountServiceNotExecuted(PersistentAccountServiceNotExecuted accountServiceNotExecuted) throws PersistenceException, E;
    public void handleAccountServiceBankFees(PersistentAccountServiceBankFees accountServiceBankFees) throws PersistenceException, E;
    
}
