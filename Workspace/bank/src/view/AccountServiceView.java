package view;

import viewClient.*;

import view.visitor.*;

public interface AccountServiceView extends ServiceView {
    
    public AccountView getAccount()throws ModelException;
    public void setAccount(AccountView newValue) throws ModelException ;
    public java.util.Vector<DebitTransferView> getSuccessfullStates()throws ModelException;
    public void setSuccessfullStates(java.util.Vector<DebitTransferView> newValue) throws ModelException ;
    public java.util.Vector<DebitTransferView> getNotSuccessfullStates()throws ModelException;
    public void setNotSuccessfullStates(java.util.Vector<DebitTransferView> newValue) throws ModelException ;
    
    public void accept(ServiceVisitor visitor) throws ModelException;
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(RemoteVisitor visitor) throws ModelException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    public AccountServiceConnection connectAccountService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

