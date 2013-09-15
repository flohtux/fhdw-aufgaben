
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class ChangeSubjectCommand extends PersistentObject implements PersistentChangeSubjectCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentChangeSubjectCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade.getClass(objectId);
        return (PersistentChangeSubjectCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentChangeSubjectCommand createChangeSubjectCommand(String subject,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createChangeSubjectCommand(subject,createDate,commitDate,false);
    }
    
    public static PersistentChangeSubjectCommand createChangeSubjectCommand(String subject,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (subject == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentChangeSubjectCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade
                .newDelayedChangeSubjectCommand(subject);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade
                .newChangeSubjectCommand(subject,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected PersistentDebitTransfer trans;
    protected String subject;
    protected Invoker invoker;
    protected PersistentAccount commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public ChangeSubjectCommand(PersistentDebitTransfer trans,String subject,Invoker invoker,PersistentAccount commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.trans = trans;
        this.subject = subject;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 253;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 253) ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade
            .newChangeSubjectCommand(subject,this.getId());
        super.store();
        if(this.getTrans() != null){
            this.getTrans().store();
            ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade.transSet(this.getId(), getTrans());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public PersistentDebitTransfer getTrans() throws PersistenceException {
        return this.trans;
    }
    public void setTrans(PersistentDebitTransfer newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.trans)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.trans = (PersistentDebitTransfer)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade.transSet(this.getId(), newValue);
        }
    }
    public String getSubject() throws PersistenceException {
        return this.subject;
    }
    public void setSubject(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade.subjectSet(this.getId(), newValue);
        this.subject = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentAccount getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade.commandReceiverSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theChangeSubjectCommandFacade.myCommonDateSet(this.getId(), newValue);
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getTrans() != null) return 1;
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
        this.getCommandReceiver().changeSubject(this.getTrans(), this.getSubject());
		
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
