package persistence;

import model.UserException;

import model.visitor.*;

public class AddComponentCommandICProxi extends PersistentInCacheProxi implements PersistentAddComponentCommand{
    
    public AddComponentCommandICProxi(long objectId) {
        super(objectId);
    }
    public AddComponentCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade
            .getAddComponentCommand(this.getId());
    }
    
    public long getClassId() {
        return 110;
    }
    
    public PersistentProduct getProduct() throws PersistenceException {
        return ((PersistentAddComponentCommand)this.getTheObject()).getProduct();
    }
    public void setProduct(PersistentProduct newValue) throws PersistenceException {
        ((PersistentAddComponentCommand)this.getTheObject()).setProduct(newValue);
    }
    public PersistentComponent getNewPart() throws PersistenceException {
        return ((PersistentAddComponentCommand)this.getTheObject()).getNewPart();
    }
    public void setNewPart(PersistentComponent newValue) throws PersistenceException {
        ((PersistentAddComponentCommand)this.getTheObject()).setNewPart(newValue);
    }
    public long getAmount() throws PersistenceException {
        return ((PersistentAddComponentCommand)this.getTheObject()).getAmount();
    }
    public void setAmount(long newValue) throws PersistenceException {
        ((PersistentAddComponentCommand)this.getTheObject()).setAmount(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentAddComponentCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentAddComponentCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentPartsListManager getCommandReceiver() throws PersistenceException {
        return ((PersistentAddComponentCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentPartsListManager newValue) throws PersistenceException {
        ((PersistentAddComponentCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentAddComponentCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentAddComponentCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentAddComponentCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddComponentCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentAddComponentCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentAddComponentCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleAddComponentCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddComponentCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddComponentCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddComponentCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAddComponentCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddComponentCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddComponentCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddComponentCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleAddComponentCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddComponentCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddComponentCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddComponentCommand(this);
    }
    public void accept(PartsListManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleAddComponentCommand(this);
    }
    public <R> R accept(PartsListManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAddComponentCommand(this);
    }
    public <E extends UserException>  void accept(PartsListManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAddComponentCommand(this);
    }
    public <R, E extends UserException> R accept(PartsListManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAddComponentCommand(this);
    }
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentAddComponentCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentAddComponentCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentAddComponentCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAddComponentCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentAddComponentCommand)this.getTheObject()).sendResult();
    }

    
}
