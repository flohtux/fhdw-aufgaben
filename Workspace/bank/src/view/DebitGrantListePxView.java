package view;

import view.objects.*;

import view.visitor.*;

public interface DebitGrantListePxView extends Anything, AbstractViewRoot {
    
    public DebitGrantListeView getD1()throws ModelException;
    public void setD1(DebitGrantListeView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

