
package view.visitor;

import view.*;

public interface AnythingVisitor extends ServiceVisitor,DebitTransferTransactionVisitor,DebitTransferStateVisitor,StornoStateVisitor,BooleanValueVisitor,CurrencyVisitor,TransactionFeeVisitor,LimitTypeVisitor{
    
    public void handleCurrencyManager(CurrencyManagerView currencyManager) throws ModelException;
    public void handleInternalFee(InternalFeeView internalFee) throws ModelException;
    public void handlePercent(PercentView percent) throws ModelException;
    public void handleAmount(AmountView amount) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleLimitAccount(LimitAccountView limitAccount) throws ModelException;
    public void handleAccount(AccountView account) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleMoney(MoneyView money) throws ModelException;
    public void handleBank(BankView bank) throws ModelException;
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    
}
