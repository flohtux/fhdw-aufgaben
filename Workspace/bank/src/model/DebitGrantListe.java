
package model;

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
import persistence.DebitGrantListeProxi;
import persistence.DebitGrantListe_DebitGrantsProxi;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAccountPx;
import persistence.PersistentDebitGrant;
import persistence.PersistentDebitGrantListe;
import persistence.PersistentLimitType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class DebitGrantListe extends PersistentObject implements PersistentDebitGrantListe{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitGrantListe getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade.getClass(objectId);
        return (PersistentDebitGrantListe)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentDebitGrantListe createDebitGrantListe() throws PersistenceException{
        return createDebitGrantListe(false);
    }
    
    public static PersistentDebitGrantListe createDebitGrantListe(boolean delayed$Persistence) throws PersistenceException {
        PersistentDebitGrantListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade
                .newDelayedDebitGrantListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade
                .newDebitGrantListe(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentDebitGrantListe createDebitGrantListe(boolean delayed$Persistence,PersistentDebitGrantListe This) throws PersistenceException {
        PersistentDebitGrantListe result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade
                .newDelayedDebitGrantListe();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade
                .newDebitGrantListe(-1);
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
            result.put("debitGrants", this.getDebitGrants().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public DebitGrantListe provideCopy() throws PersistenceException{
        DebitGrantListe result = this;
        result = new DebitGrantListe(this.subService, 
                                     this.This, 
                                     this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected DebitGrantListe_DebitGrantsProxi debitGrants;
    protected SubjInterface subService;
    protected PersistentDebitGrantListe This;
    
    public DebitGrantListe(SubjInterface subService,PersistentDebitGrantListe This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.debitGrants = new DebitGrantListe_DebitGrantsProxi(this);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 202;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 202) ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade
            .newDebitGrantListe(this.getId());
        super.store();
        this.getDebitGrants().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public DebitGrantListe_DebitGrantsProxi getDebitGrants() throws PersistenceException {
        return this.debitGrants;
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
            ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitGrantListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitGrantListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitGrantListeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentDebitGrantListe getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDebitGrantListe result = new DebitGrantListeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentDebitGrantListe)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrantListe(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrantListe(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrantListe(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrantListe(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrantListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrantListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrantListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrantListe(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getDebitGrants().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void createDebitGrant(final PersistentAccountPx receiver, final PersistentLimitType limit) 
				throws model.GrantAlreadyGivenException, PersistenceException{
        model.meta.DebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg event = new model.meta.DebitGrantListeCreateDebitGrantAccountPxLimitTypeMssg(receiver, limit, getThis());
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
        this.setThis((PersistentDebitGrantListe)This);
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
    public void remove(final PersistentAccountPx acc) 
				throws PersistenceException{
        model.meta.DebitGrantListeRemoveAccountPxMssg event = new model.meta.DebitGrantListeRemoveAccountPxMssg(acc, getThis());
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
    
    public void checkGrantGiven(final PersistentAccountPx acc) 
				throws model.GrantAlreadyGivenException, PersistenceException{
    	PersistentDebitGrant result = getThis().getDebitGrants().findFirst(new Predcate<PersistentDebitGrant>() {
			@Override
			public boolean test(PersistentDebitGrant argument)
					throws PersistenceException {
				return argument.getPermittedAccount().getAccount().equals(acc.getAccount());
			}
		});
    	if(result != null) {
    		throw new GrantAlreadyGivenException();
    	}
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void createDebitGrantImplementation(final PersistentAccountPx receiver, final PersistentLimitType limit) 
				throws model.GrantAlreadyGivenException, PersistenceException{
        getThis().checkGrantGiven(receiver);
    	PersistentDebitGrant debitGrant = DebitGrant.createDebitGrant(receiver, limit);
        getThis().getDebitGrants().add(debitGrant);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    public void removeImplementation(final PersistentAccountPx acc) 
				throws PersistenceException{
        getThis().getDebitGrants().removeFirstSuccess(new Predcate<PersistentDebitGrant>() {
			@Override
			public boolean test(PersistentDebitGrant argument)
					throws PersistenceException {
				return argument.getPermittedAccount().getAccount().equals(acc.getAccount());
			}
		});
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
