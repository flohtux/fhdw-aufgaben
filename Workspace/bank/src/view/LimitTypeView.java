package view;

import view.objects.AbstractViewRoot;
import view.visitor.LimitTypeExceptionVisitor;
import view.visitor.LimitTypeReturnExceptionVisitor;
import view.visitor.LimitTypeReturnVisitor;
import view.visitor.LimitTypeVisitor;

public interface LimitTypeView extends Anything, AbstractViewRoot {
    
    
    public void accept(LimitTypeVisitor visitor) throws ModelException;
    public <R> R accept(LimitTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(LimitTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(LimitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

