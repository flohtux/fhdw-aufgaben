package persistence;

import java.util.HashMap;

abstract class ICProxiFactory {
	  abstract PersistentInCacheProxi create(long objectId);
}

public abstract class PersistentInCacheProxi extends PersistentRoot {

	  private static ICProxiFactory [] iCProxiFactories;
		
	  private static ICProxiFactory [] getTheICProxiFactories(){
		if (iCProxiFactories == null){
			iCProxiFactories = new ICProxiFactory[53];
        iCProxiFactories[38] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MixedFeeICProxi(objectId);
            }
        };
        iCProxiFactories[28] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new SubjICProxi(objectId);
            }
        };
        iCProxiFactories[25] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountServiceICProxi(objectId);
            }
        };
        iCProxiFactories[39] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NoLimitStateICProxi(objectId);
            }
        };
        iCProxiFactories[13] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AccountICProxi(objectId);
            }
        };
        iCProxiFactories[29] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeNameCommandICProxi(objectId);
            }
        };
        iCProxiFactories[0] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ErrorDisplayICProxi(objectId);
            }
        };
        iCProxiFactories[50] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DebitNoteICProxi(objectId);
            }
        };
        iCProxiFactories[35] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new EuroICProxi(objectId);
            }
        };
        iCProxiFactories[34] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateAccountCommandICProxi(objectId);
            }
        };
        iCProxiFactories[41] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new FixTransactionFeeICProxi(objectId);
            }
        };
        iCProxiFactories[16] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandCoordinatorICProxi(objectId);
            }
        };
        iCProxiFactories[42] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MinLimitStateICProxi(objectId);
            }
        };
        iCProxiFactories[18] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommonDateICProxi(objectId);
            }
        };
        iCProxiFactories[51] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new TrancactionICProxi(objectId);
            }
        };
        iCProxiFactories[44] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MaxLimitStateICProxi(objectId);
            }
        };
        iCProxiFactories[45] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AmountICProxi(objectId);
            }
        };
        iCProxiFactories[15] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandExecuterICProxi(objectId);
            }
        };
        iCProxiFactories[46] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new MoneyICProxi(objectId);
            }
        };
        iCProxiFactories[11] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AdministratorICProxi(objectId);
            }
        };
        iCProxiFactories[24] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateBankCommandICProxi(objectId);
            }
        };
        iCProxiFactories[12] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BankICProxi(objectId);
            }
        };
        iCProxiFactories[26] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BankServiceICProxi(objectId);
            }
        };
        iCProxiFactories[47] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProcentualFeeICProxi(objectId);
            }
        };
        iCProxiFactories[1] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServerICProxi(objectId);
            }
        };
        iCProxiFactories[30] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AdministratorBanksICProxi(objectId);
            }
        };
        iCProxiFactories[22] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new BankCreatorICProxi(objectId);
            }
        };
        iCProxiFactories[36] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new DollarICProxi(objectId);
            }
        };
		}
		return iCProxiFactories;
	  }

	public static PersistentInCacheProxi createInCacheProxi(long objectId, long classId) throws PersistenceException {
	    int index = (int) classId;
		if (index < 0) index = index * -1;
	    index = index - 101;
	    if (index > getTheICProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    ICProxiFactory factory = getTheICProxiFactories()[index];
	    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    PersistentInCacheProxi result =  factory.create(objectId);
	    return result;
	}

	protected PersistentObject object;
  	public int userCount;
	
	protected PersistentInCacheProxi(long id) {
		super(id);
		this.userCount = 0;
	}

	public PersistentInCacheProxi(PersistentObject object) {
		this(object.getId());
	}
	
	public boolean isDelayed$Persistence() throws PersistenceException {
		return this.getTheObject().isDelayed$Persistence();
	}

	public void setDelayed$Persistence(boolean b) throws PersistenceException {
		this.getTheObject().setDelayed$Persistence(b);
	}
	public void store() throws PersistenceException{
		this.getTheObject().store();
	}

	public void setId(long id) {
		super.setId(id);
		try {
			this.getTheObject().setId(id);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}
	public HashMap<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(depth, essentialLevel, forGUI, tdObserver);
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, tdObserver);
	}

	protected abstract PersistentObject getRemote() throws PersistenceException;

	public synchronized PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) this.object = getRemote();
		return this.object;
	}		
	protected synchronized void setObject(PersistentObject object) throws PersistenceException {
		this.object = object;
	}
	protected synchronized void clear() throws PersistenceException {
		this.object = null;
	}
	public int getIconInfo() throws PersistenceException {
		return this.getTheObject().getIconInfo();
	}
	public int getLeafInfo() throws PersistenceException {
		return this.getTheObject().getLeafInfo();
	}
	public String toString() {
		try {
			return this.getTheObject().toString();
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}
	}
	public String toString(boolean inner)throws PersistenceException{
		try {
			return this.getTheObject().toString(inner);
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}		
	}

	public synchronized void incrementUserCount() {
		this.userCount++;
	}

	public synchronized void decrementUserCount() {
		this.userCount--;
		if (this.isRemovable())Cache.getTheCache().remove(this);
	}

	protected boolean isRemovable() {
		return this.userCount == 0 ;
	}
	public synchronized void tryBreak() {
		try {
			if (!this.isDelayed$Persistence())this.object = null;
		} catch (PersistenceException e) {
			return;
		}
	}

	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	
    
}