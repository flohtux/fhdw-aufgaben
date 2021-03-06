
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingExceptionVisitor<E extends UserException> extends ServiceExceptionVisitor<E>,DebitTransferTransactionExceptionVisitor<E>,DebitTransferStateExceptionVisitor<E>,BooleanValueExceptionVisitor<E>,CurrencyExceptionVisitor<E>,TransactionFeeExceptionVisitor<E>,CompensationRequestStateExceptionVisitor<E>,TriggerValueExceptionVisitor<E>,CommonDateExceptionVisitor<E>,CompensationStateExceptionVisitor<E>,LimitTypeExceptionVisitor<E>,TriggerStateExceptionVisitor<E>,RuleExceptionVisitor<E>{
    
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleAccountReceivedDebitGrant(PersistentAccountReceivedDebitGrant accountReceivedDebitGrant) throws PersistenceException, E;
    public void handleCompensation(PersistentCompensation compensation) throws PersistenceException, E;
    public void handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException, E;
    public void handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException, E;
    public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException, E;
    public void handlePercent(PersistentPercent percent) throws PersistenceException, E;
    public void handleExchangeRateWrapper(PersistentExchangeRateWrapper exchangeRateWrapper) throws PersistenceException, E;
    public void handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException, E;
    public void handleBankOwnAccountPx(PersistentBankOwnAccountPx bankOwnAccountPx) throws PersistenceException, E;
    public void handleChangeSubjectCommand(PersistentChangeSubjectCommand changeSubjectCommand) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException, E;
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException, E;
    public void handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException, E;
    public void handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException, E;
    public void handleAccountServiceSuccessful(PersistentAccountServiceSuccessful accountServiceSuccessful) throws PersistenceException, E;
    public void handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException, E;
    public void handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException, E;
    public void handleAccountAllCompensation(PersistentAccountAllCompensation accountAllCompensation) throws PersistenceException, E;
    public void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException, E;
    public void handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer) throws PersistenceException, E;
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException, E;
    public void handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException, E;
    public void handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException, E;
    public void handleMoney(PersistentMoney money) throws PersistenceException, E;
    public void handleAllCompensationListeOutgoingCompensations(PersistentAllCompensationListeOutgoingCompensations allCompensationListeOutgoingCompensations) throws PersistenceException, E;
    public void handleAccountServiceNotExecuted(PersistentAccountServiceNotExecuted accountServiceNotExecuted) throws PersistenceException, E;
    public void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException, E;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException, E;
    public void handleAllCompensationListe(PersistentAllCompensationListe allCompensationListe) throws PersistenceException, E;
    public void handleAccountGrantedDebitGrant(PersistentAccountGrantedDebitGrant accountGrantedDebitGrant) throws PersistenceException, E;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException, E;
    public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException, E;
    public void handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException, E;
    public void handleAccountServiceTemplate(PersistentAccountServiceTemplate accountServiceTemplate) throws PersistenceException, E;
    public void handleAmount(PersistentAmount amount) throws PersistenceException, E;
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException, E;
    public void handleBankPx(PersistentBankPx bankPx) throws PersistenceException, E;
    public void handleCompensationPendingRequests(PersistentCompensationPendingRequests compensationPendingRequests) throws PersistenceException, E;
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException, E;
    public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException, E;
    public void handleCompensationDeclinedCommand(PersistentCompensationDeclinedCommand compensationDeclinedCommand) throws PersistenceException, E;
    public void handleAccountTriggerListe(PersistentAccountTriggerListe accountTriggerListe) throws PersistenceException, E;
    public void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException, E;
    public void handleAccount(PersistentAccount account) throws PersistenceException, E;
    public void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException, E;
    public void handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException, E;
    public void handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException, E;
    public void handleAllCompensationListePendingCompensationRequests(PersistentAllCompensationListePendingCompensationRequests allCompensationListePendingCompensationRequests) throws PersistenceException, E;
    public void handleBank(PersistentBank bank) throws PersistenceException, E;
    public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException, E;
    public void handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException, E;
    public void handleBankFees(PersistentBankFees bankFees) throws PersistenceException, E;
    public void handleDebitGrantListePx(PersistentDebitGrantListePx debitGrantListePx) throws PersistenceException, E;
    public void handleAccountServiceBankFees(PersistentAccountServiceBankFees accountServiceBankFees) throws PersistenceException, E;
    public void handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe) throws PersistenceException, E;
    
}
