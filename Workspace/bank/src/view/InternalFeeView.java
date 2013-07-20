package view;

import view.objects.*;

import view.visitor.*;

public interface InternalFeeView extends Anything, AbstractViewRoot {
    
    public PercentView getPercent()throws ModelException;
    public void setPercent(PercentView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

