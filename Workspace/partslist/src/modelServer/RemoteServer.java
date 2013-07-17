
package modelServer;


import model.*;
import persistence.*;

public  class RemoteServer extends RemoteServerMaster {

	protected PersistentServer server;

	public RemoteServer(String connectionName, String userName, PersistentServer server){
		super (connectionName, userName );
        this.server = server;
	}

	protected Remote getServer(){
        return this.server;
    } 

    public synchronized java.util.HashMap<?,?> addComponent(String productProxiString, String newPartProxiString, String amountAsString){
        try {
            PersistentProduct product = (PersistentProduct)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(productProxiString));
            PersistentComponent newPart = (PersistentComponent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(newPartProxiString));
            long amount = new Long(amountAsString).longValue();
            ((PersistentServer)this.server).addComponent(product, newPart, amount);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.CycleException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> clearComponents(){
        try {
            ((PersistentServer)this.server).clearComponents();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> clearErrors(){
        try {
            ((PersistentServer)this.server).clearErrors();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> count(String componentProxiString){
        try {
            PersistentComponent component = (PersistentComponent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(componentProxiString));
            long result = ((PersistentServer)this.server).count(component);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createComponent(String name, String componentType){
        try {
            ((PersistentServer)this.server).createComponent(name, componentType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.HashMap<?,?> fetchMateriallist(String componentProxiString){
        try {
            PersistentComponent component = (PersistentComponent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(componentProxiString));
            PersistentMateriallist result = ((PersistentServer)this.server).fetchMateriallist(component);
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> importComponent(String name){
        try {
            ((PersistentServer)this.server).importComponent(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> refreshView(){
        try {
            ((PersistentServer)this.server).refreshView();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}