
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends ServiceReturnVisitor<R> ,StornoStateReturnVisitor<R> ,BooleanValueReturnVisitor<R> ,CurrencyReturnVisitor<R> ,TransactionFeeReturnVisitor<R> ,LimitTypeReturnVisitor<R> ,DebitNoteTransferTransactionReturnVisitor<R> ,DebitNoteTransferStateReturnVisitor<R> {
    
    public R handleInternalFee(InternalFeeView internalFee) throws ModelException;
    public R handlePercent(PercentView percent) throws ModelException;
    public R handleAmount(AmountView amount) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleLimitAccount(LimitAccountView limitAccount) throws ModelException;
    public R handleAccount(AccountView account) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleMoney(MoneyView money) throws ModelException;
    public R handleBank(BankView bank) throws ModelException;
    public R handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    
}
