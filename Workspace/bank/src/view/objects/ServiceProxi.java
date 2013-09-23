package view.objects;

import view.*;
import viewClient.*;

public abstract class ServiceProxi extends ViewProxi implements ServiceView{
    
    public ServiceProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public java.util.Vector<ErrorDisplayView> getErrors()throws ModelException{
        return ((Service)this.getTheObject()).getErrors();
    }
    public void setErrors(java.util.Vector<ErrorDisplayView> newValue) throws ModelException {
        ((Service)this.getTheObject()).setErrors(newValue);
    }
    
    
    
    public ServiceConnection connectService(ConnectionMaster master, final ExceptionAndEventHandler handler) throws ModelException{
        ServiceConnection result;
		try {
			result = (ServiceConnection) new ServiceConnection(master.getUrlString(), master.getHandler(), master.getReporter()).fork(master, this);
		} catch (java.net.MalformedURLException e) {
			throw new ModelException(e.getMessage(),0);
		}
		result.setHandler(handler);
		ConnectionIndex.getTheConnectionIndex().setConnection(handler,result);
		handler.setConnection(result);
		handler.initializeConnection();
		return result;
    }
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
