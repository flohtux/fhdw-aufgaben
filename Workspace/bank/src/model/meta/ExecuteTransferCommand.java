
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class ExecuteTransferCommand extends PersistentObject implements PersistentExecuteTransferCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentExecuteTransferCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade.getClass(objectId);
        return (PersistentExecuteTransferCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentExecuteTransferCommand createExecuteTransferCommand(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createExecuteTransferCommand(createDate,commitDate,false);
    }
    
    public static PersistentExecuteTransferCommand createExecuteTransferCommand(java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        PersistentExecuteTransferCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade
                .newDelayedExecuteTransferCommand();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade
                .newExecuteTransferCommand(-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentDebitTransferTransaction debitTransfer;
    protected Invoker invoker;
    protected PersistentAccountService commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public ExecuteTransferCommand(PersistentDebitTransferTransaction debitTransfer,Invoker invoker,PersistentAccountService commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.debitTransfer = debitTransfer;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 184;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 184) ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade
            .newExecuteTransferCommand(this.getId());
        super.store();
        if(this.getDebitTransfer() != null){
            this.getDebitTransfer().store();
            ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade.debitTransferSet(this.getId(), getDebitTransfer());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentDebitTransferTransaction getDebitTransfer() throws PersistenceException {
        return this.debitTransfer;
    }
    public void setDebitTransfer(PersistentDebitTransferTransaction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.debitTransfer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.debitTransfer = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade.debitTransferSet(this.getId(), newValue);
        }
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
            ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentAccountService getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentAccountService newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentAccountService)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theExecuteTransferCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleExecuteTransferCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteTransferCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteTransferCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteTransferCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleExecuteTransferCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteTransferCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteTransferCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteTransferCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleExecuteTransferCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteTransferCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteTransferCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteTransferCommand(this);
    }
    public void accept(AccountServiceCommandVisitor visitor) throws PersistenceException {
        visitor.handleExecuteTransferCommand(this);
    }
    public <R> R accept(AccountServiceCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecuteTransferCommand(this);
    }
    public <E extends UserException>  void accept(AccountServiceCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecuteTransferCommand(this);
    }
    public <R, E extends UserException> R accept(AccountServiceCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecuteTransferCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getDebitTransfer() != null) return 1;
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
			this.getCommandReceiver().executeTransfer(this.getDebitTransfer());
		}
		catch(model.NoPermissionToExecuteDebitTransferException e){
			this.commandException = e;
		}
		catch(model.InvalidBankNumberException e){
			this.commandException = e;
		}
		catch(model.LimitViolatedException e){
			this.commandException = e;
		}
		catch(model.InvalidAccountNumberException e){
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
