package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class EnabledStateProxi extends TriggerStateProxi implements EnabledStateView{
    
    public EnabledStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public EnabledStateView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi master = null;
        String master$String = (String)resultTable.get("master");
        if (master$String != null) {
            common.ProxiInformation master$Info = common.RPCConstantsAndServices.createProxiInformation(master$String);
            master = view.objects.ViewProxi.createProxi(master$Info,connectionKey);
            master.setToString(master$Info.getToString());
        }
        EnabledStateView result$$ = new EnabledState((TriggerView)master, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    
    public void accept(TriggerStateVisitor visitor) throws ModelException {
        visitor.handleEnabledState(this);
    }
    public <R> R accept(TriggerStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleEnabledState(this);
    }
    public <E extends UserException>  void accept(TriggerStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleEnabledState(this);
    }
    public <R, E extends UserException> R accept(TriggerStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleEnabledState(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleEnabledState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleEnabledState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleEnabledState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleEnabledState(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
