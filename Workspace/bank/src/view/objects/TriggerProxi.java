package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TriggerProxi extends ViewProxi implements TriggerView{
    
    public TriggerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public TriggerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        ViewProxi action = null;
        String action$String = (String)resultTable.get("action");
        if (action$String != null) {
            common.ProxiInformation action$Info = common.RPCConstantsAndServices.createProxiInformation(action$String);
            action = view.objects.ViewProxi.createProxi(action$Info,connectionKey);
            action.setToString(action$Info.getToString());
        }
        java.util.Vector<String> rule_string = (java.util.Vector<String>)resultTable.get("rule");
        java.util.Vector<RuleView> rule = ViewProxi.getProxiVector(rule_string, connectionKey);
        TriggerView result$$ = new Trigger((String)name,(DebitTransferTransactionView)action,rule, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getAction() != null) return new ActionTriggerWrapper(this, originalIndex, (ViewRoot)this.getAction());
        if(this.getAction() != null) index = index - 1;
        if(index < this.getRule().size()) return new RuleTriggerWrapper(this, originalIndex, (ViewRoot)this.getRule().get(index));
        index = index - this.getRule().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getAction() == null ? 0 : 1)
            + (this.getRule().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getAction() == null ? true : false)
            && (this.getRule().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getAction() != null && this.getAction().equals(child)) return result;
        if(this.getAction() != null) result = result + 1;
        java.util.Iterator<?> getRuleIterator = this.getRule().iterator();
        while(getRuleIterator.hasNext()){
            if(getRuleIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public String getName()throws ModelException{
        return ((Trigger)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Trigger)this.getTheObject()).setName(newValue);
    }
    public DebitTransferTransactionView getAction()throws ModelException{
        return ((Trigger)this.getTheObject()).getAction();
    }
    public void setAction(DebitTransferTransactionView newValue) throws ModelException {
        ((Trigger)this.getTheObject()).setAction(newValue);
    }
    public java.util.Vector<RuleView> getRule()throws ModelException{
        return ((Trigger)this.getTheObject()).getRule();
    }
    public void setRule(java.util.Vector<RuleView> newValue) throws ModelException {
        ((Trigger)this.getTheObject()).setRule(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTrigger(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTrigger(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTrigger(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTrigger(this);
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
