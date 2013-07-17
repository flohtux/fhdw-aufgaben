package view;

import view.objects.*;

import view.visitor.*;

public interface MoneyView extends Anything, AbstractViewRoot {
    
    public AmountView getBalance()throws ModelException;
    public void setBalance(AmountView newValue) throws ModelException ;
    public CurrencyView getCurrency()throws ModelException;
    public void setCurrency(CurrencyView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

