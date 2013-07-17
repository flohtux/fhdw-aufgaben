package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentCommandExecuter extends Runnable, Anything, AbstractPersistentProxi {
    
    public CommandExecuter_CommandsProxi getCommands() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public Command commandGet() 
				throws PersistenceException;
    public void commandPut(final Command command) 
				throws PersistenceException;
    public void finishCommand(final CommitConnectionHandler handler) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void run() ;
    public void start() 
				throws PersistenceException;

}

