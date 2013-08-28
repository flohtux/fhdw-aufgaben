package view;

import view.objects.*;

import view.visitor.*;

public interface AccountView extends Anything, AbstractViewRoot {
    
    public long getAccountNumber()throws ModelException;
    public void setAccountNumber(long newValue) throws ModelException ;
    public MoneyView getMoney()throws ModelException;
    public void setMoney(MoneyView newValue) throws ModelException ;
    public MoneyView getMoney2()throws ModelException;
    public void setMoney2(MoneyView newValue) throws ModelException ;
    public LimitAccountView getLimit()throws ModelException;
    public void setLimit(LimitAccountView newValue) throws ModelException ;
    public java.util.Vector<DebitTransferTransactionView> getDebitTransferTransactions()throws ModelException;
    public void setDebitTransferTransactions(java.util.Vector<DebitTransferTransactionView> newValue) throws ModelException ;
    public DebitGrantListeView getGrantedDebitGrant()throws ModelException;
    public void setGrantedDebitGrant(DebitGrantListeView newValue) throws ModelException ;
    public DebitGrantListeView getReceivedDebitGrant()throws ModelException;
    public void setReceivedDebitGrant(DebitGrantListeView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

