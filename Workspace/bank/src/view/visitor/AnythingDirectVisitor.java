
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleAccountService(AccountServiceView accountService) throws ModelException{
        this.handleService(accountService);
    }
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.handleService(administrator);
    }
    public void handleBankService(BankServiceView bankService) throws ModelException{
        this.handleService(bankService);
    }
    public abstract void handleCompensation(CompensationView compensation) throws ModelException;
    
    public abstract void handleDebitTransferTransaction(DebitTransferTransactionView debitTransferTransaction) throws ModelException;
    
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.handleDebitTransferTransaction(transaction);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.handleDebitTransferTransaction(transfer);
    }
    public void handleDebit(DebitView debit) throws ModelException{
        this.handleDebitTransferTransaction(debit);
    }
    public abstract void handleAllCompensationListe(AllCompensationListeView allCompensationListe) throws ModelException;
    
    public abstract void handleDebitTransferState(DebitTransferStateView debitTransferState) throws ModelException;
    
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException{
        this.handleDebitTransferState(executedState);
    }
    public void handleNotExecutableState(NotExecutableStateView notExecutableState) throws ModelException{
        this.handleDebitTransferState(notExecutableState);
    }
    public void handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException{
        this.handleDebitTransferState(notSuccessfulState);
    }
    public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException{
        this.handleDebitTransferState(successfulState);
    }
    public void handleNotExecutedState(NotExecutedStateView notExecutedState) throws ModelException{
        this.handleDebitTransferState(notExecutedState);
    }
    public void handleTemplateState(TemplateStateView templateState) throws ModelException{
        this.handleDebitTransferState(templateState);
    }
    public abstract void handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException;
    
    public abstract void handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException;
    
    public abstract void handleInternalFee(InternalFeeView internalFee) throws ModelException;
    
    public abstract void handleDebitTransferDoubleState(DebitTransferDoubleStateView debitTransferDoubleState) throws ModelException;
    
    public abstract void handleBooleanValue(BooleanValueView booleanValue) throws ModelException;
    
    public void handleFalseValue(FalseValueView falseValue) throws ModelException{
        this.handleBooleanValue(falseValue);
    }
    public void handleTrueValue(TrueValueView trueValue) throws ModelException{
        this.handleBooleanValue(trueValue);
    }
    public abstract void handlePercent(PercentView percent) throws ModelException;
    
    public abstract void handleExchangeRateWrapper(ExchangeRateWrapperView exchangeRateWrapper) throws ModelException;
    
    public abstract void handleCurrency(CurrencyView currency) throws ModelException;
    
    public void handleDollar(DollarView dollar) throws ModelException{
        this.handleCurrency(dollar);
    }
    public void handlePfund(PfundView pfund) throws ModelException{
        this.handleCurrency(pfund);
    }
    public void handleFranken(FrankenView franken) throws ModelException{
        this.handleCurrency(franken);
    }
    public void handleEuro(EuroView euro) throws ModelException{
        this.handleCurrency(euro);
    }
    public void handleYen(YenView yen) throws ModelException{
        this.handleCurrency(yen);
    }
    public abstract void handleAmount(AmountView amount) throws ModelException;
    
    public abstract void handleBankOwnAccountPx(BankOwnAccountPxView bankOwnAccountPx) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException;
    
    public abstract void handleTriggerListe(TriggerListeView triggerListe) throws ModelException;
    
    public abstract void handleCompensationState(CompensationStateView compensationState) throws ModelException;
    
    public void handleWaitingCompensationState(WaitingCompensationStateView waitingCompensationState) throws ModelException{
        this.handleCompensationState(waitingCompensationState);
    }
    public void handleDeclinedCompensationState(DeclinedCompensationStateView declinedCompensationState) throws ModelException{
        this.handleCompensationState(declinedCompensationState);
    }
    public void handleSuccessfulCompensationState(SuccessfulCompensationStateView successfulCompensationState) throws ModelException{
        this.handleCompensationState(successfulCompensationState);
    }
    public abstract void handleBankPx(BankPxView bankPx) throws ModelException;
    
    public abstract void handleLimitAccount(LimitAccountView limitAccount) throws ModelException;
    
    public abstract void handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException;
    
    public abstract void handleCompensationRequest(CompensationRequestView compensationRequest) throws ModelException;
    
    public abstract void handleAccountPx(AccountPxView accountPx) throws ModelException;
    
    public abstract void handleTransactionFee(TransactionFeeView transactionFee) throws ModelException;
    
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException{
        this.handleTransactionFee(mixedFee);
    }
    public void handleFixTransactionFee(FixTransactionFeeView fixTransactionFee) throws ModelException{
        this.handleTransactionFee(fixTransactionFee);
    }
    public void handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException{
        this.handleTransactionFee(procentualFee);
    }
    public abstract void handleAccount(AccountView account) throws ModelException;
    
    public abstract void handleNoDebitTransfer(NoDebitTransferView noDebitTransfer) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleDebitTransferNotExecuted(DebitTransferNotExecutedView debitTransferNotExecuted) throws ModelException;
    
    public abstract void handleLimitType(LimitTypeView limitType) throws ModelException;
    
    public void handleNoLimit(NoLimitView noLimit) throws ModelException{
        this.handleLimitType(noLimit);
    }
    public void handleLimit(LimitView limit) throws ModelException{
        this.handleLimitType(limit);
    }
    public abstract void handleTriggerState(TriggerStateView triggerState) throws ModelException;
    
    public void handleDisabledState(DisabledStateView disabledState) throws ModelException{
        this.handleTriggerState(disabledState);
    }
    public void handleEnabledState(EnabledStateView enabledState) throws ModelException{
        this.handleTriggerState(enabledState);
    }
    public abstract void handleCompensationListe(CompensationListeView compensationListe) throws ModelException;
    
    public abstract void handleCompensationRequestState(CompensationRequestStateView compensationRequestState) throws ModelException;
    
    public void handleWaitingState(WaitingStateView waitingState) throws ModelException{
        this.handleCompensationRequestState(waitingState);
    }
    public void handleDeclinedState(DeclinedStateView declinedState) throws ModelException{
        this.handleCompensationRequestState(declinedState);
    }
    public void handleAcceptedState(AcceptedStateView acceptedState) throws ModelException{
        this.handleCompensationRequestState(acceptedState);
    }
    public abstract void handleMoney(MoneyView money) throws ModelException;
    
    public abstract void handleBank(BankView bank) throws ModelException;
    
    public abstract void handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException;
    
    public abstract void handleTriggerValue(TriggerValueView triggerValue) throws ModelException;
    
    public void handleNoTrigger(NoTriggerView noTrigger) throws ModelException{
        this.handleTriggerValue(noTrigger);
    }
    public void handleTrigger(TriggerView trigger) throws ModelException{
        this.handleTriggerValue(trigger);
    }
    public abstract void handleRule(RuleView rule) throws ModelException;
    
    public void handleSubjectRule(SubjectRuleView subjectRule) throws ModelException{
        this.handleRule(subjectRule);
    }
    public void handleMoneyRule(MoneyRuleView moneyRule) throws ModelException{
        this.handleRule(moneyRule);
    }
    public void handleIncomingAccountRule(IncomingAccountRuleView incomingAccountRule) throws ModelException{
        this.handleRule(incomingAccountRule);
    }
    public abstract void handleEventWrapper(EventWrapperView eventWrapper) throws ModelException;
    
    public abstract void handleBankFees(BankFeesView bankFees) throws ModelException;
    
    public abstract void handleDebitGrant(DebitGrantView debitGrant) throws ModelException;
    
    public abstract void handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    
    public abstract void handleCompensationRequestListe(CompensationRequestListeView compensationRequestListe) throws ModelException;
    
    
}
