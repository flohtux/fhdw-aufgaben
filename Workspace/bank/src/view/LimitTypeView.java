package view;

import view.objects.*;

import view.visitor.*;

public interface LimitTypeView extends Anything, AbstractViewRoot {
    
    
    public void accept(LimitTypeVisitor visitor) throws ModelException;
    public <R> R accept(LimitTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(LimitTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(LimitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

