
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Administrator extends model.Service implements PersistentAdministrator{
    
    
    public static PersistentAdministrator createAdministrator() throws PersistenceException{
        return createAdministrator(false);
    }
    
    public static PersistentAdministrator createAdministrator(boolean delayed$Persistence) throws PersistenceException {
        PersistentAdministrator result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
                .newDelayedAdministrator();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
                .newAdministrator(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentAdministrator createAdministrator(boolean delayed$Persistence,PersistentAdministrator This) throws PersistenceException {
        PersistentAdministrator result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
                .newDelayedAdministrator();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
                .newAdministrator(-1);
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
            result.put("banks", this.getBanks().getObservee().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Administrator provideCopy() throws PersistenceException{
        Administrator result = this;
        result = new Administrator(this.subService, 
                                   this.This, 
                                   this.banks, 
                                   this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAdministratorBanks banks;
    
    public Administrator(SubjInterface subService,PersistentService This,PersistentAdministratorBanks banks,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentService)This,id);
        this.banks = banks;        
    }
    
    static public long getTypeId() {
        return -112;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -112) ConnectionHandler.getTheConnectionHandler().theAdministratorFacade
            .newAdministrator(this.getId());
        super.store();
        if(this.banks != null){
            this.banks.store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorFacade.banksSet(this.getId(), banks);
        }
        
    }
    
    protected void setBanks(PersistentAdministratorBanks newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.banks)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.banks = (PersistentAdministratorBanks)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdministratorFacade.banksSet(this.getId(), newValue);
        }
    }
    public PersistentAdministrator getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAdministrator result = new AdministratorProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAdministrator)this.This;
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAdministrator(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdministrator(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdministrator(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdministrator(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getBanks().getObservee().getLength() > 0) return 1;
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
    public PersistentAdministratorBanks getBanks() 
				throws PersistenceException{
        if (this.banks == null) {
			this.setBanks(model.AdministratorBanks.createAdministratorBanks(this.isDelayed$Persistence()));
			this.banks.setObserver(this);
		}
		return this.banks;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAdministrator)This);
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
    
    public void banks_update(final model.meta.BankMssgs event) 
				throws PersistenceException{
        //TODO !PREREQUISITES: implement method: banks_update
        getThis().signalChanged(true);
    }
    public void changeName(final PersistentBank bank, final String name) 
				throws PersistenceException{
        //TODO !PREREQUISITES: implement method: changeName
        bank.changeName(name, getThis());
    }
    public void connected(final String user) 
				throws PersistenceException{
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void createBank(final String name) 
				throws PersistenceException{
    	//TODO !PREREQUISITES:  implement method: createBank!
        BankCreator.getTheBankCreator().createBank(name, getThis());
    }
    public void disconnected() 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    
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
						command.accept(new CommandStandardVisitor() {
							//TODO !PREREQUISITES manage created banks
							public void handleCreateBankCommand(PersistentCreateBankCommand createBankCommand) throws PersistenceException {
								PersistentBank newBank = createBankCommand.getCommandResult();
								getThis().getBanks().add(newBank);
							}
							protected void standardHandling(Command command)
									throws PersistenceException {
								//Nothing to do!
							}
						});
						signalChanged(true);
					} catch (model.UserException e) {
						model.UserExceptionToDisplayVisitor visitor = new model.UserExceptionToDisplayVisitor();
						e.accept(visitor);
						getErrors().add(visitor.getResult());
						signalChanged(true);
					}
				} catch (PersistenceException e) {
					//Handle fatal exception!
				}
			}
		}).start();
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
