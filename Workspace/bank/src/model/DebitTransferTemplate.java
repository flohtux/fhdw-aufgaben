
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class DebitTransferTemplate extends PersistentObject implements PersistentDebitTransferTemplate{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitTransferTemplate getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade.getClass(objectId);
        return (PersistentDebitTransferTemplate)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentDebitTransferTemplate createDebitTransferTemplate() throws PersistenceException{
        return createDebitTransferTemplate(false);
    }
    
    public static PersistentDebitTransferTemplate createDebitTransferTemplate(boolean delayed$Persistence) throws PersistenceException {
        PersistentDebitTransferTemplate result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade
                .newDelayedDebitTransferTemplate();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade
                .newDebitTransferTemplate(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentDebitTransferTemplate createDebitTransferTemplate(boolean delayed$Persistence,PersistentDebitTransferTemplate This) throws PersistenceException {
        PersistentDebitTransferTemplate result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade
                .newDelayedDebitTransferTemplate();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade
                .newDebitTransferTemplate(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("templates", this.getTemplates().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public DebitTransferTemplate provideCopy() throws PersistenceException{
        DebitTransferTemplate result = this;
        result = new DebitTransferTemplate(this.subService, 
                                           this.This, 
                                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected DebitTransferTemplate_TemplatesProxi templates;
    protected SubjInterface subService;
    protected PersistentDebitTransferTemplate This;
    
    public DebitTransferTemplate(SubjInterface subService,PersistentDebitTransferTemplate This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.templates = new DebitTransferTemplate_TemplatesProxi(this);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 208;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 208) ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade
            .newDebitTransferTemplate(this.getId());
        super.store();
        this.getTemplates().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public DebitTransferTemplate_TemplatesProxi getTemplates() throws PersistenceException {
        return this.templates;
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
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitTransferTemplate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitTransferTemplate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTemplateFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentDebitTransferTemplate getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDebitTransferTemplate result = new DebitTransferTemplateProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentDebitTransferTemplate)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferTemplate(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferTemplate(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferTemplate(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferTemplate(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferTemplate(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferTemplate(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferTemplate(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferTemplate(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getTemplates().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
        model.meta.DebitTransferTemplateAddDebitTransferTransactionMssg event = new model.meta.DebitTransferTemplateAddDebitTransferTransactionMssg(debitTransferTransaction, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
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
        this.setThis((PersistentDebitTransferTemplate)This);
		if(this.equals(This)){
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
    public void remove(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
        model.meta.DebitTransferTemplateRemoveDebitTransferTransactionMssg event = new model.meta.DebitTransferTemplateRemoveDebitTransferTransactionMssg(debitTransferTransaction, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
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
    
    public void addImplementation(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
    	getThis().getTemplates().add(debitTransferTransaction);
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
    public void removeImplementation(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
        getThis().getTemplates().removeFirstSuccess(new Predcate<PersistentDebitTransferTransaction>() {
			@Override
			public boolean test(PersistentDebitTransferTransaction argument)
					throws PersistenceException {
				return argument.equals(debitTransferTransaction);
			}
		});
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
