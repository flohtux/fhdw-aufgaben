package view;

import view.objects.*;

import view.visitor.*;

public interface CurrencyView extends Anything, AbstractViewRoot {
    
    
    public void accept(CurrencyVisitor visitor) throws ModelException;
    public <R> R accept(CurrencyReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(CurrencyExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(CurrencyReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

