package view;

import view.objects.*;

import view.visitor.*;

public interface AllCompensationListeView extends Anything, AbstractViewRoot {
    
    public CompensationListeView getOutgoingCompensations()throws ModelException;
    public void setOutgoingCompensations(CompensationListeView newValue) throws ModelException ;
    public CompensationRequestListeView getPendingCompensationRequests()throws ModelException;
    public void setPendingCompensationRequests(CompensationRequestListeView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

