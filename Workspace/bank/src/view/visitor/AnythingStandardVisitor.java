
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCompensation(CompensationView compensation) throws ModelException{
        this.standardHandling(compensation);
    }
    public void handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException{
        this.standardHandling(debitTransferListe);
    }
    public void handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException{
        this.standardHandling(currencyManager);
    }
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException{
        this.standardHandling(executedState);
    }
    public void handleTrueValue(TrueValueView trueValue) throws ModelException{
        this.standardHandling(trueValue);
    }
    public void handlePercent(PercentView percent) throws ModelException{
        this.standardHandling(percent);
    }
    public void handleExchangeRateWrapper(ExchangeRateWrapperView exchangeRateWrapper) throws ModelException{
        this.standardHandling(exchangeRateWrapper);
    }
    public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException{
        this.standardHandling(successfulState);
    }
    public void handleNoTrigger(NoTriggerView noTrigger) throws ModelException{
        this.standardHandling(noTrigger);
    }
    public void handleBankOwnAccountPx(BankOwnAccountPxView bankOwnAccountPx) throws ModelException{
        this.standardHandling(bankOwnAccountPx);
    }
    public void handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException{
        this.standardHandling(procentualFee);
    }
    public void handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException{
        this.standardHandling(debitTransferTemplate);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleWaitingState(WaitingStateView waitingState) throws ModelException{
        this.standardHandling(waitingState);
    }
    public void handleSubjectRule(SubjectRuleView subjectRule) throws ModelException{
        this.standardHandling(subjectRule);
    }
    public void handleTriggerListe(TriggerListeView triggerListe) throws ModelException{
        this.standardHandling(triggerListe);
    }
    public void handleCompensationRequestedState(CompensationRequestedStateView compensationRequestedState) throws ModelException{
        this.standardHandling(compensationRequestedState);
    }
    public void handleWaitingCompensationState(WaitingCompensationStateView waitingCompensationState) throws ModelException{
        this.standardHandling(waitingCompensationState);
    }
    public void handleDisabledState(DisabledStateView disabledState) throws ModelException{
        this.standardHandling(disabledState);
    }
    public void handleCompensatedState(CompensatedStateView compensatedState) throws ModelException{
        this.standardHandling(compensatedState);
    }
    public void handleSuccessfulCompensationState(SuccessfulCompensationStateView successfulCompensationState) throws ModelException{
        this.standardHandling(successfulCompensationState);
    }
    public void handleDollar(DollarView dollar) throws ModelException{
        this.standardHandling(dollar);
    }
    public void handleLimit(LimitView limit) throws ModelException{
        this.standardHandling(limit);
    }
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException{
        this.standardHandling(mixedFee);
    }
    public void handleCompensationRequest(CompensationRequestView compensationRequest) throws ModelException{
        this.standardHandling(compensationRequest);
    }
    public void handleAccountPx(AccountPxView accountPx) throws ModelException{
        this.standardHandling(accountPx);
    }
    public void handleNoDebitTransfer(NoDebitTransferView noDebitTransfer) throws ModelException{
        this.standardHandling(noDebitTransfer);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleEuro(EuroView euro) throws ModelException{
        this.standardHandling(euro);
    }
    public void handleMoneyRule(MoneyRuleView moneyRule) throws ModelException{
        this.standardHandling(moneyRule);
    }
    public void handleMoney(MoneyView money) throws ModelException{
        this.standardHandling(money);
    }
    public void handlePfund(PfundView pfund) throws ModelException{
        this.standardHandling(pfund);
    }
    public void handleDebitGrant(DebitGrantView debitGrant) throws ModelException{
        this.standardHandling(debitGrant);
    }
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException{
        this.standardHandling(bankCreator);
    }
    public void handleAcceptedState(AcceptedStateView acceptedState) throws ModelException{
        this.standardHandling(acceptedState);
    }
    public void handleFalseValue(FalseValueView falseValue) throws ModelException{
        this.standardHandling(falseValue);
    }
    public void handleAllCompensationListe(AllCompensationListeView allCompensationListe) throws ModelException{
        this.standardHandling(allCompensationListe);
    }
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException{
        this.standardHandling(fixTransactionFee);
    }
    public void handleInternalFee(InternalFeeView internalFee) throws ModelException{
        this.standardHandling(internalFee);
    }
    public void handleDebitTransferDoubleState(DebitTransferDoubleStateView debitTransferDoubleState) throws ModelException{
        this.standardHandling(debitTransferDoubleState);
    }
    public void handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException{
        this.standardHandling(notSuccessfulState);
    }
    public void handleIncomingAccountRule(IncomingAccountRuleView incomingAccountRule) throws ModelException{
        this.standardHandling(incomingAccountRule);
    }
    public void handleAmount(AmountView amount) throws ModelException{
        this.standardHandling(amount);
    }
    public void handleNoLimit(NoLimitView noLimit) throws ModelException{
        this.standardHandling(noLimit);
    }
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.standardHandling(administrator);
    }
    public void handleBankService(BankServiceView bankService) throws ModelException{
        this.standardHandling(bankService);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    public void handleBankPx(BankPxView bankPx) throws ModelException{
        this.standardHandling(bankPx);
    }
    public void handleFranken(FrankenView franken) throws ModelException{
        this.standardHandling(franken);
    }
    public void handleLimitAccount(LimitAccountView limitAccount) throws ModelException{
        this.standardHandling(limitAccount);
    }
    public void handleEnabledState(EnabledStateView enabledState) throws ModelException{
        this.standardHandling(enabledState);
    }
    public void handleDebit(DebitView debit) throws ModelException{
        this.standardHandling(debit);
    }
    public void handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException{
        this.standardHandling(debitGrantListe);
    }
    public void handleAccountService(AccountServiceView accountService) throws ModelException{
        this.standardHandling(accountService);
    }
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleNotExecutedState(NotExecutedStateView notExecutedState) throws ModelException{
        this.standardHandling(notExecutedState);
    }
    public void handleTrigger(TriggerView trigger) throws ModelException{
        this.standardHandling(trigger);
    }
    public void handleYen(YenView yen) throws ModelException{
        this.standardHandling(yen);
    }
    public void handleTemplateState(TemplateStateView templateState) throws ModelException{
        this.standardHandling(templateState);
    }
    public void handleDebitTransferNotExecuted(DebitTransferNotExecutedView debitTransferNotExecuted) throws ModelException{
        this.standardHandling(debitTransferNotExecuted);
    }
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException{
        this.standardHandling(notExecutableState);
    }
    public void handleCompensationListe(CompensationListeView compensationListe) throws ModelException{
        this.standardHandling(compensationListe);
    }
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.standardHandling(transaction);
    }
    public void handleBank(BankView bank) throws ModelException{
        this.standardHandling(bank);
    }
    public void handleDeclinedCompensationState(DeclinedCompensationStateView declinedCompensationState) throws ModelException{
        this.standardHandling(declinedCompensationState);
    }
    public void handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException{
        this.standardHandling(debitTransferSuccessful);
    }
    public void handleEventWrapper(EventWrapperView eventWrapper) throws ModelException{
        this.standardHandling(eventWrapper);
    }
    public void handleBankFees(BankFeesView bankFees) throws ModelException{
        this.standardHandling(bankFees);
    }
    public void handleDeclinedState(DeclinedStateView declinedState) throws ModelException{
        this.standardHandling(declinedState);
    }
    public void handleDebitGrantListePx(DebitGrantListePxView debitGrantListePx) throws ModelException{
        this.standardHandling(debitGrantListePx);
    }
    public void handleCompensationRequestListe(CompensationRequestListeView compensationRequestListe) throws ModelException{
        this.standardHandling(compensationRequestListe);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
