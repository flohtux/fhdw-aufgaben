package view;

import view.objects.*;

import view.visitor.*;

public interface DebitTransferPayedFeesView extends Anything, AbstractViewRoot {
    
    public MoneyView getPayedFees()throws ModelException;
    public void setPayedFees(MoneyView newValue) throws ModelException ;
    public AccountView getPayingAccount()throws ModelException;
    public void setPayingAccount(AccountView newValue) throws ModelException ;
    
    public void accept(DebitTransferPayedFeesVisitor visitor) throws ModelException;
    public <R> R accept(DebitTransferPayedFeesReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(DebitTransferPayedFeesExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(DebitTransferPayedFeesReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

