
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingExceptionVisitor<E extends UserException> extends ServiceExceptionVisitor<E>,DebitTransferTransactionExceptionVisitor<E>,DebitTransferStateExceptionVisitor<E>,StornoStateExceptionVisitor<E>,BooleanValueExceptionVisitor<E>,CurrencyExceptionVisitor<E>,TransactionFeeExceptionVisitor<E>,LimitTypeExceptionVisitor<E>,TriggerStateExceptionVisitor<E>,RuleExceptionVisitor<E>{
    
    public void handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException, E;
    public void handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException, E;
    public void handleInternalFee(InternalFeeView internalFee) throws ModelException, E;
    public void handleDebitTransferDoubleState(DebitTransferDoubleStateView debitTransferDoubleState) throws ModelException, E;
    public void handlePercent(PercentView percent) throws ModelException, E;
    public void handleAmount(AmountView amount) throws ModelException, E;
    public void handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleTriggerListe(TriggerListeView triggerListe) throws ModelException, E;
    public void handleBankPx(BankPxView bankPx) throws ModelException, E;
    public void handleLimitAccount(LimitAccountView limitAccount) throws ModelException, E;
    public void handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException, E;
    public void handleAccountPx(AccountPxView accountPx) throws ModelException, E;
    public void handleAccount(AccountView account) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleTrigger(TriggerView trigger) throws ModelException, E;
    public void handleDebitTransferNotExecuted(DebitTransferNotExecutedView debitTransferNotExecuted) throws ModelException, E;
    public void handleMoney(MoneyView money) throws ModelException, E;
    public void handleBank(BankView bank) throws ModelException, E;
    public void handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException, E;
    public void handleEventWrapper(EventWrapperView eventWrapper) throws ModelException, E;
    public void handleBankFees(BankFeesView bankFees) throws ModelException, E;
    public void handleDebitGrant(DebitGrantView debitGrant) throws ModelException, E;
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException, E;
    
}
