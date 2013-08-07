
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingExceptionVisitor<E extends UserException> extends ServiceExceptionVisitor<E>,DebitTransferTransactionExceptionVisitor<E>,DebitTransferStateExceptionVisitor<E>,StornoStateExceptionVisitor<E>,BooleanValueExceptionVisitor<E>,CurrencyExceptionVisitor<E>,TransactionFeeExceptionVisitor<E>,LimitTypeExceptionVisitor<E>{
    
    public void handleInternalFee(InternalFeeView internalFee) throws ModelException, E;
    public void handlePercent(PercentView percent) throws ModelException, E;
    public void handleAmount(AmountView amount) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleLimitAccount(LimitAccountView limitAccount) throws ModelException, E;
    public void handleAccount(AccountView account) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleMoney(MoneyView money) throws ModelException, E;
    public void handleBank(BankView bank) throws ModelException, E;
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException, E;
    
}
