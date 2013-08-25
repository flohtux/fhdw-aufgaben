
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public abstract class ExecuteException extends model.UserException{
    
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            
        }
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public ExecuteException(String message) throws persistence.PersistenceException {
        super(message);        
    }
    
    static public long getTypeId() {
        return -212;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    abstract public void accept(ExecuteExceptionVisitor visitor) throws PersistenceException;
    abstract public <R> R accept(ExecuteExceptionReturnVisitor<R>  visitor) throws PersistenceException;
    abstract public <E extends UserException>  void accept(ExecuteExceptionExceptionVisitor<E> visitor) throws PersistenceException, E;
    abstract public <R, E extends UserException> R accept(ExecuteExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
