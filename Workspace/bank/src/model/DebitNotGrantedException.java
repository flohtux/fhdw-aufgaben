
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class DebitNotGrantedException extends model.DebitException{
    
    
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
    
    public DebitNotGrantedException(String message) throws persistence.PersistenceException {
        super(message);        
    }
    
    static public long getTypeId() {
        return -192;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(DebitExceptionVisitor visitor) throws PersistenceException {
        visitor.handleDebitNotGrantedException(this);
    }
    public <R> R accept(DebitExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitNotGrantedException(this);
    }
    public <E extends UserException>  void accept(DebitExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitNotGrantedException(this);
    }
    public <R, E extends UserException> R accept(DebitExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitNotGrantedException(this);
    }
    public void accept(UserExceptionVisitor visitor) throws PersistenceException {
        visitor.handleDebitNotGrantedException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitNotGrantedException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitNotGrantedException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitNotGrantedException(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    public DebitNotGrantedException() throws PersistenceException{
		this(serverConstants.ExceptionMessages.DebitNotGrantedMessage);
	}

    /* End of protected part that is not overridden by persistence generator */
    
}
