
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends ServiceReturnExceptionVisitor<R, E> ,TransactionFeeReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> ,AccountLimitStateReturnExceptionVisitor<R, E> ,CurrencyReturnExceptionVisitor<R, E> ,DebitNoteTransactionReturnExceptionVisitor<R, E> {
    
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public R handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public R handleAccount(PersistentAccount account) throws PersistenceException, E;
    public R handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public R handleAmount(PersistentAmount amount) throws PersistenceException, E;
    public R handleMoney(PersistentMoney money) throws PersistenceException, E;
    public R handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException, E;
    public R handleBank(PersistentBank bank) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    public R handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException, E;
    
}
