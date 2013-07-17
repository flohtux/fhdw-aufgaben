package persistence;

import java.util.HashMap;

abstract class ProxiFactory {
	  abstract PersistentProxi create(long objectId);
}
abstract class ListProxiFactory {
	  abstract PersistentListEntryProxi create(long objectId, long entryId);
}

public abstract class PersistentProxi extends PersistentRoot {

  private static ProxiFactory [] proxiFactories;
  private static ListProxiFactory [] listProxiFactories;
	
  private static ListProxiFactory [] getTheListProxiFactories(){
	if (listProxiFactories == null){
		listProxiFactories = new ListProxiFactory[29];
        listProxiFactories[0] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CreateComponentCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[2] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new PartsListManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ProductListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[4] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new QPartListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[5] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MaterialListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[6] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CachedListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[7] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[8] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[9] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new AddComponentCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[10] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MateriallistListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[12] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new NotCachedListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[13] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[14] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[15] = new ListProxiFactory(){
            PersistentListEntryProxi create(long objectId, long entryId){
                return new MateriallistValueListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [29];
        proxiFactories[0] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CreateComponentCommandProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[2] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new PartsListManagerProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ProductProxi(objectId);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new QPartProxi(objectId);
            }
        };
        proxiFactories[5] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MaterialProxi(objectId);
            }
        };
        proxiFactories[6] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CachedProxi(objectId);
            }
        };
        proxiFactories[7] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[8] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[9] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new AddComponentCommandProxi(objectId);
            }
        };
        proxiFactories[10] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MateriallistProxi(objectId);
            }
        };
        proxiFactories[12] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new NotCachedProxi(objectId);
            }
        };
        proxiFactories[13] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[14] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[15] = new ProxiFactory(){
            PersistentProxi create(long objectId){
                return new MateriallistValueProxi(objectId);
            }
        };
	}
	return proxiFactories;
  }

  public static PersistentProxi createProxi(common.ProxiInformation proxi) throws PersistenceException{
	  if (proxi.isDecorator()){
		  Decoratees resultDecoratee = (Decoratees) createProxi(proxi.getDecorateeObjectId(), proxi.getDecorateeClassId());
		  PersistentProxi resultDecorator = (PersistentProxi) resultDecoratee.createDecorator();
		  resultDecorator.setId(proxi.getObjectId());
		  return resultDecorator;
	  } else {
		  return createProxi(proxi.getObjectId(), proxi.getClassId());
	  }
  }

  public static PersistentProxi createProxi(long objectId, long classId) throws PersistenceException {
    int index = (int) classId;
    if (classId == common.RPCConstantsAndServices.NullClassID) return null; 
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ProxiFactory factory = getTheProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentProxi result =  factory.create(objectId);
    result.getTheObject();
    return result;
  }
  public static PersistentListEntryProxi createListEntryProxi(long objectId, long classId, long entryId) throws PersistenceException {
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheListProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ListProxiFactory factory = getTheListProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentListEntryProxi result =  factory.create(objectId,entryId);
    result.getTheObject();
    return result;
  }

	private PersistentInCacheProxi object;

	protected PersistentProxi(long id) {
		super(id);
		this.object = null;
	}

	protected PersistentProxi(PersistentInCacheProxi object) {
		//TODO Check if used anywhere!?
		super(object.getId());
		this.object = object;
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

	protected void setObject(PersistentRoot object) {
		if (this.object == null)
			this.object = (PersistentInCacheProxi)object;
	}

	public HashMap<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(depth, essentialLevel, forGUI, tdObserver);
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, tdObserver);
	}

	public PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) {
			this.object = Cache.getTheCache().get(this);
			this.object.incrementUserCount();
		}
		return this.object;
	}
	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
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
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	
    	
	
	public void finalize(){
		if (this.object != null)this.object.decrementUserCount();
	}
}
