
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class CreateDebitGrantCommand extends PersistentObject implements PersistentCreateDebitGrantCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCreateDebitGrantCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.getClass(objectId);
        return (PersistentCreateDebitGrantCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCreateDebitGrantCommand createCreateDebitGrantCommand(long receiverBankNumber,long receiverAccNumber,String limitType,common.Fraction amount,String cur,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createCreateDebitGrantCommand(receiverBankNumber,receiverAccNumber,limitType,amount,cur,createDate,commitDate,false);
    }
    
    public static PersistentCreateDebitGrantCommand createCreateDebitGrantCommand(long receiverBankNumber,long receiverAccNumber,String limitType,common.Fraction amount,String cur,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (limitType == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (cur == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentCreateDebitGrantCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade
                .newDelayedCreateDebitGrantCommand(receiverBankNumber,receiverAccNumber,limitType,amount,cur);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade
                .newCreateDebitGrantCommand(receiverBankNumber,receiverAccNumber,limitType,amount,cur,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentDebitGrantListe debitGrantList;
    protected long receiverBankNumber;
    protected long receiverAccNumber;
    protected String limitType;
    protected common.Fraction amount;
    protected String cur;
    protected Invoker invoker;
    protected PersistentAccountService commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public CreateDebitGrantCommand(PersistentDebitGrantListe debitGrantList,long receiverBankNumber,long receiverAccNumber,String limitType,common.Fraction amount,String cur,Invoker invoker,PersistentAccountService commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.debitGrantList = debitGrantList;
        this.receiverBankNumber = receiverBankNumber;
        this.receiverAccNumber = receiverAccNumber;
        this.limitType = limitType;
        this.amount = amount;
        this.cur = cur;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 198;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 198) ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade
            .newCreateDebitGrantCommand(receiverBankNumber,receiverAccNumber,limitType,amount,cur,this.getId());
        super.store();
        if(this.getDebitGrantList() != null){
            this.getDebitGrantList().store();
            ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.debitGrantListSet(this.getId(), getDebitGrantList());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentDebitGrantListe getDebitGrantList() throws PersistenceException {
        return this.debitGrantList;
    }
    public void setDebitGrantList(PersistentDebitGrantListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.debitGrantList)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.debitGrantList = (PersistentDebitGrantListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.debitGrantListSet(this.getId(), newValue);
        }
    }
    public long getReceiverBankNumber() throws PersistenceException {
        return this.receiverBankNumber;
    }
    public void setReceiverBankNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.receiverBankNumberSet(this.getId(), newValue);
        this.receiverBankNumber = newValue;
    }
    public long getReceiverAccNumber() throws PersistenceException {
        return this.receiverAccNumber;
    }
    public void setReceiverAccNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.receiverAccNumberSet(this.getId(), newValue);
        this.receiverAccNumber = newValue;
    }
    public String getLimitType() throws PersistenceException {
        return this.limitType;
    }
    public void setLimitType(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.limitTypeSet(this.getId(), newValue);
        this.limitType = newValue;
    }
    public common.Fraction getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.amountSet(this.getId(), newValue);
        this.amount = newValue;
    }
    public String getCur() throws PersistenceException {
        return this.cur;
    }
    public void setCur(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.curSet(this.getId(), newValue);
        this.cur = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.invokerSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade.myCommonDateSet(this.getId(), newValue);
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
        visitor.handleCreateDebitGrantCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateDebitGrantCommand(this);
    }
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCreateDebitGrantCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateDebitGrantCommand(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateDebitGrantCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateDebitGrantCommand(this);
    }
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public void accept(AccountServiceCommandVisitor visitor) throws PersistenceException {
        visitor.handleCreateDebitGrantCommand(this);
    }
    public <R> R accept(AccountServiceCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public <E extends UserException>  void accept(AccountServiceCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCreateDebitGrantCommand(this);
    }
    public <R, E extends UserException> R accept(AccountServiceCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCreateDebitGrantCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getDebitGrantList() != null) return 1;
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
			this.getCommandReceiver().createDebitGrant(this.getDebitGrantList(), this.getReceiverBankNumber(), this.getReceiverAccNumber(), this.getLimitType(), this.getAmount(), this.getCur());
		}
		catch(model.InvalidBankNumberException e){
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
