package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ProductProxi extends ComponentProxi implements ProductView{
    
    public ProductProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ProductView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        ViewProxi currentState = null;
        String currentState$String = (String)resultTable.get("currentState");
        if (currentState$String != null) {
            common.ProxiInformation currentState$Info = common.RPCConstantsAndServices.createProxiInformation(currentState$String);
            currentState = view.objects.ViewProxi.createProxi(currentState$Info,connectionKey);
            currentState.setToString(currentState$Info.getToString());
        }
        java.util.Vector<String> partOf_string = (java.util.Vector<String>)resultTable.get("partOf");
        java.util.Vector<QPartView> partOf = ViewProxi.getProxiVector(partOf_string, connectionKey);
        java.util.Vector<String> parts_string = (java.util.Vector<String>)resultTable.get("parts");
        java.util.Vector<QPartView> parts = ViewProxi.getProxiVector(parts_string, connectionKey);
        ProductView result$$ = new Product((String)name,(StateView)currentState,partOf,parts, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getParts().size()) return new PartsProductWrapper(this, originalIndex, (ViewRoot)this.getParts().get(index));
        index = index - this.getParts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getParts().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getParts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getPartsIterator = this.getParts().iterator();
        while(getPartsIterator.hasNext()){
            if(getPartsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<QPartView> getParts()throws ModelException{
        return ((Product)this.getTheObject()).getParts();
    }
    public void setParts(java.util.Vector<QPartView> newValue) throws ModelException {
        ((Product)this.getTheObject()).setParts(newValue);
    }
    
    public void accept(ComponentVisitor visitor) throws ModelException {
        visitor.handleProduct(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProduct(this);
    }
    public <E extends UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProduct(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProduct(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProduct(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProduct(this);
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
