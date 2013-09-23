
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends ServiceVisitor,DebitTransferTransactionVisitor,DebitTransferStateVisitor,BooleanValueVisitor,CurrencyVisitor,TransactionFeeVisitor,CompensationRequestStateVisitor,TriggerValueVisitor,StornoStateVisitor,CommonDateVisitor,LimitTypeVisitor,TriggerStateVisitor,RuleVisitor{
    
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleCompensation(PersistentCompensation compensation) throws PersistenceException;
    public void handleAccountReceivedDebitGrant(PersistentAccountReceivedDebitGrant accountReceivedDebitGrant) throws PersistenceException;
    public void handleSubj(PersistentSubj subj) throws PersistenceException;
    public void handleChangeNameCommand(PersistentChangeNameCommand changeNameCommand) throws PersistenceException;
    public void handleDebitTransferListe(PersistentDebitTransferListe debitTransferListe) throws PersistenceException;
    public void handleCurrencyManager(PersistentCurrencyManager currencyManager) throws PersistenceException;
    public void handlePercent(PersistentPercent percent) throws PersistenceException;
    public void handleExchangeRateWrapper(PersistentExchangeRateWrapper exchangeRateWrapper) throws PersistenceException;
    public void handleExecuteCompensationCommand(PersistentExecuteCompensationCommand executeCompensationCommand) throws PersistenceException;
    public void handleBankOwnAccountPx(PersistentBankOwnAccountPx bankOwnAccountPx) throws PersistenceException;
    public void handleChangeSubjectCommand(PersistentChangeSubjectCommand changeSubjectCommand) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleDebitTransferTemplate(PersistentDebitTransferTemplate debitTransferTemplate) throws PersistenceException;
    public void handleCreateDebitGrantCommand(PersistentCreateDebitGrantCommand createDebitGrantCommand) throws PersistenceException;
    public void handleTriggerListe(PersistentTriggerListe triggerListe) throws PersistenceException;
    public void handleExecuteCommand(PersistentExecuteCommand executeCommand) throws PersistenceException;
    public void handleAccountServiceSuccessful(PersistentAccountServiceSuccessful accountServiceSuccessful) throws PersistenceException;
    public void handleChangeReceiverAccountCommand(PersistentChangeReceiverAccountCommand changeReceiverAccountCommand) throws PersistenceException;
    public void handleCompensationRequest(PersistentCompensationRequest compensationRequest) throws PersistenceException;
    public void handleAccountAllCompensation(PersistentAccountAllCompensation accountAllCompensation) throws PersistenceException;
    public void handleAccountPx(PersistentAccountPx accountPx) throws PersistenceException;
    public void handleNoDebitTransfer(PersistentNoDebitTransfer noDebitTransfer) throws PersistenceException;
    public void handleAdministratorCurrencyManager(PersistentAdministratorCurrencyManager administratorCurrencyManager) throws PersistenceException;
    public void handleUseTemplateCommand(PersistentUseTemplateCommand useTemplateCommand) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleAccountDebitTransferTransactions(PersistentAccountDebitTransferTransactions accountDebitTransferTransactions) throws PersistenceException;
    public void handleChangeMoneyCommand(PersistentChangeMoneyCommand changeMoneyCommand) throws PersistenceException;
    public void handleMoney(PersistentMoney money) throws PersistenceException;
    public void handleAllCompensationListeOutgoingCompensations(PersistentAllCompensationListeOutgoingCompensations allCompensationListeOutgoingCompensations) throws PersistenceException;
    public void handleAccountServiceNotExecuted(PersistentAccountServiceNotExecuted accountServiceNotExecuted) throws PersistenceException;
    public void handleDebitGrant(PersistentDebitGrant debitGrant) throws PersistenceException;
    public void handleBankCreator(PersistentBankCreator bankCreator) throws PersistenceException;
    public void handleAllCompensationListe(PersistentAllCompensationListe allCompensationListe) throws PersistenceException;
    public void handleAccountGrantedDebitGrant(PersistentAccountGrantedDebitGrant accountGrantedDebitGrant) throws PersistenceException;
    public void handleCreateAccountCommand(PersistentCreateAccountCommand createAccountCommand) throws PersistenceException;
    public void handleInternalFee(PersistentInternalFee internalFee) throws PersistenceException;
    public void handleDebitTransferDoubleState(PersistentDebitTransferDoubleState debitTransferDoubleState) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handleChangeReceiverBankCommand(PersistentChangeReceiverBankCommand changeReceiverBankCommand) throws PersistenceException;
    public void handleAccountServiceTemplate(PersistentAccountServiceTemplate accountServiceTemplate) throws PersistenceException;
    public void handleAmount(PersistentAmount amount) throws PersistenceException;
    public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException;
    public void handleBankPx(PersistentBankPx bankPx) throws PersistenceException;
    public void handleCompensationPendingRequests(PersistentCompensationPendingRequests compensationPendingRequests) throws PersistenceException;
    public void handleAdministratorBanks(PersistentAdministratorBanks administratorBanks) throws PersistenceException;
    public void handleLimitAccount(PersistentLimitAccount limitAccount) throws PersistenceException;
    public void handleCompensationDeclinedCommand(PersistentCompensationDeclinedCommand compensationDeclinedCommand) throws PersistenceException;
    public void handleDebitGrantListe(PersistentDebitGrantListe debitGrantListe) throws PersistenceException;
    public void handleAccountTriggerListe(PersistentAccountTriggerListe accountTriggerListe) throws PersistenceException;
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    public void handleDebitTransferNotExecuted(PersistentDebitTransferNotExecuted debitTransferNotExecuted) throws PersistenceException;
    public void handleChangeCurrencyCommand(PersistentChangeCurrencyCommand changeCurrencyCommand) throws PersistenceException;
    public void handleCompensationListe(PersistentCompensationListe compensationListe) throws PersistenceException;
    public void handleAllCompensationListePendingCompensationRequests(PersistentAllCompensationListePendingCompensationRequests allCompensationListePendingCompensationRequests) throws PersistenceException;
    public void handleBank(PersistentBank bank) throws PersistenceException;
    public void handleDebitTransferSuccessful(PersistentDebitTransferSuccessful debitTransferSuccessful) throws PersistenceException;
    public void handleEventWrapper(PersistentEventWrapper eventWrapper) throws PersistenceException;
    public void handleBankFees(PersistentBankFees bankFees) throws PersistenceException;
    public void handleAccountServiceBankFees(PersistentAccountServiceBankFees accountServiceBankFees) throws PersistenceException;
    public void handleCompensationRequestListe(PersistentCompensationRequestListe compensationRequestListe) throws PersistenceException;
    
}
