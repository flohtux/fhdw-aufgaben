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
import viewClient.AccountServiceConnection;
import viewClient.ConnectionMaster;
import viewClient.ExceptionAndEventHandler;

public interface AccountServiceView extends ServiceView {
    
    public AccountView getAccount()throws ModelException;
    public void setAccount(AccountView newValue) throws ModelException ;
    public EventWrapperView getEventhandle()throws ModelException;
    public void setEventhandle(EventWrapperView newValue) throws ModelException ;
    public DebitTransferSuccessfulView getSuccessful()throws ModelException;
    public void setSuccessful(DebitTransferSuccessfulView newValue) throws ModelException ;
    public DebitTransferNotExecutedView getNotExecuted()throws ModelException;
    public void setNotExecuted(DebitTransferNotExecutedView newValue) throws ModelException ;
    public DebitTransferTemplateView getTemplate()throws ModelException;
    public void setTemplate(DebitTransferTemplateView newValue) throws ModelException ;
    public BankFeesView getBankFees()throws ModelException;
    public void setBankFees(BankFeesView newValue) throws ModelException ;
    
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

