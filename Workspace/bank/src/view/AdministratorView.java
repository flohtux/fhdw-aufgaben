package view;

import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.RemoteExceptionVisitor;
import view.visitor.RemoteReturnExceptionVisitor;
import view.visitor.RemoteReturnVisitor;
import view.visitor.RemoteVisitor;
import view.visitor.ServiceExceptionVisitor;
import view.visitor.ServiceReturnExceptionVisitor;
import view.visitor.ServiceReturnVisitor;
import view.visitor.ServiceVisitor;
import viewClient.AdministratorConnection;
import viewClient.ConnectionMaster;
import viewClient.ExceptionAndEventHandler;

public interface AdministratorView extends ServiceView {
    
    public CurrencyManagerView getCurrencyManager()throws ModelException;
    public void setCurrencyManager(CurrencyManagerView newValue) throws ModelException ;
    public java.util.Vector<BankPxView> getBanks()throws ModelException;
    public void setBanks(java.util.Vector<BankPxView> newValue) throws ModelException ;
    
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
    
    public AdministratorConnection connectAdministrator(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException;
}

