
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends ServiceReturnVisitor<R> ,TransactionFeeReturnVisitor<R> ,AccountLimitStateReturnVisitor<R> ,CurrencyReturnVisitor<R> ,DebitNoteTransactionReturnVisitor<R> {
    
    public R handleAccount(AccountView account) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleAmount(AmountView amount) throws ModelException;
    public R handleMoney(MoneyView money) throws ModelException;
    public R handleBank(BankView bank) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    
}
