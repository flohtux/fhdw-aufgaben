package persistence;

import model.UserException;

import model.visitor.*;

public class ChangeSubjectCommandProxi extends PersistentProxi implements PersistentChangeSubjectCommand{
    
    public ChangeSubjectCommandProxi(long objectId) {
        super(objectId);
    }
    public ChangeSubjectCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade
            .getChangeSubjectCommand(this.getId());
    }
    
    public long getClassId() {
        return 253;
    }
    
    public PersistentDebitTransfer getTrans() throws PersistenceException {
        return ((PersistentChangeSubjectCommand)this.getTheObject()).getTrans();
    }
    public void setTrans(PersistentDebitTransfer newValue) throws PersistenceException {
        ((PersistentChangeSubjectCommand)this.getTheObject()).setTrans(newValue);
    }
    public String getSubject() throws PersistenceException {
        return ((PersistentChangeSubjectCommand)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws PersistenceException {
        ((PersistentChangeSubjectCommand)this.getTheObject()).setSubject(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentChangeSubjectCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentChangeSubjectCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAccount getCommandReceiver() throws PersistenceException {
        return ((PersistentChangeSubjectCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentChangeSubjectCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentChangeSubjectCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentChangeSubjectCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentChangeSubjectCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeSubjectCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentChangeSubjectCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeSubjectCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleChangeSubjectCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeSubjectCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeSubjectCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeSubjectCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleChangeSubjectCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeSubjectCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeSubjectCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeSubjectCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeSubjectCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeSubjectCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeSubjectCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeSubjectCommand(this);
    }
    public void accept(AccountCommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeSubjectCommand(this);
    }
    public <R> R accept(AccountCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeSubjectCommand(this);
    }
    public <E extends UserException>  void accept(AccountCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeSubjectCommand(this);
    }
    public <R, E extends UserException> R accept(AccountCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeSubjectCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentChangeSubjectCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentChangeSubjectCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentChangeSubjectCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentChangeSubjectCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentChangeSubjectCommand)this.getTheObject()).sendResult();
    }

    
}
