package persistence;

import model.UserException;

import model.visitor.*;

public class CreateDebitGrantCommandProxi extends PersistentProxi implements PersistentCreateDebitGrantCommand{
    
    public CreateDebitGrantCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateDebitGrantCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade
            .getCreateDebitGrantCommand(this.getId());
    }
    
    public long getClassId() {
        return 198;
    }
    
    public PersistentAccount getReceiver() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getReceiver();
    }
    public void setReceiver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setReceiver(newValue);
    }
    public PersistentLimitType getLimit() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getLimit();
    }
    public void setLimit(PersistentLimitType newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setLimit(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAccount getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateDebitGrantCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateDebitGrantCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateDebitGrantCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateDebitGrantCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateDebitGrantCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateDebitGrantCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public void accept(AccountCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateDebitGrantCommand(this);
    }
    public <R> R accept(AccountCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public <E extends UserException>  void accept(AccountCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateDebitGrantCommand(this);
    }
    public <R, E extends UserException> R accept(AccountCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).sendResult();
    }

    
}
