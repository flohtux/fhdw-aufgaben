package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TriggerListeProxi extends ViewProxi implements TriggerListeView{
    
    public TriggerListeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public TriggerListeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> triggers_string = (java.util.Vector<String>)resultTable.get("triggers");
        java.util.Vector<TriggerView> triggers = ViewProxi.getProxiVector(triggers_string, connectionKey);
        TriggerListeView result$$ = new TriggerListe(triggers, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getTriggers().size()) return new TriggersTriggerListeWrapper(this, originalIndex, (ViewRoot)this.getTriggers().get(index));
        index = index - this.getTriggers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTriggers().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getTriggers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTriggersIterator = this.getTriggers().iterator();
        while(getTriggersIterator.hasNext()){
            if(getTriggersIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<TriggerView> getTriggers()throws ModelException{
        return ((TriggerListe)this.getTheObject()).getTriggers();
    }
    public void setTriggers(java.util.Vector<TriggerView> newValue) throws ModelException {
        ((TriggerListe)this.getTheObject()).setTriggers(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTriggerListe(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTriggerListe(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTriggerListe(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTriggerListe(this);
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
