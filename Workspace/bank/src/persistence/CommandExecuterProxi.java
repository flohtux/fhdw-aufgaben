package persistence;

import model.UserException;

import model.visitor.*;

public class CommandExecuterProxi extends PersistentProxi implements PersistentCommandExecuter{
    
    public CommandExecuterProxi(long objectId) {
        super(objectId);
    }
    public CommandExecuterProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
            .getCommandExecuter(this.getId());
    }
    
    public long getClassId() {
        return -145;
    }
    
    public CommandExecuter_CommandsProxi getCommands() throws PersistenceException {
        return ((PersistentCommandExecuter)this.getTheObject()).getCommands();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCommandExecuter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommandExecuter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommandExecuter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommandExecuter(this);
    }
    
    
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).initialize(This, final$$Fields);
    }
    public Command commandGet() 
				throws PersistenceException{
        return ((PersistentCommandExecuter)this.getTheObject()).commandGet();
    }
    public void commandPut(Command command) 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).commandPut(command);
    }
    public void finishCommand(CommitConnectionHandler handler) 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).finishCommand(handler);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).initializeOnInstantiation();
    }
    public void run() {
        try{
            ((PersistentCommandExecuter)this.getTheObject()).run();
        }catch(PersistenceException pe){
            throw new PersistenceError(pe);
        }
    }
    public void start() 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).start();
    }

    
}
