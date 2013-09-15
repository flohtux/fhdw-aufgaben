package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentChangeSubjectCommand extends AccountCommand, Anything, PersistentCommonDate, AbstractPersistentProxi {
    
    public PersistentDebitTransfer getTrans() throws PersistenceException ;
    public void setTrans(PersistentDebitTransfer newValue) throws PersistenceException ;
    public String getSubject() throws PersistenceException ;
    public void setSubject(String newValue) throws PersistenceException ;
    public Invoker getInvoker() throws PersistenceException ;
    public void setInvoker(Invoker newValue) throws PersistenceException ;
    public PersistentAccount getCommandReceiver() throws PersistenceException ;
    public void setCommandReceiver(PersistentAccount newValue) throws PersistenceException ;
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
    public void accept(AccountCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AccountCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AccountCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void checkException() 
				throws UserException, PersistenceException;
    public void execute() 
				throws PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;

}

