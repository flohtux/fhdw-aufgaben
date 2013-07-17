package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MateriallistProxi extends ViewProxi implements MateriallistView{
    
    public MateriallistProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public MateriallistView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> values_string = (java.util.Vector<String>)resultTable.get("values");
        java.util.Vector<MateriallistValueView> values = ViewProxi.getProxiVector(values_string, connectionKey);
        MateriallistView result$$ = new Materiallist(values, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getValues().size()) return new ValuesMateriallistWrapper(this, originalIndex, (ViewRoot)this.getValues().get(index));
        index = index - this.getValues().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getValues().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getValues().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getValuesIterator = this.getValues().iterator();
        while(getValuesIterator.hasNext()){
            if(getValuesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<MateriallistValueView> getValues()throws ModelException{
        return ((Materiallist)this.getTheObject()).getValues();
    }
    public void setValues(java.util.Vector<MateriallistValueView> newValue) throws ModelException {
        ((Materiallist)this.getTheObject()).setValues(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMateriallist(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMateriallist(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMateriallist(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMateriallist(this);
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
