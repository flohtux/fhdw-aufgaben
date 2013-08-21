package persistence;

import model.UserException;

import model.visitor.*;

public class ExecuteCommandICProxi extends PersistentInCacheProxi implements PersistentExecuteCommand{
    
    public ExecuteCommandICProxi(long objectId) {
        super(objectId);
    }
    public ExecuteCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theExecuteCommandFacade
            .getExecuteCommand(this.getId());
    }
    
    public long getClassId() {
        return 186;
    }
    
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentExecuteCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentExecuteCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentDebitTransferTransaction getCommandReceiver() throws PersistenceException {
        return ((PersistentExecuteCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentDebitTransferTransaction newValue) throws PersistenceException {
        ((PersistentExecuteCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentExecuteCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentExecuteCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentExecuteCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentExecuteCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentExecuteCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentExecuteCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleExecuteCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleExecuteCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleExecuteCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteCommand(this);
    }
    public void accept(DebitTransferTransactionCommandVisitor visitor) throws PersistenceException {
        visitor.handleExecuteCommand(this);
    }
    public <R> R accept(DebitTransferTransactionCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteCommand(this);
    }
    public <E extends UserException>  void accept(DebitTransferTransactionCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteCommand(this);
    }
    public <R, E extends UserException> R accept(DebitTransferTransactionCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentExecuteCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentExecuteCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentExecuteCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentExecuteCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentExecuteCommand)this.getTheObject()).sendResult();
    }

    
}
