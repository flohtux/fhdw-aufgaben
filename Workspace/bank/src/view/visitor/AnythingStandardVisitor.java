
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCompensation(CompensationView compensation) throws ModelException{
        this.standardHandling(compensation);
    }
    public void handleFalseValue(FalseValueView falseValue) throws ModelException{
        this.standardHandling(falseValue);
    }
    public void handleAllCompensationListe(AllCompensationListeView allCompensationListe) throws ModelException{
        this.standardHandling(allCompensationListe);
    }
    public void handleNoRequestState(NoRequestStateView noRequestState) throws ModelException{
        this.standardHandling(noRequestState);
    }
    public void handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException{
        this.standardHandling(currencyManager);
    }
    public void handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException{
        this.standardHandling(debitTransferListe);
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
    public void handleExecutedState(ExecutedStateView executedState) throws ModelException{
        this.standardHandling(executedState);
    }
    public void handleTrueValue(TrueValueView trueValue) throws ModelException{
        this.standardHandling(trueValue);
    }
    public void handlePercent(PercentView percent) throws ModelException{
        this.standardHandling(percent);
    }
    public void handleNotSuccessfulState(NotSuccessfulStateView notSuccessfulState) throws ModelException{
        this.standardHandling(notSuccessfulState);
    }
    public void handleSuccessfulState(SuccessfulStateView successfulState) throws ModelException{
        this.standardHandling(successfulState);
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
    public void handleNoTrigger(NoTriggerView noTrigger) throws ModelException{
        this.standardHandling(noTrigger);
    }
    public void handleAdministrator(AdministratorView administrator) throws ModelException{
        this.standardHandling(administrator);
    }
    public void handleBankService(BankServiceView bankService) throws ModelException{
        this.standardHandling(bankService);
    }
    public void handleProcentualFee(ProcentualFeeView procentualFee) throws ModelException{
        this.standardHandling(procentualFee);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException{
        this.standardHandling(debitTransferTemplate);
    }
    public void handleSubjectRule(SubjectRuleView subjectRule) throws ModelException{
        this.standardHandling(subjectRule);
    }
    public void handleTriggerListe(TriggerListeView triggerListe) throws ModelException{
        this.standardHandling(triggerListe);
    }
    public void handleBankPx(BankPxView bankPx) throws ModelException{
        this.standardHandling(bankPx);
    }
    public void handleDisabledState(DisabledStateView disabledState) throws ModelException{
        this.standardHandling(disabledState);
    }
    public void handleDollar(DollarView dollar) throws ModelException{
        this.standardHandling(dollar);
    }
    public void handleEnabledState(EnabledStateView enabledState) throws ModelException{
        this.standardHandling(enabledState);
    }
    public void handleLimitAccount(LimitAccountView limitAccount) throws ModelException{
        this.standardHandling(limitAccount);
    }
    public void handleFranken(FrankenView franken) throws ModelException{
        this.standardHandling(franken);
    }
    public void handleLimit(LimitView limit) throws ModelException{
        this.standardHandling(limit);
    }
    public void handleDebit(DebitView debit) throws ModelException{
        this.standardHandling(debit);
    }
    public void handleMixedFee(MixedFeeView mixedFee) throws ModelException{
        this.standardHandling(mixedFee);
    }
    public void handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException{
        this.standardHandling(debitGrantListe);
    }
    public void handleRequestState(RequestStateView requestState) throws ModelException{
        this.standardHandling(requestState);
    }
    public void handleAccountService(AccountServiceView accountService) throws ModelException{
        this.standardHandling(accountService);
    }
    public void handleCompensationRequest(CompensationRequestView compensationRequest) throws ModelException{
        this.standardHandling(compensationRequest);
    }
    public void handleAccountPx(AccountPxView accountPx) throws ModelException{
        this.standardHandling(accountPx);
    }
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleNotExecutedState(NotExecutedStateView notExecutedState) throws ModelException{
        this.standardHandling(notExecutedState);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleTrigger(TriggerView trigger) throws ModelException{
        this.standardHandling(trigger);
    }
    public void handleEuro(EuroView euro) throws ModelException{
        this.standardHandling(euro);
    }
    public void handleTemplateState(TemplateStateView templateState) throws ModelException{
        this.standardHandling(templateState);
    }
    public void handleYen(YenView yen) throws ModelException{
        this.standardHandling(yen);
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
    public void handleMoneyRule(MoneyRuleView moneyRule) throws ModelException{
        this.standardHandling(moneyRule);
    }
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.standardHandling(transaction);
    }
    public void handleMoney(MoneyView money) throws ModelException{
        this.standardHandling(money);
    }
    public void handleBank(BankView bank) throws ModelException{
        this.standardHandling(bank);
    }
    public void handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException{
        this.standardHandling(debitTransferSuccessful);
    }
    public void handleEventWrapper(EventWrapperView eventWrapper) throws ModelException{
        this.standardHandling(eventWrapper);
    }
    public void handlePfund(PfundView pfund) throws ModelException{
        this.standardHandling(pfund);
    }
    public void handleBankFees(BankFeesView bankFees) throws ModelException{
        this.standardHandling(bankFees);
    }
    public void handleNotSuccessfulStornoState(NotSuccessfulStornoStateView notSuccessfulStornoState) throws ModelException{
        this.standardHandling(notSuccessfulStornoState);
    }
    public void handleSuccessfulStornoState(SuccessfulStornoStateView successfulStornoState) throws ModelException{
        this.standardHandling(successfulStornoState);
    }
    public void handleDebitGrant(DebitGrantView debitGrant) throws ModelException{
        this.standardHandling(debitGrant);
    }
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException{
        this.standardHandling(bankCreator);
    }
    public void handleCompensationRequestListe(CompensationRequestListeView compensationRequestListe) throws ModelException{
        this.standardHandling(compensationRequestListe);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
