
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class DebitTransferPayedFees extends PersistentObject implements PersistentDebitTransferPayedFees{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitTransferPayedFees getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade.getClass(objectId);
        return (PersistentDebitTransferPayedFees)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentDebitTransferPayedFees createDebitTransferPayedFees(PersistentMoney payedFees,PersistentAccount payingAccount) throws PersistenceException{
        return createDebitTransferPayedFees(payedFees,payingAccount,false);
    }
    
    public static PersistentDebitTransferPayedFees createDebitTransferPayedFees(PersistentMoney payedFees,PersistentAccount payingAccount,boolean delayed$Persistence) throws PersistenceException {
        PersistentDebitTransferPayedFees result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade
                .newDelayedDebitTransferPayedFees();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade
                .newDebitTransferPayedFees(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("payedFees", payedFees);
        final$$Fields.put("payingAccount", payingAccount);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentDebitTransferPayedFees createDebitTransferPayedFees(PersistentMoney payedFees,PersistentAccount payingAccount,boolean delayed$Persistence,PersistentDebitTransferPayedFees This) throws PersistenceException {
        PersistentDebitTransferPayedFees result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade
                .newDelayedDebitTransferPayedFees();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade
                .newDebitTransferPayedFees(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("payedFees", payedFees);
        final$$Fields.put("payingAccount", payingAccount);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot payedFees = (AbstractPersistentRoot)this.getPayedFees();
            if (payedFees != null) {
                result.put("payedFees", payedFees.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    payedFees.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && payedFees.hasEssentialFields())payedFees.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot payingAccount = (AbstractPersistentRoot)this.getPayingAccount();
            if (payingAccount != null) {
                result.put("payingAccount", payingAccount.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    payingAccount.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && payingAccount.hasEssentialFields())payingAccount.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public DebitTransferPayedFees provideCopy() throws PersistenceException{
        DebitTransferPayedFees result = this;
        result = new DebitTransferPayedFees(this.payedFees, 
                                            this.payingAccount, 
                                            this.subService, 
                                            this.This, 
                                            this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMoney payedFees;
    protected PersistentAccount payingAccount;
    protected SubjInterface subService;
    protected PersistentDebitTransferPayedFees This;
    
    public DebitTransferPayedFees(PersistentMoney payedFees,PersistentAccount payingAccount,SubjInterface subService,PersistentDebitTransferPayedFees This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.payedFees = payedFees;
        this.payingAccount = payingAccount;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 288;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 288) ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade
            .newDebitTransferPayedFees(this.getId());
        super.store();
        if(this.getPayedFees() != null){
            this.getPayedFees().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade.payedFeesSet(this.getId(), getPayedFees());
        }
        if(this.getPayingAccount() != null){
            this.getPayingAccount().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade.payingAccountSet(this.getId(), getPayingAccount());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentMoney getPayedFees() throws PersistenceException {
        return this.payedFees;
    }
    public void setPayedFees(PersistentMoney newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.payedFees)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.payedFees = (PersistentMoney)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade.payedFeesSet(this.getId(), newValue);
        }
    }
    public PersistentAccount getPayingAccount() throws PersistenceException {
        return this.payingAccount;
    }
    public void setPayingAccount(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.payingAccount)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.payingAccount = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade.payingAccountSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitTransferPayedFees newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitTransferPayedFees)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferPayedFeesFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentDebitTransferPayedFees getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDebitTransferPayedFees result = new DebitTransferPayedFeesProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentDebitTransferPayedFees)this.This;
    }
    
    public void accept(DebitTransferPayedFeesVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferPayedFees(this);
    }
    public <R> R accept(DebitTransferPayedFeesReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public <E extends UserException>  void accept(DebitTransferPayedFeesExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferPayedFees(this);
    }
    public <R, E extends UserException> R accept(DebitTransferPayedFeesReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferPayedFees(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferPayedFees(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferPayedFees(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferPayedFees(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferPayedFees(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferPayedFees(this);
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
        this.setThis((PersistentDebitTransferPayedFees)This);
		if(this.equals(This)){
			this.setPayedFees((PersistentMoney)final$$Fields.get("payedFees"));
			this.setPayingAccount((PersistentAccount)final$$Fields.get("payingAccount"));
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
