
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingExceptionVisitor<E extends UserException> extends ServiceExceptionVisitor<E>,TransactionFeeExceptionVisitor<E>,CommonDateExceptionVisitor<E>,AccountLimitStateExceptionVisitor<E>,CurrencyExceptionVisitor<E>,DebitNoteTransactionExceptionVisitor<E>{
    
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public void handleAccount(PersistentAccount account) throws PersistenceException, E;
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleAmount(PersistentAmount amount) throws PersistenceException, E;
    public void handleMoney(PersistentMoney money) throws PersistenceException, E;
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException, E;
    public void handleBank(PersistentBank bank) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException, E;
    
}