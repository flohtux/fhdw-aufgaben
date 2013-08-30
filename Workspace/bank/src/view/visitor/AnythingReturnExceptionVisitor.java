
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends ServiceReturnExceptionVisitor<R, E> ,DebitTransferTransactionReturnExceptionVisitor<R, E> ,DebitTransferStateReturnExceptionVisitor<R, E> ,StornoStateReturnExceptionVisitor<R, E> ,BooleanValueReturnExceptionVisitor<R, E> ,CurrencyReturnExceptionVisitor<R, E> ,TransactionFeeReturnExceptionVisitor<R, E> ,LimitTypeReturnExceptionVisitor<R, E> {
    
    public R handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException, E;
    public R handleDebitTransferListe(DebitTransferListeView debitTransferListe) throws ModelException, E;
    public R handleInternalFee(InternalFeeView internalFee) throws ModelException, E;
    public R handleDebitTransferDoubleState(DebitTransferDoubleStateView debitTransferDoubleState) throws ModelException, E;
    public R handlePercent(PercentView percent) throws ModelException, E;
    public R handleAmount(AmountView amount) throws ModelException, E;
    public R handleDebitTransferTemplate(DebitTransferTemplateView debitTransferTemplate) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleLimitAccount(LimitAccountView limitAccount) throws ModelException, E;
    public R handleDebitGrantListe(DebitGrantListeView debitGrantListe) throws ModelException, E;
    public R handleAccountPx(AccountPxView accountPx) throws ModelException, E;
    public R handleAccount(AccountView account) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleDebitTransferNotExecuted(DebitTransferNotExecutedView debitTransferNotExecuted) throws ModelException, E;
    public R handleMoney(MoneyView money) throws ModelException, E;
    public R handleBank(BankView bank) throws ModelException, E;
    public R handleDebitTransferSuccessful(DebitTransferSuccessfulView debitTransferSuccessful) throws ModelException, E;
    public R handleEventWrapper(EventWrapperView eventWrapper) throws ModelException, E;
    public R handleDebitGrant(DebitGrantView debitGrant) throws ModelException, E;
    public R handleBankCreator(BankCreatorView bankCreator) throws ModelException, E;
    
}
