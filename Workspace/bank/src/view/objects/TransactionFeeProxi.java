package view.objects;

import view.TransactionFeeView;
import viewClient.ExceptionAndEventHandler;

public abstract class TransactionFeeProxi extends ViewProxi implements TransactionFeeView{
    
    public TransactionFeeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
