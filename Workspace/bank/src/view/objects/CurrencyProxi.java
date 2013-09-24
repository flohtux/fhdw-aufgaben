package view.objects;

import view.CurrencyView;
import viewClient.ExceptionAndEventHandler;

public abstract class CurrencyProxi extends ViewProxi implements CurrencyView{
    
    public CurrencyProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
