
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends ServiceReturnVisitor<R> ,DebitTransferTransactionReturnVisitor<R> ,DebitTransferStateReturnVisitor<R> ,StornoStateReturnVisitor<R> ,BooleanValueReturnVisitor<R> ,CommonDateReturnVisitor<R> ,CurrencyReturnVisitor<R> ,TransactionFeeReturnVisitor<R> ,LimitTypeReturnVisitor<R> {
    
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleSubj(PersistentSubj subj) throws PersistenceException;
    public R handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public R handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handlePercent(PersistentPercent percent) throws PersistenceException;
    public R handleAmount(PersistentAmount amount) throws PersistenceException;
    public R handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    public R handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    public R handleAccount(PersistentAccount account) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException;
    public R handleMoney(PersistentMoney money) throws PersistenceException;
    public R handleBank(PersistentBank bank) throws PersistenceException;
    public R handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    
}
