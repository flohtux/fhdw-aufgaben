package persistence;

import model.UserException;

import model.visitor.*;

public class CreateDebitGrantCommandProxi extends PersistentProxi implements PersistentCreateDebitGrantCommand{
    
    public CreateDebitGrantCommandProxi(long objectId) {
        super(objectId);
    }
    public CreateDebitGrantCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreateDebitGrantCommandFacade
            .getCreateDebitGrantCommand(this.getId());
    }
    
    public long getClassId() {
        return 198;
    }
    
    public long getReceiverBankNumber() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getReceiverBankNumber();
    }
    public void setReceiverBankNumber(long newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setReceiverBankNumber(newValue);
    }
    public long getReceiverAccNumber() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getReceiverAccNumber();
    }
    public void setReceiverAccNumber(long newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setReceiverAccNumber(newValue);
    }
    public String getLimitType() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getLimitType();
    }
    public void setLimitType(String newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setLimitType(newValue);
    }
    public common.Fraction getAmount() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setAmount(newValue);
    }
    public String getCur() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getCur();
    }
    public void setCur(String newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setCur(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentAccountService getCommandReceiver() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentAccountService newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).setCommitDate(newValue);
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
    
    
    public void checkException() 
				throws UserException, PersistenceException{
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentCreateDebitGrantCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentCreateDebitGrantCommand)this.getTheObject()).sendResult();
    }

    
}
