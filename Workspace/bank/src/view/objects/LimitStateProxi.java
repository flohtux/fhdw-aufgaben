package view.objects;

import view.*;
import viewClient.*;

public abstract class LimitStateProxi extends AccountLimitStateProxi implements LimitStateView{
    
    public LimitStateProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public AmountView getBalance()throws ModelException{
        return ((LimitState)this.getTheObject()).getBalance();
    }
    public void setBalance(AmountView newValue) throws ModelException {
        ((LimitState)this.getTheObject()).setBalance(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
