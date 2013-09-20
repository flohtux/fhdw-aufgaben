package view;

import viewClient.*;

import view.objects.*;

import view.visitor.*;

public interface ServiceView extends Remote, Anything, AbstractViewRoot {
    
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException;
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException ;
    
    public void accept(ServiceVisitor visitor) throws ModelException;
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    public ServiceConnection connectService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

