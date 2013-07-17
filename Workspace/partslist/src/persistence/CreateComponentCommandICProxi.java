package persistence;

import model.UserException;

import model.visitor.*;

public class CreateComponentCommandICProxi extends PersistentInCacheProxi implements PersistentCreateComponentCommand{
    
    public CreateComponentCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateComponentCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade
            .getCreateComponentCommand(this.getId());
    }
    
    public long getClassId() {
        return 101;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentCreateComponentCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateComponentCommand)this.getTheObject()).setName(newValue);
    }
    public String getComponentType() throws PersistenceException {
        return ((PersistentCreateComponentCommand)this.getTheObject()).getComponentType();
    }
    public void setComponentType(String newValue) throws PersistenceException {
        ((PersistentCreateComponentCommand)this.getTheObject()).setComponentType(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateComponentCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateComponentCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentPartsListManager getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateComponentCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentPartsListManager newValue) throws PersistenceException {
        ((PersistentCreateComponentCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentComponent getCommandResult() throws PersistenceException {
        return ((PersistentCreateComponentCommand)this.getTheObject()).getCommandResult();
    }
    public void setCommandResult(PersistentComponent newValue) throws PersistenceException {
        ((PersistentCreateComponentCommand)this.getTheObject()).setCommandResult(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateComponentCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateComponentCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateComponentCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateComponentCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateComponentCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateComponentCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateComponentCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateComponentCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateComponentCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateComponentCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateComponentCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateComponentCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateComponentCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateComponentCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateComponentCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateComponentCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateComponentCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateComponentCommand(this);
    }
    public void accept(PartsListManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateComponentCommand(this);
    }
    public <R> R accept(PartsListManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateComponentCommand(this);
    }
    public <E extends UserException>  void accept(PartsListManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateComponentCommand(this);
    }
    public <R, E extends UserException> R accept(PartsListManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateComponentCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateComponentCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateComponentCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateComponentCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateComponentCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateComponentCommand)this.getTheObject()).sendResult();
    }

    
}
