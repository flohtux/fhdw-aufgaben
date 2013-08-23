package persistence;

import model.UserException;

import model.visitor.*;

public class UseTemplateCommandProxi extends PersistentProxi implements PersistentUseTemplateCommand{
    
    public UseTemplateCommandProxi(long objectId) {
        super(objectId);
    }
    public UseTemplateCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUseTemplateCommandFacade
            .getUseTemplateCommand(this.getId());
    }
    
    public long getClassId() {
        return 209;
    }
    
    public PersistentTransfer getDebitTransfer() throws PersistenceException {
        return ((PersistentUseTemplateCommand)this.getTheObject()).getDebitTransfer();
    }
    public void setDebitTransfer(PersistentTransfer newValue) throws PersistenceException {
        ((PersistentUseTemplateCommand)this.getTheObject()).setDebitTransfer(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentUseTemplateCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentUseTemplateCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAccountService getCommandReceiver() throws PersistenceException {
        return ((PersistentUseTemplateCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAccountService newValue) throws PersistenceException {
        ((PersistentUseTemplateCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentUseTemplateCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentUseTemplateCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentUseTemplateCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentUseTemplateCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentUseTemplateCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentUseTemplateCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleUseTemplateCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUseTemplateCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUseTemplateCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUseTemplateCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUseTemplateCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUseTemplateCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUseTemplateCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUseTemplateCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleUseTemplateCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUseTemplateCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUseTemplateCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUseTemplateCommand(this);
    }
    public void accept(AccountServiceCommandVisitor visitor) throws PersistenceException {
        visitor.handleUseTemplateCommand(this);
    }
    public <R> R accept(AccountServiceCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUseTemplateCommand(this);
    }
    public <E extends UserException>  void accept(AccountServiceCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUseTemplateCommand(this);
    }
    public <R, E extends UserException> R accept(AccountServiceCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUseTemplateCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentUseTemplateCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentUseTemplateCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentUseTemplateCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentUseTemplateCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentUseTemplateCommand)this.getTheObject()).sendResult();
    }

    
}
