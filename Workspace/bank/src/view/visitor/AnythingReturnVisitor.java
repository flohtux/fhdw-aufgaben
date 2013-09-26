
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends ServiceReturnVisitor<R> ,DebitTransferTransactionReturnVisitor<R> ,DebitTransferStateReturnVisitor<R> ,BooleanValueReturnVisitor<R> ,CurrencyReturnVisitor<R> ,TransactionFeeReturnVisitor<R> ,CompensationRequestStateReturnVisitor<R> ,TriggerValueReturnVisitor<R> ,DebitTransferPayedFeesReturnVisitor<R> ,CompensationStateReturnVisitor<R> ,LimitTypeReturnVisitor<R> ,TriggerStateReturnVisitor<R> ,RuleReturnVisitor<R> {
    
    public R handleCompensation(CompensationView compensation) throws ModelException;
    public R handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException;
    public R handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException;
    public R handlePercent(PercentView percent) throws ModelException;
    public R handleExchangeRateWrapper(ExchangeRateWrapperView exchangeRateWrapper) throws ModelException;
    public R handleBankOwnAccountPx(BankOwnAccountPxView bankOwnAccountPx) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException;
    public R handleTriggerListe(TriggerListeView triggerListe) throws ModelException;
    public R handleCompensationRequest(CompensationRequestView compensationRequest) throws ModelException;
    public R handleAccountPx(AccountPxView accountPx) throws ModelException;
    public R handleNoDebitTransfer(NoDebitTransferView noDebitTransfer) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleMoney(MoneyView money) throws ModelException;
    public R handleDebitGrant(DebitGrantView debitGrant) throws ModelException;
    public R handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    public R handleAllCompensationListe(AllCompensationListeView allCompensationListe) throws ModelException;
    public R handleInternalFee(InternalFeeView internalFee) throws ModelException;
    public R handleDebitTransferDoubleState(DebitTransferDoubleStateView debitTransferDoubleState) throws ModelException;
    public R handleAmount(AmountView amount) throws ModelException;
    public R handleDebitTransferPayedFees(DebitTransferPayedFeesView debitTransferPayedFees) throws ModelException;
    public R handleBankPx(BankPxView bankPx) throws ModelException;
    public R handleLimitAccount(LimitAccountView limitAccount) throws ModelException;
    public R handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException;
    public R handleAccount(AccountView account) throws ModelException;
    public R handleDebitTransferNotExecuted(DebitTransferNotExecutedView debitTransferNotExecuted) throws ModelException;
    public R handleCompensationListe(CompensationListeView compensationListe) throws ModelException;
    public R handleBank(BankView bank) throws ModelException;
    public R handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException;
    public R handleEventWrapper(EventWrapperView eventWrapper) throws ModelException;
    public R handleBankFees(BankFeesView bankFees) throws ModelException;
    public R handleDebitGrantListePx(DebitGrantListePxView debitGrantListePx) throws ModelException;
    public R handleCompensationRequestListe(CompensationRequestListeView compensationRequestListe) throws ModelException;
    
}
