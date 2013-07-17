
package view.visitor;

import view.*;

public interface AnythingVisitor extends ServiceVisitor,TransactionFeeVisitor,AccountLimitStateVisitor,CurrencyVisitor,DebitNoteTransactionVisitor{
    
    public void handleAccount(AccountView account) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleAmount(AmountView amount) throws ModelException;
    public void handleMoney(MoneyView money) throws ModelException;
    public void handleBank(BankView bank) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleBankCreator(BankCreatorView bankCreator) throws ModelException;
    
}
