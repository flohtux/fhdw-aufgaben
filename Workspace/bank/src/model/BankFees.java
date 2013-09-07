
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.BankFeesProxi;
import persistence.ConnectionHandler;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentBankFees;
import persistence.PersistentInternalFee;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentTransactionFee;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class BankFees extends PersistentObject implements PersistentBankFees{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentBankFees getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theBankFeesFacade.getClass(objectId);
        return (PersistentBankFees)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentBankFees createBankFees(PersistentTransactionFee fee,PersistentInternalFee internalFee) throws PersistenceException{
        return createBankFees(fee,internalFee,false);
    }
    
    public static PersistentBankFees createBankFees(PersistentTransactionFee fee,PersistentInternalFee internalFee,boolean delayed$Persistence) throws PersistenceException {
        PersistentBankFees result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBankFeesFacade
                .newDelayedBankFees();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBankFeesFacade
                .newBankFees(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("fee", fee);
        final$$Fields.put("internalFee", internalFee);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentBankFees createBankFees(PersistentTransactionFee fee,PersistentInternalFee internalFee,boolean delayed$Persistence,PersistentBankFees This) throws PersistenceException {
        PersistentBankFees result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theBankFeesFacade
                .newDelayedBankFees();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theBankFeesFacade
                .newBankFees(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("fee", fee);
        final$$Fields.put("internalFee", internalFee);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot fee = (AbstractPersistentRoot)this.getFee();
            if (fee != null) {
                result.put("fee", fee.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    fee.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && fee.hasEssentialFields())fee.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot internalFee = (AbstractPersistentRoot)this.getInternalFee();
            if (internalFee != null) {
                result.put("internalFee", internalFee.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    internalFee.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && internalFee.hasEssentialFields())internalFee.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public BankFees provideCopy() throws PersistenceException{
        BankFees result = this;
        result = new BankFees(this.fee, 
                              this.internalFee, 
                              this.subService, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentTransactionFee fee;
    protected PersistentInternalFee internalFee;
    protected SubjInterface subService;
    protected PersistentBankFees This;
    
    public BankFees(PersistentTransactionFee fee,PersistentInternalFee internalFee,SubjInterface subService,PersistentBankFees This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.fee = fee;
        this.internalFee = internalFee;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 244;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 244) ConnectionHandler.getTheConnectionHandler().theBankFeesFacade
            .newBankFees(this.getId());
        super.store();
        if(this.getFee() != null){
            this.getFee().store();
            ConnectionHandler.getTheConnectionHandler().theBankFeesFacade.feeSet(this.getId(), getFee());
        }
        if(this.getInternalFee() != null){
            this.getInternalFee().store();
            ConnectionHandler.getTheConnectionHandler().theBankFeesFacade.internalFeeSet(this.getId(), getInternalFee());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theBankFeesFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theBankFeesFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentTransactionFee getFee() throws PersistenceException {
        return this.fee;
    }
    public void setFee(PersistentTransactionFee newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.fee)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fee = (PersistentTransactionFee)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankFeesFacade.feeSet(this.getId(), newValue);
        }
    }
    public PersistentInternalFee getInternalFee() throws PersistenceException {
        return this.internalFee;
    }
    public void setInternalFee(PersistentInternalFee newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.internalFee)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.internalFee = (PersistentInternalFee)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankFeesFacade.internalFeeSet(this.getId(), newValue);
        }
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
            ConnectionHandler.getTheConnectionHandler().theBankFeesFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentBankFees newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentBankFees)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theBankFeesFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentBankFees getThis() throws PersistenceException {
        if(this.This == null){
            PersistentBankFees result = new BankFeesProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentBankFees)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBankFees(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankFees(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankFees(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankFees(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBankFees(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankFees(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankFees(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankFees(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getFee() != null) return 1;
        if (this.getInternalFee() != null) return 1;
        return 0;
    }
    
    
    public void changeInternalFee(final PersistentInternalFee newInternalFee) 
				throws PersistenceException{
        model.meta.BankFeesChangeInternalFeeInternalFeeMssg event = new model.meta.BankFeesChangeInternalFeeInternalFeeMssg(newInternalFee, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void changeTransactionFee(final PersistentTransactionFee newTransactionFee) 
				throws PersistenceException{
        model.meta.BankFeesChangeTransactionFeeTransactionFeeMssg event = new model.meta.BankFeesChangeTransactionFeeTransactionFeeMssg(newTransactionFee, getThis());
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
        this.setThis((PersistentBankFees)This);
		if(this.equals(This)){
			this.setFee((PersistentTransactionFee)final$$Fields.get("fee"));
			this.setInternalFee((PersistentInternalFee)final$$Fields.get("internalFee"));
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
    
    public void changeInternalFeeImplementation(final PersistentInternalFee newInternalFee) 
				throws PersistenceException{
    	getThis().setInternalFee(newInternalFee);
        
    }
    public void changeTransactionFeeImplementation(final PersistentTransactionFee newTransactionFee) 
				throws PersistenceException{
        getThis().setFee(newTransactionFee);
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
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
