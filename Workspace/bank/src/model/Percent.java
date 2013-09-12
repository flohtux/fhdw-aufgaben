
package model;

import common.Fraction;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ObsInterface;
import persistence.PercentProxi;
import persistence.PersistenceException;
import persistence.PersistentObject;
import persistence.PersistentPercent;
import persistence.PersistentProxi;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class Percent extends PersistentObject implements PersistentPercent{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentPercent getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().thePercentFacade.getClass(objectId);
        return (PersistentPercent)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentPercent createPercent(common.Fraction value) throws PersistenceException{
        return createPercent(value,false);
    }
    
    public static PersistentPercent createPercent(common.Fraction value,boolean delayed$Persistence) throws PersistenceException {
        PersistentPercent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().thePercentFacade
                .newDelayedPercent(value);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().thePercentFacade
                .newPercent(value,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("value", value);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentPercent createPercent(common.Fraction value,boolean delayed$Persistence,PersistentPercent This) throws PersistenceException {
        PersistentPercent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().thePercentFacade
                .newDelayedPercent(value);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().thePercentFacade
                .newPercent(value,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("value", value);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("value", this.getValue().toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Percent provideCopy() throws PersistenceException{
        Percent result = this;
        result = new Percent(this.value, 
                             this.subService, 
                             this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected common.Fraction value;
    protected SubjInterface subService;
    protected PersistentPercent This;
    
    public Percent(common.Fraction value,SubjInterface subService,PersistentPercent This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.value = value;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 112;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 112) ConnectionHandler.getTheConnectionHandler().thePercentFacade
            .newPercent(value,this.getId());
        super.store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().thePercentFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().thePercentFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public common.Fraction getValue() throws PersistenceException {
        return this.value;
    }
    public void setValue(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().thePercentFacade.valueSet(this.getId(), newValue);
        this.value = newValue;
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thePercentFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentPercent newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentPercent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thePercentFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentPercent getThis() throws PersistenceException {
        if(this.This == null){
            PersistentPercent result = new PercentProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentPercent)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handlePercent(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePercent(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePercent(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePercent(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePercent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePercent(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePercent(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePercent(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentPercent)This);
		if(this.equals(This)){
			this.setValue((common.Fraction)final$$Fields.get("value"));
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void changeValue(final common.Fraction value) 
				throws model.NoValidPercentValueException, PersistenceException{
    	if(Fraction.Null.greater(value) || value.greater(new Fraction(100, 1))) {
    		throw new NoValidPercentValueException();
    	}
    	getThis().setValue(value.divide(new Fraction(100, 1)));
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
