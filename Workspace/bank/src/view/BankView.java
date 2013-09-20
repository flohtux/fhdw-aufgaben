package view;

import view.objects.AbstractViewRoot;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;

public interface BankView extends Anything, AbstractViewRoot {
    
    public long getBankNumber()throws ModelException;
    public void setBankNumber(long newValue) throws ModelException ;
    public String getName()throws ModelException;
    public void setName(String newValue) throws ModelException ;
    public BankFeesView getBankFees()throws ModelException;
    public void setBankFees(BankFeesView newValue) throws ModelException ;
    public BankOwnAccountPxView getOwnAccount()throws ModelException;
    public void setOwnAccount(BankOwnAccountPxView newValue) throws ModelException ;
    public java.util.Vector<AccountView> getCurrentAccounts()throws ModelException;
    public void setCurrentAccounts(java.util.Vector<AccountView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

