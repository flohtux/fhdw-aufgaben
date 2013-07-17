
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class MateriallistValue extends PersistentObject implements PersistentMateriallistValue{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMateriallistValue getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade.getClass(objectId);
        return (PersistentMateriallistValue)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentMateriallistValue createMateriallistValue(PersistentMaterial material,long amount) throws PersistenceException{
        return createMateriallistValue(material,amount,false);
    }
    
    public static PersistentMateriallistValue createMateriallistValue(PersistentMaterial material,long amount,boolean delayed$Persistence) throws PersistenceException {
        PersistentMateriallistValue result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade
                .newDelayedMateriallistValue(amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade
                .newMateriallistValue(amount,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("material", material);
        final$$Fields.put("amount", amount);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMateriallistValue createMateriallistValue(PersistentMaterial material,long amount,boolean delayed$Persistence,PersistentMateriallistValue This) throws PersistenceException {
        PersistentMateriallistValue result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade
                .newDelayedMateriallistValue(amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade
                .newMateriallistValue(amount,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("material", material);
        final$$Fields.put("amount", amount);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot material = (AbstractPersistentRoot)this.getMaterial();
            if (material != null) {
                result.put("material", material.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    material.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && material.hasEssentialFields())material.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("amount", new Long(this.getAmount()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MateriallistValue provideCopy() throws PersistenceException{
        MateriallistValue result = this;
        result = new MateriallistValue(this.material, 
                                       this.amount, 
                                       this.This, 
                                       this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMaterial material;
    protected long amount;
    protected PersistentMateriallistValue This;
    
    public MateriallistValue(PersistentMaterial material,long amount,PersistentMateriallistValue This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.material = material;
        this.amount = amount;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 116) ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade
            .newMateriallistValue(amount,this.getId());
        super.store();
        if(this.getMaterial() != null){
            this.getMaterial().store();
            ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade.materialSet(this.getId(), getMaterial());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentMaterial getMaterial() throws PersistenceException {
        return this.material;
    }
    public void setMaterial(PersistentMaterial newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.material)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.material = (PersistentMaterial)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade.materialSet(this.getId(), newValue);
        }
    }
    public long getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade.amountSet(this.getId(), newValue);
        this.amount = newValue;
    }
    protected void setThis(PersistentMateriallistValue newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMateriallistValue)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMateriallistValueFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMateriallistValue getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMateriallistValue result = new MateriallistValueProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMateriallistValue)this.This;
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleMateriallistValue(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMateriallistValue(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMateriallistValue(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMateriallistValue(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMateriallistValue(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMateriallistValue(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMateriallistValue(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMateriallistValue(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMaterial() != null && this.getMaterial().getTheObject().getLeafInfo() != 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMateriallistValue)This);
		if(this.equals(This)){
			this.setMaterial((PersistentMaterial)final$$Fields.get("material"));
			this.setAmount((Long)final$$Fields.get("amount"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public /*INTERNAL*/ void run() {
				//Handle exception!
			}
		}).start();
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public void  /*INTERNAL*/  run() {
				try {
					try {
						command.checkException();
						//Handle result!
					} catch (model.UserException e) {
						//Handle user exception!
					}
				} catch (PersistenceException e) {
					//Handle fatal exception!
				}
			}
		}).start();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
