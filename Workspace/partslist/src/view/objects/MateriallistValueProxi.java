package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MateriallistValueProxi extends ViewProxi implements MateriallistValueView{
    
    public MateriallistValueProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MateriallistValueView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi material = null;
        String material$String = (String)resultTable.get("material");
        if (material$String != null) {
            common.ProxiInformation material$Info = common.RPCConstantsAndServices.createProxiInformation(material$String);
            material = view.objects.ViewProxi.createProxi(material$Info,connectionKey);
            material.setToString(material$Info.getToString());
        }
        long amount = new Long((String)resultTable.get("amount")).longValue();
        MateriallistValueView result$$ = new MateriallistValue((MaterialView)material,(long)amount, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(this.getMaterial() != null && index < this.getMaterial().getTheObject().getChildCount())
            return this.getMaterial().getTheObject().getChild(index);
        if(this.getMaterial() != null) index = index - this.getMaterial().getTheObject().getChildCount();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getMaterial() == null ? 0 : this.getMaterial().getTheObject().getChildCount());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getMaterial() == null ? true : this.getMaterial().getTheObject().isLeaf());
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getMaterial() != null && this.getMaterial().equals(child)) return result;
        if(this.getMaterial() != null) result = result + 1;
        return -1;
    }
    
    public MaterialView getMaterial()throws ModelException{
        return ((MateriallistValue)this.getTheObject()).getMaterial();
    }
    public void setMaterial(MaterialView newValue) throws ModelException {
        ((MateriallistValue)this.getTheObject()).setMaterial(newValue);
    }
    public long getAmount()throws ModelException{
        return ((MateriallistValue)this.getTheObject()).getAmount();
    }
    public void setAmount(long newValue) throws ModelException {
        ((MateriallistValue)this.getTheObject()).setAmount(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMateriallistValue(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMateriallistValue(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMateriallistValue(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMateriallistValue(this);
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
