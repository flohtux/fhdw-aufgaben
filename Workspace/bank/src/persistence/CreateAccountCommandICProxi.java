package persistence;

import model.UserException;

import model.visitor.*;

public class CreateAccountCommandICProxi extends PersistentInCacheProxi implements PersistentCreateAccountCommand{
    
    public CreateAccountCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateAccountCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateAccountCommandFacade
            .getCreateAccountCommand(this.getId());
    }
    
    public long getClassId() {
        return 107;
    }
    
    public String getCurrencyType() throws PersistenceException {
        return ((PersistentCreateAccountCommand)this.getTheObject()).getCurrencyType();
    }
    public void setCurrencyType(String newValue) throws PersistenceException {
        ((PersistentCreateAccountCommand)this.getTheObject()).setCurrencyType(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateAccountCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateAccountCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentBank getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateAccountCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentBank newValue) throws PersistenceException {
        ((PersistentCreateAccountCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateAccountCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateAccountCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateAccountCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAccountCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateAccountCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateAccountCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateAccountCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAccountCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAccountCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAccountCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateAccountCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAccountCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAccountCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAccountCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAccountCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAccountCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAccountCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAccountCommand(this);
    }
    public void accept(BankCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateAccountCommand(this);
    }
    public <R> R accept(BankCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateAccountCommand(this);
    }
    public <E extends UserException>  void accept(BankCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateAccountCommand(this);
    }
    public <R, E extends UserException> R accept(BankCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateAccountCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateAccountCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateAccountCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateAccountCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateAccountCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateAccountCommand)this.getTheObject()).sendResult();
    }

    
}
