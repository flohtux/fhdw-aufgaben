package viewClient;

import view.*;
import java.net.MalformedURLException;

import java.io.IOException;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcException;

public class ServiceConnection extends ConnectionMaster {

	public ServiceConnection (String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public ServiceView getServiceView(){
		return (ServiceView)super.getServer();
	}

    public synchronized String changePassword(String newPassword1, String newPassword2) throws ModelException, PasswordException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(newPassword1);
            parameters.add(newPassword2);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "changePassword", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -163)
                    throw PasswordException.fromHashtableToPasswordException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return (String)success.get(common.RPCConstantsAndServices.ResultFieldName);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    

}
