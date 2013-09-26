
package view.visitor;

import view.*;

public interface AnythingVisitor extends ServiceVisitor,DebitTransferTransactionVisitor,DebitTransferStateVisitor,BooleanValueVisitor,CurrencyVisitor,TransactionFeeVisitor,CompensationRequestStateVisitor,TriggerValueVisitor,CompensationStateVisitor,LimitTypeVisitor,TriggerStateVisitor,RuleVisitor{
    
    public void handleCompensation(CompensationView compensation) throws ModelException;
    public void handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException;
    public void handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException;
    public void handlePercent(PercentView percent) throws ModelException;
    public void handleExchangeRateWrapper(ExchangeRateWrapperView exchangeRateWrapper) throws ModelException;
    public void handleBankOwnAccountPx(BankOwnAccountPxView bankOwnAccountPx) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException;
    public void handleTriggerListe(TriggerListeView triggerListe) throws ModelException;
    public void handleCompensationRequest(CompensationRequestView compensationRequest) throws ModelException;
    public void handleAccountPx(AccountPxView accountPx) throws ModelException;
    public void handleNoDebitTransfer(NoDebitTransferView noDebitTransfer) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleMoney(MoneyView money) throws ModelException;
    public void handleDebitGrant(DebitGrantView debitGrant) throws ModelException;
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    public void handleAllCompensationListe(AllCompensationListeView allCompensationListe) throws ModelException;
    public void handleInternalFee(InternalFeeView internalFee) throws ModelException;
    public void handleDebitTransferDoubleState(DebitTransferDoubleStateView debitTransferDoubleState) throws ModelException;
    public void handleAmount(AmountView amount) throws ModelException;
    public void handleBankPx(BankPxView bankPx) throws ModelException;
    public void handleLimitAccount(LimitAccountView limitAccount) throws ModelException;
    public void handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException;
    public void handleAccount(AccountView account) throws ModelException;
    public void handleDebitTransferNotExecuted(DebitTransferNotExecutedView debitTransferNotExecuted) throws ModelException;
    public void handleCompensationListe(CompensationListeView compensationListe) throws ModelException;
    public void handleBank(BankView bank) throws ModelException;
    public void handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException;
    public void handleEventWrapper(EventWrapperView eventWrapper) throws ModelException;
    public void handleBankFees(BankFeesView bankFees) throws ModelException;
    public void handleDebitGrantListePx(DebitGrantListePxView debitGrantListePx) throws ModelException;
    public void handleCompensationRequestListe(CompensationRequestListeView compensationRequestListe) throws ModelException;
    
}
