package persistence;

import model.UserException;

import model.visitor.*;

public class ExecuteCompensationCommandICProxi extends PersistentInCacheProxi implements PersistentExecuteCompensationCommand{
    
    public ExecuteCompensationCommandICProxi(long objectId) {
        super(objectId);
    }
    public ExecuteCompensationCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theExecuteCompensationCommandFacade
            .getExecuteCompensationCommand(this.getId());
    }
    
    public long getClassId() {
        return 255;
    }
    
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentExecuteCompensationCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentExecuteCompensationCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentCompensation getCommandReceiver() throws PersistenceException {
        return ((PersistentExecuteCompensationCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentCompensation newValue) throws PersistenceException {
        ((PersistentExecuteCompensationCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentExecuteCompensationCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentExecuteCompensationCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentExecuteCompensationCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentExecuteCompensationCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentExecuteCompensationCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentExecuteCompensationCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleExecuteCompensationCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteCompensationCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteCompensationCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteCompensationCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleExecuteCompensationCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteCompensationCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteCompensationCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteCompensationCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleExecuteCompensationCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteCompensationCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteCompensationCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteCompensationCommand(this);
    }
    public void accept(CompensationCommandVisitor visitor) throws PersistenceException {
        visitor.handleExecuteCompensationCommand(this);
    }
    public <R> R accept(CompensationCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteCompensationCommand(this);
    }
    public <E extends UserException>  void accept(CompensationCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteCompensationCommand(this);
    }
    public <R, E extends UserException> R accept(CompensationCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteCompensationCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentExecuteCompensationCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentExecuteCompensationCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentExecuteCompensationCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentExecuteCompensationCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentExecuteCompensationCommand)this.getTheObject()).sendResult();
    }

    
}
