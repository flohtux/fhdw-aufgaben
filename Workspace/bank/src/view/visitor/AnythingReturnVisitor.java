
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends ServiceReturnVisitor<R> ,DebitTransferTransactionReturnVisitor<R> ,DebitTransferStateReturnVisitor<R> ,StornoStateReturnVisitor<R> ,BooleanValueReturnVisitor<R> ,CurrencyReturnVisitor<R> ,TransactionFeeReturnVisitor<R> ,LimitTypeReturnVisitor<R> ,TriggerStateReturnVisitor<R> ,RuleReturnVisitor<R> {
    
    public R handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException;
    public R handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException;
    public R handleInternalFee(InternalFeeView internalFee) throws ModelException;
    public R handleDebitTransferDoubleState(DebitTransferDoubleStateView debitTransferDoubleState) throws ModelException;
    public R handlePercent(PercentView percent) throws ModelException;
    public R handleAmount(AmountView amount) throws ModelException;
    public R handleFeeWrapper(FeeWrapperView feeWrapper) throws ModelException;
    public R handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleTriggerListe(TriggerListeView triggerListe) throws ModelException;
    public R handleBankPx(BankPxView bankPx) throws ModelException;
    public R handleLimitAccount(LimitAccountView limitAccount) throws ModelException;
    public R handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException;
    public R handleAccountPx(AccountPxView accountPx) throws ModelException;
    public R handleAccount(AccountView account) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleTrigger(TriggerView trigger) throws ModelException;
    public R handleDebitTransferNotExecuted(DebitTransferNotExecutedView debitTransferNotExecuted) throws ModelException;
    public R handleMoney(MoneyView money) throws ModelException;
    public R handleBank(BankView bank) throws ModelException;
    public R handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException;
    public R handleEventWrapper(EventWrapperView eventWrapper) throws ModelException;
    public R handleDebitGrant(DebitGrantView debitGrant) throws ModelException;
    public R handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    
}
