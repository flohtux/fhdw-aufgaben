package viewClient;

import view.*;
import java.net.MalformedURLException;

import java.io.IOException;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcException;

public class BankServiceConnection extends ServiceConnection {

	public BankServiceConnection (String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public BankServiceView getBankServiceView(){
		return (BankServiceView)super.getServer();
	}

    public synchronized java.util.Vector<?> transAcc_Path_In_CloseAccount() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "transAcc_Path_In_CloseAccount", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -188)
                    throw NoAccountsFound.fromHashtableToNoAccountsFound((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -163)
                    throw PasswordException.fromHashtableToPasswordException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -165)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -171)
                    throw LimitViolatedException.fromHashtableToLimitViolatedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -192)
                    throw DebitNotGrantedException.fromHashtableToDebitNotGrantedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -178)
                    throw NoPermissionToExecuteDebitTransferException.fromHashtableToNoPermissionToExecuteDebitTransferException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -170)
                    throw InvalidAccountNumberException.fromHashtableToInvalidAccountNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -169)
                    throw InvalidBankNumberException.fromHashtableToInvalidBankNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -162)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -174)
                    throw CloseAccountNoPossibleException.fromHashtableToCloseAccountNoPossibleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -225)
                    throw GrantAlreadyGivenException.fromHashtableToGrantAlreadyGivenException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }else{
                return view.objects.ViewProxi.getProxiVector((Vector<String>)success.get(common.RPCConstantsAndServices.ResultListFieldName),getHandler());
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void changeMaxLimit(LimitAccountView limit, common.Fraction amount) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (limit == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)limit).createProxiInformation());
            }
            parameters.add(amount.toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "changeMaxLimit", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void changeMinLimit(LimitAccountView limit, common.Fraction amount) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (limit == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)limit).createProxiInformation());
            }
            parameters.add(amount.toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "changeMinLimit", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
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
    
    public synchronized void changeTransactionFee(String newFee, common.Fraction fix, String fixCurrency, common.Fraction limit, String limitCurrency, common.Fraction procentual) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(newFee);
            parameters.add(fix.toString());
            parameters.add(fixCurrency);
            parameters.add(limit.toString());
            parameters.add(limitCurrency);
            parameters.add(procentual.toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "changeTransactionFee", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void closeAccount(AccountView acc) throws ModelException, CloseAccountNoPossibleException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (acc == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)acc).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "closeAccount", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -174)
                    throw CloseAccountNoPossibleException.fromHashtableToCloseAccountNoPossibleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void closeAccount(AccountView acc, AccountView transAcc) throws ModelException, ExecuteException, CloseAccountNoPossibleException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (acc == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)acc).createProxiInformation());
            }
            if (transAcc == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)transAcc).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "closeAccount", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -171)
                    throw LimitViolatedException.fromHashtableToLimitViolatedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -192)
                    throw DebitNotGrantedException.fromHashtableToDebitNotGrantedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -178)
                    throw NoPermissionToExecuteDebitTransferException.fromHashtableToNoPermissionToExecuteDebitTransferException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -170)
                    throw InvalidAccountNumberException.fromHashtableToInvalidAccountNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -169)
                    throw InvalidBankNumberException.fromHashtableToInvalidBankNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -174)
                    throw CloseAccountNoPossibleException.fromHashtableToCloseAccountNoPossibleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void createAccount(String currencyType) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(currencyType);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createAccount", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void findAccount(long accountNumber) throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(new Long(accountNumber).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "findAccount", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -188)
                    throw NoAccountsFound.fromHashtableToNoAccountsFound((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -163)
                    throw PasswordException.fromHashtableToPasswordException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -165)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -171)
                    throw LimitViolatedException.fromHashtableToLimitViolatedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -192)
                    throw DebitNotGrantedException.fromHashtableToDebitNotGrantedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -178)
                    throw NoPermissionToExecuteDebitTransferException.fromHashtableToNoPermissionToExecuteDebitTransferException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -170)
                    throw InvalidAccountNumberException.fromHashtableToInvalidAccountNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -169)
                    throw InvalidBankNumberException.fromHashtableToInvalidBankNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -162)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -174)
                    throw CloseAccountNoPossibleException.fromHashtableToCloseAccountNoPossibleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -225)
                    throw GrantAlreadyGivenException.fromHashtableToGrantAlreadyGivenException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void resetMaxLimit(LimitAccountView limit) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (limit == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)limit).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "resetMaxLimit", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void resetMinLimit(LimitAccountView limit) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (limit == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)limit).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "resetMinLimit", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    

}
