package persistence;

import model.UserException;

import model.visitor.*;

public class ChangeNameCommandICProxi extends PersistentInCacheProxi implements PersistentChangeNameCommand{
    
    public ChangeNameCommandICProxi(long objectId) {
        super(objectId);
    }
    public ChangeNameCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theChangeNameCommandFacade
            .getChangeNameCommand(this.getId());
    }
    
    public long getClassId() {
        return 103;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentChangeNameCommand)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentChangeNameCommand)this.getTheObject()).setName(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentChangeNameCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentChangeNameCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentBank getCommandReceiver() throws PersistenceException {
        return ((PersistentChangeNameCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentBank newValue) throws PersistenceException {
        ((PersistentChangeNameCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentChangeNameCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentChangeNameCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentChangeNameCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeNameCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentChangeNameCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentChangeNameCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleChangeNameCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeNameCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeNameCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeNameCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleChangeNameCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeNameCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeNameCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeNameCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeNameCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeNameCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeNameCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeNameCommand(this);
    }
    public void accept(BankCommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeNameCommand(this);
    }
    public <R> R accept(BankCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeNameCommand(this);
    }
    public <E extends UserException>  void accept(BankCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeNameCommand(this);
    }
    public <R, E extends UserException> R accept(BankCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeNameCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentChangeNameCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentChangeNameCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentChangeNameCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(PersistenceException exception) 
				throws PersistenceException{
        ((PersistentChangeNameCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentChangeNameCommand)this.getTheObject()).sendResult();
    }

    
}
