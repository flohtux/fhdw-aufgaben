
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends ServiceReturnVisitor<R> ,DebitTransferTransactionReturnVisitor<R> ,DebitTransferStateReturnVisitor<R> ,BooleanValueReturnVisitor<R> ,CurrencyReturnVisitor<R> ,TransactionFeeReturnVisitor<R> ,CompensationRequestStateReturnVisitor<R> ,TriggerValueReturnVisitor<R> ,StornoStateReturnVisitor<R> ,CommonDateReturnVisitor<R> ,LimitTypeReturnVisitor<R> ,TriggerStateReturnVisitor<R> ,RuleReturnVisitor<R> {
    
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleCompensation(PersistentCompensation compensation) throws PersistenceException;
    public R handleAccountReceivedDebitGrant(PersistentAccountReceivedDebitGrant accountReceivedDebitGrant) throws PersistenceException;
    public R handleSubj(PersistentSubj subj) throws PersistenceException;
    public R handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public R handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException;
    public R handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException;
    public R handlePercent(PersistentPercent percent) throws PersistenceException;
    public R handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException;
    public R handleBankOwnAccountPx(PersistentBankOwnAccountPx bankOwnAccountPx) throws PersistenceException;
    public R handleChangeSubjectCommand(PersistentChangeSubjectCommand changeSubjectCommand) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException;
    public R handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException;
    public R handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException;
    public R handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException;
    public R handleAccountServiceSuccessful(PersistentAccountServiceSuccessful accountServiceSuccessful) throws PersistenceException;
    public R handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException;
    public R handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException;
    public R handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException;
    public R handleAccountAllCompensation(PersistentAccountAllCompensation accountAllCompensation) throws PersistenceException;
    public R handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException;
    public R handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException;
    public R handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException;
    public R handleMoney(PersistentMoney money) throws PersistenceException;
    public R handleAllCompensationListeOutgoingCompensations(PersistentAllCompensationListeOutgoingCompensations allCompensationListeOutgoingCompensations) throws PersistenceException;
    public R handleAccountServiceNotExecuted(PersistentAccountServiceNotExecuted accountServiceNotExecuted) throws PersistenceException;
    public R handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException;
    public R handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    public R handleAllCompensationListe(PersistentAllCompensationListe allCompensationListe) throws PersistenceException;
    public R handleAccountGrantedDebitGrant(PersistentAccountGrantedDebitGrant accountGrantedDebitGrant) throws PersistenceException;
    public R handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public R handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public R handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException;
    public R handleAccountServiceTemplate(PersistentAccountServiceTemplate accountServiceTemplate) throws PersistenceException;
    public R handleAmount(PersistentAmount amount) throws PersistenceException;
    public R handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException;
    public R handleBankPx(PersistentBankPx bankPx) throws PersistenceException;
    public R handleCompensationPendingRequests(PersistentCompensationPendingRequests compensationPendingRequests) throws PersistenceException;
    public R handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    public R handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    public R handleCompensationDeclinedCommand(PersistentCompensationDeclinedCommand compensationDeclinedCommand) throws PersistenceException;
    public R handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException;
    public R handleAccountTriggerListe(PersistentAccountTriggerListe accountTriggerListe) throws PersistenceException;
    public R handleAccount(PersistentAccount account) throws PersistenceException;
    public R handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException;
    public R handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException;
    public R handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException;
    public R handleAllCompensationListePendingCompensationRequests(PersistentAllCompensationListePendingCompensationRequests allCompensationListePendingCompensationRequests) throws PersistenceException;
    public R handleBank(PersistentBank bank) throws PersistenceException;
    public R handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException;
    public R handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException;
    public R handleBankFees(PersistentBankFees bankFees) throws PersistenceException;
    public R handleAccountServiceBankFees(PersistentAccountServiceBankFees accountServiceBankFees) throws PersistenceException;
    public R handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe) throws PersistenceException;
    
}
