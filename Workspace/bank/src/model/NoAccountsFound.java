
package model;

import static serverConstants.ExceptionMessages.NoAccountsFoundMessage;
import model.visitor.UserExceptionExceptionVisitor;
import model.visitor.UserExceptionReturnExceptionVisitor;
import model.visitor.UserExceptionReturnVisitor;
import model.visitor.UserExceptionVisitor;
import persistence.PersistenceException;
import persistence.TDObserver;


/* Additional import section end */

@SuppressWarnings("serial")
public class NoAccountsFound extends model.UserException{
    
    
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
    
    public NoAccountsFound(String message) throws persistence.PersistenceException {
        super(message);        
    }
    
    static public long getTypeId() {
        return -188;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws PersistenceException {
        visitor.handleNoAccountsFound(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoAccountsFound(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoAccountsFound(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoAccountsFound(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    public NoAccountsFound() throws PersistenceException {
		this(NoAccountsFoundMessage);
	}
    /* End of protected part that is not overridden by persistence generator */
    
}
