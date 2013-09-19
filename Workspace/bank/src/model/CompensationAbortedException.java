
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class CompensationAbortedException extends model.UserException{
    
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot compensation = (AbstractPersistentRoot)this.getCompensation();
            if (compensation != null) {
                result.put("compensation", compensation.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    compensation.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && compensation.hasEssentialFields())compensation.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            
        }
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentCompensation compensation;
    
    public CompensationAbortedException(String message, PersistentCompensation compensation) throws persistence.PersistenceException {
        super(message);
        this.compensation = compensation;        
    }
    
    static public long getTypeId() {
        return -267;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentCompensation getCompensation(){
        return this.compensation;
    }
    public void setCompensation(PersistentCompensation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.compensation)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.compensation = (PersistentCompensation)PersistentProxi.createProxi(objectId, classId);
    }
    
    public void accept(UserExceptionVisitor visitor) throws PersistenceException {
        visitor.handleCompensationAbortedException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationAbortedException(this);
    }
    public <E extends UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationAbortedException(this);
    }
    public <R, E extends UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationAbortedException(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getCompensation() != null) return 1;
        return 0;
    }
    
    
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    public CompensationAbortedException(PersistentCompensation object, String reason) throws PersistenceException {
    	this(viewConstants.ExceptionConstants.CompensationAbortedMessage + reason, object);
    }
    /* End of protected part that is not overridden by persistence generator */
    
}
