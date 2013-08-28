package viewClient;

import view.*;
import java.net.MalformedURLException;

import java.io.IOException;
import java.util.Vector;
import org.apache.xmlrpc.XmlRpcException;

public class AccountServiceConnection extends ServiceConnection {

	public AccountServiceConnection (String url, ExceptionAndEventHandler handler, ClientReporter reporter) throws MalformedURLException {
		super(url, handler, reporter);
	}

	public AccountServiceView getAccountServiceView(){
		return (AccountServiceView)super.getServer();
	}

    public synchronized java.util.Vector<?> debitTransfer_Path_In_AddToTransactionTemplate() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "debitTransfer_Path_In_AddToTransactionTemplate", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -188)
                    throw NoAccountsFound.fromHashtableToNoAccountsFound((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -162)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -163)
                    throw PasswordException.fromHashtableToPasswordException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -174)
                    throw CloseAccountNoPossibleException.fromHashtableToCloseAccountNoPossibleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -225)
                    throw GrantAlreadyGivenException.fromHashtableToGrantAlreadyGivenException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -165)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -171)
                    throw LimitViolatedException.fromHashtableToLimitViolatedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -192)
                    throw DebitNotGrantedException.fromHashtableToDebitNotGrantedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -178)
                    throw NoPermissionToExecuteDebitTransferException.fromHashtableToNoPermissionToExecuteDebitTransferException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -169)
                    throw InvalidBankNumberException.fromHashtableToInvalidBankNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -170)
                    throw InvalidAccountNumberException.fromHashtableToInvalidAccountNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
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
    
    public synchronized java.util.Vector<?> debitTransfer_Path_In_AddToTransaction() throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "debitTransfer_Path_In_AddToTransaction", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -188)
                    throw NoAccountsFound.fromHashtableToNoAccountsFound((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -162)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -163)
                    throw PasswordException.fromHashtableToPasswordException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -174)
                    throw CloseAccountNoPossibleException.fromHashtableToCloseAccountNoPossibleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -225)
                    throw GrantAlreadyGivenException.fromHashtableToGrantAlreadyGivenException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -165)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -171)
                    throw LimitViolatedException.fromHashtableToLimitViolatedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -192)
                    throw DebitNotGrantedException.fromHashtableToDebitNotGrantedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -178)
                    throw NoPermissionToExecuteDebitTransferException.fromHashtableToNoPermissionToExecuteDebitTransferException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -169)
                    throw InvalidBankNumberException.fromHashtableToInvalidBankNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -170)
                    throw InvalidAccountNumberException.fromHashtableToInvalidAccountNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
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
    
    public synchronized java.util.Vector<?> debitTransfer_Path_In_RemoveFromTransaction(TransactionView transaction) throws ModelException, UserException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (transaction == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)transaction).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "debitTransfer_Path_In_RemoveFromTransaction", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -188)
                    throw NoAccountsFound.fromHashtableToNoAccountsFound((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -162)
                    throw CycleException.fromHashtableToCycleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -163)
                    throw PasswordException.fromHashtableToPasswordException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -174)
                    throw CloseAccountNoPossibleException.fromHashtableToCloseAccountNoPossibleException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -225)
                    throw GrantAlreadyGivenException.fromHashtableToGrantAlreadyGivenException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -165)
                    throw RestrictionException.fromHashtableToRestrictionException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -171)
                    throw LimitViolatedException.fromHashtableToLimitViolatedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -192)
                    throw DebitNotGrantedException.fromHashtableToDebitNotGrantedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -178)
                    throw NoPermissionToExecuteDebitTransferException.fromHashtableToNoPermissionToExecuteDebitTransferException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -169)
                    throw InvalidBankNumberException.fromHashtableToInvalidBankNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -170)
                    throw InvalidAccountNumberException.fromHashtableToInvalidAccountNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
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
    
    public synchronized void addToTransactionTemplate(TransactionView transaction, java.util.Vector<DebitTransferView> debitTransfer) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (transaction == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)transaction).createProxiInformation());
            }
            java.util.Vector<String> debitTransferTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<DebitTransferView> debitTransferItrtr = debitTransfer.iterator();
            while (debitTransferItrtr.hasNext()){ 
                DebitTransferView current = debitTransferItrtr.next();
                debitTransferTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(debitTransferTrnsprt);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "addToTransactionTemplate", parameters);
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
    
    public synchronized void addToTransaction(TransactionView transaction, java.util.Vector<DebitTransferView> debitTransfer) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (transaction == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)transaction).createProxiInformation());
            }
            java.util.Vector<String> debitTransferTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<DebitTransferView> debitTransferItrtr = debitTransfer.iterator();
            while (debitTransferItrtr.hasNext()){ 
                DebitTransferView current = debitTransferItrtr.next();
                debitTransferTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(debitTransferTrnsprt);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "addToTransaction", parameters);
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
    
    public synchronized void changeCurrency(DebitTransferView trans, String currency) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (trans == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)trans).createProxiInformation());
            }
            parameters.add(currency);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "changeCurrency", parameters);
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
    
    public synchronized void changeMoney(DebitTransferView trans, common.Fraction newAmount) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (trans == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)trans).createProxiInformation());
            }
            parameters.add(newAmount.toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "changeMoney", parameters);
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
    
    public synchronized void changeReceiverAccount(DebitTransferView trans, long receiverAccNumber) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (trans == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)trans).createProxiInformation());
            }
            parameters.add(new Long(receiverAccNumber).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "changeReceiverAccount", parameters);
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
    
    public synchronized void changeReceiverBank(DebitTransferView trans, long receiverBankNumber) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (trans == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)trans).createProxiInformation());
            }
            parameters.add(new Long(receiverBankNumber).toString());
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "changeReceiverBank", parameters);
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
    
    public synchronized void changeSubject(DebitTransferView trans, String subject) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (trans == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)trans).createProxiInformation());
            }
            parameters.add(subject);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "changeSubject", parameters);
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
    
    public synchronized void createDebitGrant(DebitGrantListeView debitGrantList, long receiverBankNumber, long receiverAccNumber, String limitType, common.Fraction amount, String cur) throws ModelException, GrantAlreadyGivenException, InvalidBankNumberException, InvalidAccountNumberException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (debitGrantList == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)debitGrantList).createProxiInformation());
            }
            parameters.add(new Long(receiverBankNumber).toString());
            parameters.add(new Long(receiverAccNumber).toString());
            parameters.add(limitType);
            parameters.add(amount.toString());
            parameters.add(cur);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createDebitGrant", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -225)
                    throw GrantAlreadyGivenException.fromHashtableToGrantAlreadyGivenException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -169)
                    throw InvalidBankNumberException.fromHashtableToInvalidBankNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -170)
                    throw InvalidAccountNumberException.fromHashtableToInvalidAccountNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void createDebit() throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createDebit", parameters);
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
    
    public synchronized void createTemplate(String type) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            parameters.add(type);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createTemplate", parameters);
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
    
    public synchronized void createTransaction() throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createTransaction", parameters);
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
    
    public synchronized void createTransfer() throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "createTransfer", parameters);
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
    
    public synchronized void executeTransfer(DebitTransferTransactionView debitTransfer) throws ModelException, NoPermissionToExecuteDebitTransferException, ExecuteException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (debitTransfer == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)debitTransfer).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "executeTransfer", parameters);
            if(!((Boolean)success.get(common.RPCConstantsAndServices.OKOrNotOKResultFieldName)).booleanValue()){
                if (((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == 0)
                    throw new ModelException((String)success.get(common.RPCConstantsAndServices.ExceptionMessageFieldName), ((Integer)success.get(common.RPCConstantsAndServices.ExceptionNumberFieldName)).intValue());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -178)
                    throw NoPermissionToExecuteDebitTransferException.fromHashtableToNoPermissionToExecuteDebitTransferException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -171)
                    throw LimitViolatedException.fromHashtableToLimitViolatedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -192)
                    throw DebitNotGrantedException.fromHashtableToDebitNotGrantedException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -178)
                    throw NoPermissionToExecuteDebitTransferException.fromHashtableToNoPermissionToExecuteDebitTransferException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -169)
                    throw InvalidBankNumberException.fromHashtableToInvalidBankNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                if(((Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName)).intValue() == -170)
                    throw InvalidAccountNumberException.fromHashtableToInvalidAccountNumberException((java.util.HashMap)success.get(common.RPCConstantsAndServices.ResultFieldName), this.getHandler());
                throw new ModelException ("Fatal error (unknown exception code:" + (Integer)success.get(common.RPCConstantsAndServices.ErrorNumberFieldName) + ")",0);
            }
        }catch(IOException ioe){
            throw new ModelException(ioe.getMessage(),0);
        }catch(XmlRpcException xre){
            throw new ModelException(xre.getMessage(),0);
        }
        
    }
    
    public synchronized void removeFromTransaction(TransactionView transaction, java.util.Vector<DebitTransferView> debitTransfer) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (transaction == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)transaction).createProxiInformation());
            }
            java.util.Vector<String> debitTransferTrnsprt = new java.util.Vector<String>();
            java.util.Iterator<DebitTransferView> debitTransferItrtr = debitTransfer.iterator();
            while (debitTransferItrtr.hasNext()){ 
                DebitTransferView current = debitTransferItrtr.next();
                debitTransferTrnsprt.add(((view.objects.ViewProxi)current).createProxiInformation());
            }
            parameters.add(debitTransferTrnsprt);
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "removeFromTransaction", parameters);
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
    
    public synchronized void remove(DebitGrantView grant) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (grant == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)grant).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "remove", parameters);
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
    
    public synchronized void useTemplate(DebitTransferTransactionView debitTransferTransaction) throws ModelException{
        try {
            Vector<Object> parameters = new Vector<Object>();
            if (debitTransferTransaction == null){
                parameters.add(common.RPCConstantsAndServices.createFromClientNullProxiRepresentation());
            } else {
                parameters.add(((view.objects.ViewProxi)debitTransferTransaction).createProxiInformation());
            }
            java.util.HashMap<?,?> success = (java.util.HashMap<?,?>)this.execute(this.connectionName, "useTemplate", parameters);
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
