package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class MoneyRuleProxi extends RuleProxi implements MoneyRuleView{
    
    public MoneyRuleProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public MoneyRuleView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi limitType = null;
        String limitType$String = (String)resultTable.get("limitType");
        if (limitType$String != null) {
            common.ProxiInformation limitType$Info = common.RPCConstantsAndServices.createProxiInformation(limitType$String);
            limitType = view.objects.ViewProxi.createProxi(limitType$Info,connectionKey);
            limitType.setToString(limitType$Info.getToString());
        }
        MoneyRuleView result$$ = new MoneyRule((LimitTypeView)limitType, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getLimitType() != null) return new LimitTypeMoneyRuleWrapper(this, originalIndex, (ViewRoot)this.getLimitType());
        if(this.getLimitType() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getLimitType() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getLimitType() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getLimitType() != null && this.getLimitType().equals(child)) return result;
        if(this.getLimitType() != null) result = result + 1;
        return -1;
    }
    
    public LimitTypeView getLimitType()throws ModelException{
        return ((MoneyRule)this.getTheObject()).getLimitType();
    }
    public void setLimitType(LimitTypeView newValue) throws ModelException {
        ((MoneyRule)this.getTheObject()).setLimitType(newValue);
    }
    
    public void accept(RuleVisitor visitor) throws ModelException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(RuleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(RuleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(RuleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMoneyRule(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMoneyRule(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMoneyRule(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMoneyRule(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMoneyRule(this);
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
