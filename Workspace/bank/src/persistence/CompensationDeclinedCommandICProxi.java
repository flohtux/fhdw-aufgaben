package persistence;

import model.UserException;

import model.visitor.*;

public class CompensationDeclinedCommandICProxi extends PersistentInCacheProxi implements PersistentCompensationDeclinedCommand{
    
    public CompensationDeclinedCommandICProxi(long objectId) {
        super(objectId);
    }
    public CompensationDeclinedCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompensationDeclinedCommandFacade
            .getCompensationDeclinedCommand(this.getId());
    }
    
    public long getClassId() {
        return 268;
    }
    
    public PersistentCompensation getCompensation() throws PersistenceException {
        return ((PersistentCompensationDeclinedCommand)this.getTheObject()).getCompensation();
    }
    public void setCompensation(PersistentCompensation newValue) throws PersistenceException {
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).setCompensation(newValue);
    }
    public String getReason() throws PersistenceException {
        return ((PersistentCompensationDeclinedCommand)this.getTheObject()).getReason();
    }
    public void setReason(String newValue) throws PersistenceException {
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).setReason(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCompensationDeclinedCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAccount getCommandReceiver() throws PersistenceException {
        return ((PersistentCompensationDeclinedCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCompensationDeclinedCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCompensationDeclinedCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCompensationDeclinedCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleCompensationDeclinedCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationDeclinedCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationDeclinedCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationDeclinedCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationDeclinedCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationDeclinedCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationDeclinedCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationDeclinedCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCompensationDeclinedCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationDeclinedCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationDeclinedCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationDeclinedCommand(this);
    }
    public void accept(AccountCommandVisitor visitor) throws PersistenceException {
        visitor.handleCompensationDeclinedCommand(this);
    }
    public <R> R accept(AccountCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationDeclinedCommand(this);
    }
    public <E extends UserException>  void accept(AccountCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationDeclinedCommand(this);
    }
    public <R, E extends UserException> R accept(AccountCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationDeclinedCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCompensationDeclinedCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCompensationDeclinedCommand)this.getTheObject()).sendResult();
    }

    
}
