package view;

import view.objects.*;

import view.visitor.*;

public interface CurrencyManagerView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<AmountView> getExchange()throws ModelException;
    public void setExchange(java.util.Vector<AmountView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

