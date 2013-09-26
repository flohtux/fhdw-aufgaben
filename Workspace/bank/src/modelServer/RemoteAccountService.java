
package modelServer;


import model.*;
import persistence.*;

public  class RemoteAccountService extends RemoteService {

	
	public RemoteAccountService(String connectionName, String userName, PersistentAccountService server){
		super (connectionName, userName , server);
	}

	 

    @SuppressWarnings("unchecked")
    public synchronized java.util.HashMap<?,?> a_Path_In_AnswerAccept(){
        try {
            PersistentCompensationRequestListe result = ((PersistentAccountService)this.server).a_Path_In_AnswerAccept();
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> debitTransfer_Path_In_AddToTransactionTemplate(){
        try {
            DebitTransferTransactionSearchList result = ((PersistentAccountService)this.server).debitTransfer_Path_In_AddToTransactionTemplate();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> debitTransfer_Path_In_AddToTransaction(){
        try {
            DebitTransferTransactionSearchList result = ((PersistentAccountService)this.server).debitTransfer_Path_In_AddToTransaction();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> debitTransfer_Path_In_RemoveFromTransaction(String transactionProxiString){
        try {
            PersistentTransaction transaction = (PersistentTransaction)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transactionProxiString));
            DebitTransferSearchList result = ((PersistentAccountService)this.server).debitTransfer_Path_In_RemoveFromTransaction(transaction);
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> dtr_Path_In_RequestCompensation(){
        try {
            DebitTransferTransactionSearchList result = ((PersistentAccountService)this.server).dtr_Path_In_RequestCompensation();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.HashMap<?,?> grant_Path_In_Remove(){
        try {
            PersistentDebitGrantListe result = ((PersistentAccountService)this.server).grant_Path_In_Remove();
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addToTransactionTemplate(String transactionProxiString, java.util.Vector<String> debitTransferTrnsprt){
        try {
            PersistentTransaction transaction = (PersistentTransaction)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transactionProxiString));
            DebitTransferSearchList debitTransfer = new DebitTransferSearchList();
			java.util.Iterator<String> debitTransferItrtr = debitTransferTrnsprt.iterator();
			while (debitTransferItrtr.hasNext()){
				PersistentDebitTransfer currentProxi = (PersistentDebitTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(debitTransferItrtr.next()));
				debitTransfer.add(currentProxi);
			}
            ((PersistentAccountService)this.server).addToTransactionTemplate(transaction, debitTransfer);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addToTransactionTrigger(String transactionProxiString, String type){
        try {
            PersistentTransaction transaction = (PersistentTransaction)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transactionProxiString));
            ((PersistentAccountService)this.server).addToTransactionTrigger(transaction, type);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addToTransaction(String transactionProxiString, java.util.Vector<String> debitTransferTrnsprt){
        try {
            PersistentTransaction transaction = (PersistentTransaction)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transactionProxiString));
            DebitTransferSearchList debitTransfer = new DebitTransferSearchList();
			java.util.Iterator<String> debitTransferItrtr = debitTransferTrnsprt.iterator();
			while (debitTransferItrtr.hasNext()){
				PersistentDebitTransfer currentProxi = (PersistentDebitTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(debitTransferItrtr.next()));
				debitTransfer.add(currentProxi);
			}
            ((PersistentAccountService)this.server).addToTransaction(transaction, debitTransfer);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> answerAcceptWithTrigger(String aProxiString){
        try {
            PersistentCompensationRequest a = (PersistentCompensationRequest)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aProxiString));
            ((PersistentAccountService)this.server).answerAcceptWithTrigger(a);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> answerAccept(String aProxiString){
        try {
            PersistentCompensationRequest a = (PersistentCompensationRequest)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aProxiString));
            ((PersistentAccountService)this.server).answerAccept(a);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> answerDecline(String aProxiString){
        try {
            PersistentCompensationRequest a = (PersistentCompensationRequest)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aProxiString));
            ((PersistentAccountService)this.server).answerDecline(a);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeCurrency(String transProxiString, String currency){
        try {
            PersistentDebitTransfer trans = (PersistentDebitTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transProxiString));
            ((PersistentAccountService)this.server).changeCurrency(trans, currency);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeIncomingAccountRuleAccountNumber(String ruleProxiString, String newAccNumAsString){
        try {
            PersistentIncomingAccountRule rule = (PersistentIncomingAccountRule)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(ruleProxiString));
            long newAccNum = new Long(newAccNumAsString).longValue();
            ((PersistentAccountService)this.server).changeIncomingAccountRuleAccountNumber(rule, newAccNum);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeIncomingAccountRuleBankNumber(String ruleProxiString, String newBankNumAsString){
        try {
            PersistentIncomingAccountRule rule = (PersistentIncomingAccountRule)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(ruleProxiString));
            long newBankNum = new Long(newBankNumAsString).longValue();
            ((PersistentAccountService)this.server).changeIncomingAccountRuleBankNumber(rule, newBankNum);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeMoneyRuleMax(String ruleProxiString, String maxValueAsString){
        try {
            PersistentMoneyRule rule = (PersistentMoneyRule)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(ruleProxiString));
            common.Fraction maxValue = common.Fraction.parse(maxValueAsString);
            ((PersistentAccountService)this.server).changeMoneyRuleMax(rule, maxValue);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeMoneyRuleMin(String ruleProxiString, String minValueAsString){
        try {
            PersistentMoneyRule rule = (PersistentMoneyRule)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(ruleProxiString));
            common.Fraction minValue = common.Fraction.parse(minValueAsString);
            ((PersistentAccountService)this.server).changeMoneyRuleMin(rule, minValue);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeMoney(String transProxiString, String newAmountAsString){
        try {
            PersistentDebitTransfer trans = (PersistentDebitTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transProxiString));
            common.Fraction newAmount = common.Fraction.parse(newAmountAsString);
            ((PersistentAccountService)this.server).changeMoney(trans, newAmount);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changePassword(String newPassword1, String newPassword2){
        try {
            String result = ((PersistentAccountService)this.server).changePassword(newPassword1, newPassword2);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.PasswordException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeReceiverAccount(String transProxiString, String receiverAccNumberAsString){
        try {
            PersistentDebitTransfer trans = (PersistentDebitTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transProxiString));
            long receiverAccNumber = new Long(receiverAccNumberAsString).longValue();
            ((PersistentAccountService)this.server).changeReceiverAccount(trans, receiverAccNumber);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeReceiverBank(String transProxiString, String receiverBankNumberAsString){
        try {
            PersistentDebitTransfer trans = (PersistentDebitTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transProxiString));
            long receiverBankNumber = new Long(receiverBankNumberAsString).longValue();
            ((PersistentAccountService)this.server).changeReceiverBank(trans, receiverBankNumber);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeSubjectRuleSubject(String ruleProxiString, String newSubject){
        try {
            PersistentSubjectRule rule = (PersistentSubjectRule)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(ruleProxiString));
            ((PersistentAccountService)this.server).changeSubjectRuleSubject(rule, newSubject);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> changeSubject(String transProxiString, String subject){
        try {
            PersistentDebitTransfer trans = (PersistentDebitTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transProxiString));
            ((PersistentAccountService)this.server).changeSubject(trans, subject);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.HashMap<?,?> checkMoneyRuleMax(String ruleProxiString, String maxValueAsString){
        try {
            PersistentMoneyRule rule = (PersistentMoneyRule)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(ruleProxiString));
            common.Fraction maxValue = common.Fraction.parse(maxValueAsString);
            PersistentBooleanValue result = ((PersistentAccountService)this.server).checkMoneyRuleMax(rule, maxValue);
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    @SuppressWarnings("unchecked")
    public synchronized java.util.HashMap<?,?> checkMoneyRuleMin(String ruleProxiString, String minValueAsString){
        try {
            PersistentMoneyRule rule = (PersistentMoneyRule)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(ruleProxiString));
            common.Fraction minValue = common.Fraction.parse(minValueAsString);
            PersistentBooleanValue result = ((PersistentAccountService)this.server).checkMoneyRuleMin(rule, minValue);
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createDebitGrant(String receiverAccNumberAsString, String receiverBankNumberAsString, String limitType, String amountAsString, String cur){
        try {
            long receiverAccNumber = new Long(receiverAccNumberAsString).longValue();
            long receiverBankNumber = new Long(receiverBankNumberAsString).longValue();
            common.Fraction amount = common.Fraction.parse(amountAsString);
            ((PersistentAccountService)this.server).createDebitGrant(receiverAccNumber, receiverBankNumber, limitType, amount, cur);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.GrantAlreadyGivenException e0){
            return createExceptionResult(e0, this);
        }catch(model.InvalidBankNumberException e1){
            return createExceptionResult(e1, this);
        }catch(model.InvalidAccountNumberException e2){
            return createExceptionResult(e2, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createDebit(){
        try {
            ((PersistentAccountService)this.server).createDebit();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createNewRule(String tProxiString, String type){
        try {
            PersistentTrigger t = (PersistentTrigger)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(tProxiString));
            ((PersistentAccountService)this.server).createNewRule(t, type);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.DoubleRuleDefinitionException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createTemplate(String type){
        try {
            ((PersistentAccountService)this.server).createTemplate(type);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createTransaction(){
        try {
            ((PersistentAccountService)this.server).createTransaction();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createTransfer(){
        try {
            ((PersistentAccountService)this.server).createTransfer();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createTrigger(String name, String type){
        try {
            ((PersistentAccountService)this.server).createTrigger(name, type);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> disable(String tProxiString){
        try {
            PersistentTrigger t = (PersistentTrigger)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(tProxiString));
            ((PersistentAccountService)this.server).disable(t);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> enable(String tProxiString){
        try {
            PersistentTrigger t = (PersistentTrigger)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(tProxiString));
            ((PersistentAccountService)this.server).enable(t);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NoRuleDefinitionException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> executeTransfer(String debitTransferProxiString){
        try {
            PersistentDebitTransferTransaction debitTransfer = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(debitTransferProxiString));
            ((PersistentAccountService)this.server).executeTransfer(debitTransfer);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NoPermissionToExecuteDebitTransferException e0){
            return createExceptionResult(e0, this);
        }catch(model.ExecuteException e1){
            return createExceptionResult(e1, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeFromTransaction(String transactionProxiString, java.util.Vector<String> debitTransferTrnsprt){
        try {
            PersistentTransaction transaction = (PersistentTransaction)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transactionProxiString));
            DebitTransferSearchList debitTransfer = new DebitTransferSearchList();
			java.util.Iterator<String> debitTransferItrtr = debitTransferTrnsprt.iterator();
			while (debitTransferItrtr.hasNext()){
				PersistentDebitTransfer currentProxi = (PersistentDebitTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(debitTransferItrtr.next()));
				debitTransfer.add(currentProxi);
			}
            ((PersistentAccountService)this.server).removeFromTransaction(transaction, debitTransfer);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> remove(String grantProxiString){
        try {
            PersistentDebitGrant grant = (PersistentDebitGrant)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(grantProxiString));
            ((PersistentAccountService)this.server).remove(grant);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NoPermissionToRemoveDebitGrantException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> requestCompensation(String dtrProxiString){
        try {
            PersistentDebitTransferTransaction dtr = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(dtrProxiString));
            ((PersistentAccountService)this.server).requestCompensation(dtr);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> useTemplate(String debitTransferTransactionProxiString){
        try {
            PersistentDebitTransferTransaction debitTransferTransaction = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(debitTransferTransactionProxiString));
            ((PersistentAccountService)this.server).useTemplate(debitTransferTransaction);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}