package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCreateDebitGrantCommand extends AccountServiceCommand, Anything, PersistentCommonDate, AbstractPersistentProxi {
    
    public PersistentDebitGrantListe getDebitGrantList() throws PersistenceException ;
    public void setDebitGrantList(PersistentDebitGrantListe newValue) throws PersistenceException ;
    public long getReceiverBankNumber() throws PersistenceException ;
    public void setReceiverBankNumber(long newValue) throws PersistenceException ;
    public long getReceiverAccNumber() throws PersistenceException ;
    public void setReceiverAccNumber(long newValue) throws PersistenceException ;
    public String getLimitType() throws PersistenceException ;
    public void setLimitType(String newValue) throws PersistenceException ;
    public common.Fraction getAmount() throws PersistenceException ;
    public void setAmount(common.Fraction newValue) throws PersistenceException ;
    public String getCur() throws PersistenceException ;
    public void setCur(String newValue) throws PersistenceException ;
    public Invoker getInvoker() throws PersistenceException ;
    public void setInvoker(Invoker newValue) throws PersistenceException ;
    public PersistentAccountService getCommandReceiver() throws PersistenceException ;
    public void setCommandReceiver(PersistentAccountService newValue) throws PersistenceException ;
    public PersistentCommonDate getMyCommonDate() throws PersistenceException ;
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException ;
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException;
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(CommandVisitor visitor) throws PersistenceException;
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AccountServiceCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountServiceCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AccountServiceCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AccountServiceCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void checkException() 
				throws UserException, PersistenceException;
    public void execute() 
				throws PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;

}

