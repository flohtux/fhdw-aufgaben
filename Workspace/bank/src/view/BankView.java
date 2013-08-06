package view;

import view.objects.*;

import view.visitor.*;

public interface BankView extends Anything, AbstractViewRoot {
    
    public long getBankNumber()throws ModelException;
    public void setBankNumber(long newValue) throws ModelException ;
    public String getName()throws ModelException;
    public void setName(String newValue) throws ModelException ;
    public TransactionFeeView getFee()throws ModelException;
    public void setFee(TransactionFeeView newValue) throws ModelException ;
    public InternalFeeView getInternalFee()throws ModelException;
    public void setInternalFee(InternalFeeView newValue) throws ModelException ;
    public AccountView getOwnAccount()throws ModelException;
    public void setOwnAccount(AccountView newValue) throws ModelException ;
    public AdministratorView getAdministrator()throws ModelException;
    public void setAdministrator(AdministratorView newValue) throws ModelException ;
    public java.util.Vector<AccountView> getCurrentAccounts()throws ModelException;
    public void setCurrentAccounts(java.util.Vector<AccountView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

