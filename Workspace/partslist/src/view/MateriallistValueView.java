package view;

import view.objects.*;

import view.visitor.*;

public interface MateriallistValueView extends Anything, AbstractViewRoot {
    
    public MaterialView getMaterial()throws ModelException;
    public void setMaterial(MaterialView newValue) throws ModelException ;
    public long getAmount()throws ModelException;
    public void setAmount(long newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

