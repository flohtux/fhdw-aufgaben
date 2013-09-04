
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends ServiceReturnExceptionVisitor<R, E> ,DebitTransferTransactionReturnExceptionVisitor<R, E> ,DebitTransferStateReturnExceptionVisitor<R, E> ,StornoStateReturnExceptionVisitor<R, E> ,BooleanValueReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> ,CurrencyReturnExceptionVisitor<R, E> ,TransactionFeeReturnExceptionVisitor<R, E> ,LimitTypeReturnExceptionVisitor<R, E> ,RuleReturnExceptionVisitor<R, E> {
    
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public R handleAccountReceivedDebitGrant(PersistentAccountReceivedDebitGrant accountReceivedDebitGrant) throws PersistenceException, E;
    public R handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public R handleAccountGrantedDebitGrant(PersistentAccountGrantedDebitGrant accountGrantedDebitGrant) throws PersistenceException, E;
    public R handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException, E;
    public R handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException, E;
    public R handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException, E;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    public R handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException, E;
    public R handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public R handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException, E;
    public R handlePercent(PersistentPercent percent) throws PersistenceException, E;
    public R handleAccountServiceTemplate(PersistentAccountServiceTemplate accountServiceTemplate) throws PersistenceException, E;
    public R handleAmount(PersistentAmount amount) throws PersistenceException, E;
    public R handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException, E;
    public R handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException, E;
    public R handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException, E;
    public R handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    public R handleAccountServiceSuccessful(PersistentAccountServiceSuccessful accountServiceSuccessful) throws PersistenceException, E;
    public R handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException, E;
    public R handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException, E;
    public R handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException, E;
    public R handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException, E;
    public R handleAccount(PersistentAccount account) throws PersistenceException, E;
    public R handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException, E;
    public R handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleTrigger(PersistentTrigger trigger) throws PersistenceException, E;
    public R handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException, E;
    public R handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException, E;
    public R handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException, E;
    public R handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException, E;
    public R handleMoney(PersistentMoney money) throws PersistenceException, E;
    public R handleBank(PersistentBank bank) throws PersistenceException, E;
    public R handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException, E;
    public R handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException, E;
    public R handleAccountServiceNotExecuted(PersistentAccountServiceNotExecuted accountServiceNotExecuted) throws PersistenceException, E;
    public R handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException, E;
    public R handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException, E;
    
}
