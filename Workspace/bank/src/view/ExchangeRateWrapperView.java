package view;

import view.objects.*;

import view.visitor.*;

public interface ExchangeRateWrapperView extends Anything, AbstractViewRoot {
    
    public AmountView getAmount()throws ModelException;
    public void setAmount(AmountView newValue) throws ModelException ;
    public CurrencyView getCurrency()throws ModelException;
    public void setCurrency(CurrencyView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

