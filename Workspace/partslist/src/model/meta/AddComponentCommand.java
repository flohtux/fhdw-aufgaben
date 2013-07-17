
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class AddComponentCommand extends PersistentObject implements PersistentAddComponentCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAddComponentCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.getClass(objectId);
        return (PersistentAddComponentCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAddComponentCommand createAddComponentCommand(long amount,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createAddComponentCommand(amount,createDate,commitDate,false);
    }
    
    public static PersistentAddComponentCommand createAddComponentCommand(long amount,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentAddComponentCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade
                .newDelayedAddComponentCommand(amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade
                .newAddComponentCommand(amount,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentProduct product;
    protected PersistentComponent newPart;
    protected long amount;
    protected Invoker invoker;
    protected PersistentPartsListManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public AddComponentCommand(PersistentProduct product,PersistentComponent newPart,long amount,Invoker invoker,PersistentPartsListManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.product = product;
        this.newPart = newPart;
        this.amount = amount;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 110;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 110) ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade
            .newAddComponentCommand(amount,this.getId());
        super.store();
        if(this.getProduct() != null){
            this.getProduct().store();
            ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.productSet(this.getId(), getProduct());
        }
        if(this.getNewPart() != null){
            this.getNewPart().store();
            ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.newPartSet(this.getId(), getNewPart());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentProduct getProduct() throws PersistenceException {
        return this.product;
    }
    public void setProduct(PersistentProduct newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.product)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.product = (PersistentProduct)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.productSet(this.getId(), newValue);
        }
    }
    public PersistentComponent getNewPart() throws PersistenceException {
        return this.newPart;
    }
    public void setNewPart(PersistentComponent newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.newPart)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.newPart = (PersistentComponent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.newPartSet(this.getId(), newValue);
        }
    }
    public long getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.amountSet(this.getId(), newValue);
        this.amount = newValue;
    }
    public Invoker getInvoker() throws PersistenceException {
        return this.invoker;
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.invoker)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.invoker = (Invoker)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentPartsListManager getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentPartsListManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentPartsListManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return this.myCommonDate;
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.myCommonDate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAddComponentCommandFacade.myCommonDateSet(this.getId(), newValue);
        }
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return this.getMyCommonDate().getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        this.getMyCommonDate().setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return this.getMyCommonDate().getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        this.getMyCommonDate().setCommitDate(newValue);
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCommonDate().delete$Me();
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getProduct() != null) return 1;
        if (this.getNewPart() != null) return 1;
        if (this.getCommandReceiver() != null) return 1;
        return 0;
    }
    
    
    
    
    // Start of section that contains operations that must be implemented.
    
    public void checkException() 
				throws UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void execute() 
				throws PersistenceException{
        try{
			this.getCommandReceiver().addComponent(this.getProduct(), this.getNewPart(), this.getAmount());
		}
		catch(model.CycleException e){
			this.commandException = e;
		}
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
