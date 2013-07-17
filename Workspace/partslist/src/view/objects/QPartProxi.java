package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class QPartProxi extends ViewProxi implements QPartView{
    
    public QPartProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public QPartView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long amount = new Long((String)resultTable.get("amount")).longValue();
        ViewProxi component = null;
        String component$String = (String)resultTable.get("component");
        if (component$String != null) {
            common.ProxiInformation component$Info = common.RPCConstantsAndServices.createProxiInformation(component$String);
            component = view.objects.ViewProxi.createProxi(component$Info,connectionKey);
            component.setToString(component$Info.getToString());
        }
        ViewProxi master = null;
        String master$String = (String)resultTable.get("master");
        if (master$String != null) {
            common.ProxiInformation master$Info = common.RPCConstantsAndServices.createProxiInformation(master$String);
            master = view.objects.ViewProxi.createProxi(master$Info,connectionKey);
            master.setToString(master$Info.getToString());
        }
        QPartView result$$ = new QPart((long)amount,(ComponentView)component,(ProductView)master, this.getId(), this.getClassId());
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
    
    public long getAmount()throws ModelException{
        return ((QPart)this.getTheObject()).getAmount();
    }
    public void setAmount(long newValue) throws ModelException {
        ((QPart)this.getTheObject()).setAmount(newValue);
    }
    public ComponentView getComponent()throws ModelException{
        return ((QPart)this.getTheObject()).getComponent();
    }
    public void setComponent(ComponentView newValue) throws ModelException {
        ((QPart)this.getTheObject()).setComponent(newValue);
    }
    public ProductView getMaster()throws ModelException{
        return ((QPart)this.getTheObject()).getMaster();
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleQPart(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQPart(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQPart(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQPart(this);
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
