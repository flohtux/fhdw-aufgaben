package view.objects;

import view.DebitTransferTransactionView;
import view.ModelException;
import view.RuleView;
import view.TriggerStateView;
import view.TriggerView;
import view.UserException;
import view.visitor.AnythingExceptionVisitor;
import view.visitor.AnythingReturnExceptionVisitor;
import view.visitor.AnythingReturnVisitor;
import view.visitor.AnythingVisitor;
import view.visitor.TriggerValueExceptionVisitor;
import view.visitor.TriggerValueReturnExceptionVisitor;
import view.visitor.TriggerValueReturnVisitor;
import view.visitor.TriggerValueVisitor;
import viewClient.ExceptionAndEventHandler;

public class TriggerProxi extends TriggerValueProxi implements TriggerView{
    
    public TriggerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public TriggerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        ViewProxi state = null;
        String state$String = (String)resultTable.get("state");
        if (state$String != null) {
            common.ProxiInformation state$Info = common.RPCConstantsAndServices.createProxiInformation(state$String);
            state = view.objects.ViewProxi.createProxi(state$Info,connectionKey);
            state.setToString(state$Info.getToString());
        }
        ViewProxi action = null;
        String action$String = (String)resultTable.get("action");
        if (action$String != null) {
            common.ProxiInformation action$Info = common.RPCConstantsAndServices.createProxiInformation(action$String);
            action = view.objects.ViewProxi.createProxi(action$Info,connectionKey);
            action.setToString(action$Info.getToString());
        }
        java.util.Vector<String> rules_string = (java.util.Vector<String>)resultTable.get("rules");
        java.util.Vector<RuleView> rules = ViewProxi.getProxiVector(rules_string, connectionKey);
        TriggerView result$$ = new Trigger((String)name,(TriggerStateView)state,(DebitTransferTransactionView)action,rules, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getState() != null) return new StateTriggerWrapper(this, originalIndex, (ViewRoot)this.getState());
        if(this.getState() != null) index = index - 1;
        if(index == 0 && this.getAction() != null) return new ActionTriggerWrapper(this, originalIndex, (ViewRoot)this.getAction());
        if(this.getAction() != null) index = index - 1;
        if(index < this.getRules().size()) return new RulesTriggerWrapper(this, originalIndex, (ViewRoot)this.getRules().get(index));
        index = index - this.getRules().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getState() == null ? 0 : 1)
            + (this.getAction() == null ? 0 : 1)
            + (this.getRules().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getState() == null ? true : false)
            && (this.getAction() == null ? true : false)
            && (this.getRules().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getState() != null && this.getState().equals(child)) return result;
        if(this.getState() != null) result = result + 1;
        if(this.getAction() != null && this.getAction().equals(child)) return result;
        if(this.getAction() != null) result = result + 1;
        java.util.Iterator<?> getRulesIterator = this.getRules().iterator();
        while(getRulesIterator.hasNext()){
            if(getRulesIterator.next().equals(child)) return result;
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
    public TriggerStateView getState()throws ModelException{
        return ((Trigger)this.getTheObject()).getState();
    }
    public void setState(TriggerStateView newValue) throws ModelException {
        ((Trigger)this.getTheObject()).setState(newValue);
    }
    public DebitTransferTransactionView getAction()throws ModelException{
        return ((Trigger)this.getTheObject()).getAction();
    }
    public void setAction(DebitTransferTransactionView newValue) throws ModelException {
        ((Trigger)this.getTheObject()).setAction(newValue);
    }
    public java.util.Vector<RuleView> getRules()throws ModelException{
        return ((Trigger)this.getTheObject()).getRules();
    }
    public void setRules(java.util.Vector<RuleView> newValue) throws ModelException {
        ((Trigger)this.getTheObject()).setRules(newValue);
    }
    
    public void accept(TriggerValueVisitor visitor) throws ModelException {
        visitor.handleTrigger(this);
    }
    public <R> R accept(TriggerValueReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTrigger(this);
    }
    public <E extends UserException>  void accept(TriggerValueExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTrigger(this);
    }
    public <R, E extends UserException> R accept(TriggerValueReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTrigger(this);
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
