
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class CreateBankCommand extends PersistentObject implements PersistentCreateBankCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateBankCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade.getClass(objectId);
        return (PersistentCreateBankCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateBankCommand createCreateBankCommand(String name,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCreateBankCommand(name,createDate,commitDate,false);
    }
    
    public static PersistentCreateBankCommand createCreateBankCommand(String name,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateBankCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade
                .newDelayedCreateBankCommand(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade
                .newCreateBankCommand(name,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String name;
    protected Invoker invoker;
    protected PersistentBankCreator commandReceiver;
    protected PersistentBank commandResult;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateBankCommand(String name,Invoker invoker,PersistentBankCreator commandReceiver,PersistentBank commandResult,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.commandResult = commandResult;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 125;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 125) ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade
            .newCreateBankCommand(name,this.getId());
        super.store();
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getCommandResult() != null){
            this.getCommandResult().store();
            ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade.commandResultSet(this.getId(), getCommandResult());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentBankCreator getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentBankCreator newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentBankCreator)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentBank getCommandResult() throws PersistenceException {
        return this.commandResult;
    }
    public void setCommandResult(PersistentBank newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandResult)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandResult = (PersistentBank)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade.commandResultSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateBankCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        this.setCommandResult(this.getCommandReceiver().createBank(this.getName()));
		
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
