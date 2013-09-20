package view;

import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.LimitTypeExceptionVisitor;
import view.visitor.LimitTypeReturnExceptionVisitor;
import view.visitor.LimitTypeReturnVisitor;
import view.visitor.LimitTypeVisitor;

public interface NoLimitView extends LimitTypeView {
    
    
    public void accept(LimitTypeVisitor visitor) throws ModelException;
    public <R> R accept(LimitTypeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(LimitTypeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(LimitTypeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

