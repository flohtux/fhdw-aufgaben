
package model;

import model.visitor.AccountSearchExceptionExceptionVisitor;
import model.visitor.AccountSearchExceptionReturnExceptionVisitor;
import model.visitor.AccountSearchExceptionReturnVisitor;
import model.visitor.AccountSearchExceptionVisitor;
import model.visitor.ExecuteExceptionExceptionVisitor;
import model.visitor.ExecuteExceptionReturnExceptionVisitor;
import model.visitor.ExecuteExceptionReturnVisitor;
import model.visitor.ExecuteExceptionVisitor;
import model.visitor.UserExceptionExceptionVisitor;
import model.visitor.UserExceptionReturnExceptionVisitor;
import model.visitor.UserExceptionReturnVisitor;
import model.visitor.UserExceptionVisitor;
import persistence.PersistenceException;
import persistence.TDObserver;


/* Additional import section end */

@SuppressWarnings("serial")
public class InvalidAccountNumberException extends model.AccountSearchException{
    
    
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
    
    public InvalidAccountNumberException(String message) throws persistence.PersistenceException {
        super(message);        
    }
    
    static public long getTypeId() {
        return -170;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(AccountSearchExceptionVisitor visitor) throws PersistenceException {
        visitor.handleInvalidAccountNumberException(this);
    }
    public <R> R accept(AccountSearchExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public <E extends UserException>  void accept(AccountSearchExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleInvalidAccountNumberException(this);
    }
    public <R, E extends UserException> R accept(AccountSearchExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public void accept(ExecuteExceptionVisitor visitor) throws PersistenceException {
        visitor.handleInvalidAccountNumberException(this);
    }
    public <R> R accept(ExecuteExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public <E extends UserException>  void accept(ExecuteExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleInvalidAccountNumberException(this);
    }
    public <R, E extends UserException> R accept(ExecuteExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public void accept(UserExceptionVisitor visitor) throws PersistenceException {
        visitor.handleInvalidAccountNumberException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleInvalidAccountNumberException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleInvalidAccountNumberException(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    public InvalidAccountNumberException(long accNum) throws PersistenceException {
		this(String.format(serverConstants.ExceptionMessages.InvalidAccountNumberMessage, accNum));
	}

    /* End of protected part that is not overridden by persistence generator */
    
}
