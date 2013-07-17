
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class CreateComponentCommand extends PersistentObject implements PersistentCreateComponentCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateComponentCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.getClass(objectId);
        return (PersistentCreateComponentCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateComponentCommand createCreateComponentCommand(String name,String componentType,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCreateComponentCommand(name,componentType,createDate,commitDate,false);
    }
    
    public static PersistentCreateComponentCommand createCreateComponentCommand(String name,String componentType,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (componentType == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateComponentCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade
                .newDelayedCreateComponentCommand(name,componentType);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade
                .newCreateComponentCommand(name,componentType,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String name;
    protected String componentType;
    protected Invoker invoker;
    protected PersistentPartsListManager commandReceiver;
    protected PersistentComponent commandResult;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateComponentCommand(String name,String componentType,Invoker invoker,PersistentPartsListManager commandReceiver,PersistentComponent commandResult,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.componentType = componentType;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.commandResult = commandResult;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 101;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 101) ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade
            .newCreateComponentCommand(name,componentType,this.getId());
        super.store();
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getCommandResult() != null){
            this.getCommandResult().store();
            ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.commandResultSet(this.getId(), getCommandResult());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public String getComponentType() throws PersistenceException {
        return this.componentType;
    }
    public void setComponentType(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.componentTypeSet(this.getId(), newValue);
        this.componentType = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.invokerSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentComponent getCommandResult() throws PersistenceException {
        return this.commandResult;
    }
    public void setCommandResult(PersistentComponent newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandResult)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandResult = (PersistentComponent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.commandResultSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateComponentCommandFacade.myCommonDateSet(this.getId(), newValue);
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getCommandReceiver() != null) return 1;
        if (this.getCommandResult() != null) return 1;
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
			this.setCommandResult(this.getCommandReceiver().createComponent(this.getName(), this.getComponentType()));
		}
		catch(model.DoubleDefinitionException e){
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
