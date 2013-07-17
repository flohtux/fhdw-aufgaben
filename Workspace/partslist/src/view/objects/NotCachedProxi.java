package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class NotCachedProxi extends StateProxi implements NotCachedView{
    
    public NotCachedProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public NotCachedView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi master = null;
        String master$String = (String)resultTable.get("master");
        if (master$String != null) {
            common.ProxiInformation master$Info = common.RPCConstantsAndServices.createProxiInformation(master$String);
            master = view.objects.ViewProxi.createProxi(master$Info,connectionKey);
            master.setToString(master$Info.getToString());
        }
        NotCachedView result$$ = new NotCached((ComponentView)master, this.getId(), this.getClassId());
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
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMaster() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMaster() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMaster() != null && this.getMaster().equals(child)) return result;
        if(this.getMaster() != null) result = result + 1;
        return -1;
    }
    
    
    public void accept(StateVisitor visitor) throws ModelException {
        visitor.handleNotCached(this);
    }
    public <R> R accept(StateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotCached(this);
    }
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotCached(this);
    }
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotCached(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNotCached(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotCached(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotCached(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotCached(this);
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
