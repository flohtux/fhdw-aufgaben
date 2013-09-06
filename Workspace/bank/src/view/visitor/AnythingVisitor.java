
package view.visitor;

import view.*;

public interface AnythingVisitor extends ServiceVisitor,DebitTransferTransactionVisitor,DebitTransferStateVisitor,StornoStateVisitor,BooleanValueVisitor,CurrencyVisitor,TransactionFeeVisitor,LimitTypeVisitor,TriggerStateVisitor,RuleVisitor{
    
    public void handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException;
    public void handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException;
    public void handleInternalFee(InternalFeeView internalFee) throws ModelException;
    public void handleDebitTransferDoubleState(DebitTransferDoubleStateView debitTransferDoubleState) throws ModelException;
    public void handlePercent(PercentView percent) throws ModelException;
    public void handleAmount(AmountView amount) throws ModelException;
    public void handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleTriggerListe(TriggerListeView triggerListe) throws ModelException;
    public void handleLimitAccount(LimitAccountView limitAccount) throws ModelException;
    public void handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException;
    public void handleAccountPx(AccountPxView accountPx) throws ModelException;
    public void handleAccount(AccountView account) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleTrigger(TriggerView trigger) throws ModelException;
    public void handleDebitTransferNotExecuted(DebitTransferNotExecutedView debitTransferNotExecuted) throws ModelException;
    public void handleMoney(MoneyView money) throws ModelException;
    public void handleBank(BankView bank) throws ModelException;
    public void handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException;
    public void handleEventWrapper(EventWrapperView eventWrapper) throws ModelException;
    public void handleDebitGrant(DebitGrantView debitGrant) throws ModelException;
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    
}
