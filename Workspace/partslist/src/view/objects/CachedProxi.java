package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class CachedProxi extends StateProxi implements CachedView{
    
    public CachedProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public CachedView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi master = null;
        String master$String = (String)resultTable.get("master");
        if (master$String != null) {
            common.ProxiInformation master$Info = common.RPCConstantsAndServices.createProxiInformation(master$String);
            master = view.objects.ViewProxi.createProxi(master$Info,connectionKey);
            master.setToString(master$Info.getToString());
        }
        ViewProxi cachedList = null;
        String cachedList$String = (String)resultTable.get("cachedList");
        if (cachedList$String != null) {
            common.ProxiInformation cachedList$Info = common.RPCConstantsAndServices.createProxiInformation(cachedList$String);
            cachedList = view.objects.ViewProxi.createProxi(cachedList$Info,connectionKey);
            cachedList.setToString(cachedList$Info.getToString());
        }
        CachedView result$$ = new Cached((ComponentView)master,(MateriallistView)cachedList, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getMaster() != null) return new MasterStateWrapper(this, originalIndex, (ViewRoot)this.getMaster());
        if(this.getMaster() != null) index = index - 1;
        if(index == 0 && this.getCachedList() != null) return new CachedListCachedWrapper(this, originalIndex, (ViewRoot)this.getCachedList());
        if(this.getCachedList() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMaster() == null ? 0 : 1)
            + (this.getCachedList() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMaster() == null ? true : false)
            && (this.getCachedList() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMaster() != null && this.getMaster().equals(child)) return result;
        if(this.getMaster() != null) result = result + 1;
        if(this.getCachedList() != null && this.getCachedList().equals(child)) return result;
        if(this.getCachedList() != null) result = result + 1;
        return -1;
    }
    
    public MateriallistView getCachedList()throws ModelException{
        return ((Cached)this.getTheObject()).getCachedList();
    }
    public void setCachedList(MateriallistView newValue) throws ModelException {
        ((Cached)this.getTheObject()).setCachedList(newValue);
    }
    
    public void accept(StateVisitor visitor) throws ModelException {
        visitor.handleCached(this);
    }
    public <R> R accept(StateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCached(this);
    }
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCached(this);
    }
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCached(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCached(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCached(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCached(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCached(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
