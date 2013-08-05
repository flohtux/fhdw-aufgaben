package persistence;

import model.UserException;

import model.visitor.*;

public class CreateBankCommandICProxi extends PersistentInCacheProxi implements PersistentCreateBankCommand{
    
    public CreateBankCommandICProxi(long objectId) {
        super(objectId);
    }
    public CreateBankCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade
            .getCreateBankCommand(this.getId());
    }
    
    public long getClassId() {
        return 118;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentCreateBankCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentCreateBankCommand)this.getTheObject()).setName(newValue);
    }
    public PersistentAdministrator getAdministrator() throws PersistenceException {
        return ((PersistentCreateBankCommand)this.getTheObject()).getAdministrator();
    }
    public void setAdministrator(PersistentAdministrator newValue) throws PersistenceException {
        ((PersistentCreateBankCommand)this.getTheObject()).setAdministrator(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateBankCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateBankCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentBankCreator getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateBankCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentBankCreator newValue) throws PersistenceException {
        ((PersistentCreateBankCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentBank getCommandResult() throws PersistenceException {
        return ((PersistentCreateBankCommand)this.getTheObject()).getCommandResult();
    }
    public void setCommandResult(PersistentBank newValue) throws PersistenceException {
        ((PersistentCreateBankCommand)this.getTheObject()).setCommandResult(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateBankCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateBankCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateBankCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateBankCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateBankCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateBankCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCreateBankCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateBankCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateBankCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateBankCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateBankCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateBankCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateBankCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateBankCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateBankCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateBankCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateBankCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateBankCommand(this);
    }
    public void accept(BankCreatorCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateBankCommand(this);
    }
    public <R> R accept(BankCreatorCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateBankCommand(this);
    }
    public <E extends UserException>  void accept(BankCreatorCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateBankCommand(this);
    }
    public <R, E extends UserException> R accept(BankCreatorCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateBankCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateBankCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateBankCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateBankCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateBankCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateBankCommand)this.getTheObject()).sendResult();
    }

    
}
