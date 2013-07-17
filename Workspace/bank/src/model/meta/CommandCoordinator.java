
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class CommandCoordinator extends PersistentObject implements PersistentCommandCoordinator{
    
    private static PersistentCommandCoordinator theCommandCoordinator = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentCommandCoordinator getTheCommandCoordinator() throws PersistenceException{
        if (theCommandCoordinator == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        CommandCoordinatorProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theCommandCoordinatorFacade.getTheCommandCoordinator();
                            theCommandCoordinator = proxi;
                        }
                        if(proxi.getId() < 0) {
                            proxi.setId(proxi.getId() * -1);
                            proxi.initialize(proxi, new java.util.HashMap<String,Object>());
                            proxi.initializeOnCreation();
                        }
                    } catch (PersistenceException e){
                        exception = e;
                    }
                    synchronized ($$lock){$$lock.notify();}
                }
                PersistentCommandCoordinator getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theCommandCoordinator;
                }
            }
            synchronized ($$lock) {
                reset$For$Test = false;
                Initializer initializer = new Initializer();
                new Thread(initializer).start();
                try {$$lock.wait();}catch (InterruptedException e) {} //Need not to be interrupted
                return initializer.getResult();
            }
        }
        return theCommandCoordinator;
    }
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CommandCoordinator_ExecuterProxi executer;
    
    public CommandCoordinator(long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.executer = new CommandCoordinator_ExecuterProxi(this);        
    }
    
    static public long getTypeId() {
        return -117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public CommandCoordinator_ExecuterProxi getExecuter() throws PersistenceException {
        return this.executer;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCommandCoordinator(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommandCoordinator(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommandCoordinator(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommandCoordinator(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void coordinate(final Command command) 
				throws PersistenceException{
        if (!this.getExecuter().iterator().hasNext()){
			PersistentCommandExecuter executer = CommandExecuter.createCommandExecuter();
			this.getExecuter().add(executer);
			
		}
		((PersistentCommandExecuter)this.getExecuter().iterator().next()).commandPut(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        this.initializeOnInstantiation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
