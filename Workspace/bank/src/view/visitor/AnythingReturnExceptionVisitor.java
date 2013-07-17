
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends ServiceReturnExceptionVisitor<R, E> ,TransactionFeeReturnExceptionVisitor<R, E> ,AccountLimitStateReturnExceptionVisitor<R, E> ,CurrencyReturnExceptionVisitor<R, E> ,DebitNoteTransactionReturnExceptionVisitor<R, E> {
    
    public R handleAccount(AccountView account) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleAmount(AmountView amount) throws ModelException, E;
    public R handleMoney(MoneyView money) throws ModelException, E;
    public R handleBank(BankView bank) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleBankCreator(BankCreatorView bankCreator) throws ModelException, E;
    
}
