package persistence;

import model.UserException;
import model.visitor.CommandExceptionVisitor;
import model.visitor.CommandReturnExceptionVisitor;
import model.visitor.CommandReturnVisitor;
import model.visitor.CommandVisitor;


/* Additional import section end */

public interface Command extends AbstractPersistentProxi {
    
    public void checkException() 
				throws UserException, PersistenceException;
    public void execute() 
				throws PersistenceException;
    public Invoker fetchInvoker() 
				throws PersistenceException;
    public void sendException(final PersistenceException exception) 
				throws PersistenceException;
    public void sendResult() 
				throws PersistenceException;

    public void accept(CommandVisitor visitor) throws PersistenceException;
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

