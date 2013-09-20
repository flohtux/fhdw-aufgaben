package view;

import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.CurrencyExceptionVisitor;
import view.visitor.CurrencyReturnExceptionVisitor;
import view.visitor.CurrencyReturnVisitor;
import view.visitor.CurrencyVisitor;

public interface EuroView extends CurrencyView {
    
    
    public void accept(CurrencyVisitor visitor) throws ModelException;
    public <R> R accept(CurrencyReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(CurrencyExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(CurrencyReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

