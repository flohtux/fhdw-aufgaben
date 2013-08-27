package persistence;

import model.UserException;

import model.visitor.*;

public class ChangeReceiverAccountCommandProxi extends PersistentProxi implements PersistentChangeReceiverAccountCommand{
    
    public ChangeReceiverAccountCommandProxi(long objectId) {
        super(objectId);
    }
    public ChangeReceiverAccountCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theChangeReceiverAccountCommandFacade
            .getChangeReceiverAccountCommand(this.getId());
    }
    
    public long getClassId() {
        return 217;
    }
    
    public PersistentDebitTransfer getTrans() throws PersistenceException {
        return ((PersistentChangeReceiverAccountCommand)this.getTheObject()).getTrans();
    }
    public void setTrans(PersistentDebitTransfer newValue) throws PersistenceException {
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).setTrans(newValue);
    }
    public long getReceiverAccountNumber() throws PersistenceException {
        return ((PersistentChangeReceiverAccountCommand)this.getTheObject()).getReceiverAccountNumber();
    }
    public void setReceiverAccountNumber(long newValue) throws PersistenceException {
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).setReceiverAccountNumber(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentChangeReceiverAccountCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAccount getCommandReceiver() throws PersistenceException {
        return ((PersistentChangeReceiverAccountCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentChangeReceiverAccountCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentChangeReceiverAccountCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentChangeReceiverAccountCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleChangeReceiverAccountCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeReceiverAccountCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeReceiverAccountCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeReceiverAccountCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleChangeReceiverAccountCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeReceiverAccountCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeReceiverAccountCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeReceiverAccountCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeReceiverAccountCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeReceiverAccountCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeReceiverAccountCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeReceiverAccountCommand(this);
    }
    public void accept(AccountCommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeReceiverAccountCommand(this);
    }
    public <R> R accept(AccountCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeReceiverAccountCommand(this);
    }
    public <E extends UserException>  void accept(AccountCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeReceiverAccountCommand(this);
    }
    public <R, E extends UserException> R accept(AccountCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeReceiverAccountCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentChangeReceiverAccountCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentChangeReceiverAccountCommand)this.getTheObject()).sendResult();
    }

    
}
