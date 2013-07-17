
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MateriallistProxi;
import persistence.Materiallist_ValuesProxi;
import persistence.PersistenceException;
import persistence.PersistentMaterial;
import persistence.PersistentMateriallist;
import persistence.PersistentMateriallistValue;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.Procdure;
import persistence.TDObserver;


/* Additional import section end */

public class Materiallist extends PersistentObject implements PersistentMateriallist{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentMateriallist getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theMateriallistFacade.getClass(objectId);
        return (PersistentMateriallist)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentMateriallist createMateriallist() throws PersistenceException{
        return createMateriallist(false);
    }
    
    public static PersistentMateriallist createMateriallist(boolean delayed$Persistence) throws PersistenceException {
        PersistentMateriallist result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMateriallistFacade
                .newDelayedMateriallist();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMateriallistFacade
                .newMateriallist(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMateriallist createMateriallist(boolean delayed$Persistence,PersistentMateriallist This) throws PersistenceException {
        PersistentMateriallist result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMateriallistFacade
                .newDelayedMateriallist();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMateriallistFacade
                .newMateriallist(-1);
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
            result.put("values", this.getValues().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Materiallist provideCopy() throws PersistenceException{
        Materiallist result = this;
        result = new Materiallist(this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Materiallist_ValuesProxi values;
    protected PersistentMateriallist This;
    
    public Materiallist(PersistentMateriallist This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.values = new Materiallist_ValuesProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 111;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 111) ConnectionHandler.getTheConnectionHandler().theMateriallistFacade
            .newMateriallist(this.getId());
        super.store();
        this.getValues().store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theMateriallistFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Materiallist_ValuesProxi getValues() throws PersistenceException {
        return this.values;
    }
    protected void setThis(PersistentMateriallist newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentMateriallist)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMateriallistFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentMateriallist getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMateriallist result = new MateriallistProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMateriallist)this.This;
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleMateriallist(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMateriallist(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMateriallist(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMateriallist(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMateriallist(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMateriallist(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMateriallist(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMateriallist(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getValues().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentMateriallist)This);
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public PersistentMateriallist addAll(final PersistentMateriallist list) 
				throws PersistenceException{
        list.getValues().applyToAll(new Procdure<PersistentMateriallistValue>() {
			public void doItTo(PersistentMateriallistValue argument)
					throws PersistenceException {
				getThis().add(argument.getMaterial(), argument.getAmount());
				
			}
		});
        return getThis();
    }
    public PersistentMateriallist add(final PersistentMaterial material, final long amount) 
				throws PersistenceException{

        PersistentMateriallistValue materialAlreadyInList = getThis().getValues().findFirst(new Predcate<PersistentMateriallistValue>() {
			public boolean test(PersistentMateriallistValue argument)
					throws PersistenceException {
				return argument.getMaterial().equals(material);
			}
		});
        if (materialAlreadyInList == null) { 
            PersistentMateriallistValue newValue = MateriallistValue.createMateriallistValue(material, amount);
            getThis().getValues().add(newValue);
        } else
        	materialAlreadyInList.setAmount(materialAlreadyInList.getAmount() + amount);
        
        return getThis();
    }
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
    public PersistentMateriallist multiply(final long factor) 
				throws PersistenceException{
        final PersistentMateriallist m = Materiallist.createMateriallist();
        getThis().getValues().applyToAll(new Procdure<PersistentMateriallistValue>() {
			public void doItTo(PersistentMateriallistValue argument)
					throws PersistenceException {
				m.add(argument.getMaterial(), argument.getAmount() * factor);
			}
		});
        
        return m;
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
