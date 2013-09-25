package model;

import model.meta.CompensationRequestChangeStateCompensationRequestStateMssg;
import model.meta.CompensationRequestMssgsVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.CompensationRequestStateReturnExceptionVisitor;
import model.visitor.DebitTransferTransactionReturnVisitor;
import model.visitor.DebitTransferTransactionVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Aggregtion;
import persistence.AggregtionException;
import persistence.Anything;
import persistence.CompensationProxi;
import persistence.ConnectionHandler;
import persistence.DebitTransferSearchList;
import persistence.Invoker;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAcceptedState;
import persistence.PersistentAccount;
import persistence.PersistentBank;
import persistence.PersistentBooleanValue;
import persistence.PersistentCompensation;
import persistence.PersistentCompensationPendingRequests;
import persistence.PersistentCompensationRequest;
import persistence.PersistentCompensationState;
import persistence.PersistentDebit;
import persistence.PersistentDebitTransfer;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentDeclinedState;
import persistence.PersistentExecuteCompensationCommand;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentTransaction;
import persistence.PersistentTransfer;
import persistence.PersistentWaitingState;
import persistence.Predcate;
import persistence.Procdure;
import persistence.SubjInterface;
import persistence.TDObserver;

/* Additional import section end */

public class Compensation extends PersistentObject implements PersistentCompensation{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentCompensation getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCompensationFacade.getClass(objectId);
        return (PersistentCompensation)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentCompensation createCompensation(PersistentAccount requestingAccount) throws PersistenceException{
        return createCompensation(requestingAccount,false);
    }
    
    public static PersistentCompensation createCompensation(PersistentAccount requestingAccount,boolean delayed$Persistence) throws PersistenceException {
        PersistentCompensation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationFacade
                .newDelayedCompensation();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationFacade
                .newCompensation(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("requestingAccount", requestingAccount);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCompensation createCompensation(PersistentAccount requestingAccount,boolean delayed$Persistence,PersistentCompensation This) throws PersistenceException {
        PersistentCompensation result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCompensationFacade
                .newDelayedCompensation();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCompensationFacade
                .newCompensation(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("requestingAccount", requestingAccount);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot requestingAccount = (AbstractPersistentRoot)this.getRequestingAccount();
            if (requestingAccount != null) {
                result.put("requestingAccount", requestingAccount.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    requestingAccount.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && requestingAccount.hasEssentialFields())requestingAccount.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("pendingRequests", this.getPendingRequests().getObservee().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            AbstractPersistentRoot state = (AbstractPersistentRoot)this.getState();
            if (state != null) {
                result.put("state", state.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    state.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && state.hasEssentialFields())state.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Compensation provideCopy() throws PersistenceException{
        Compensation result = this;
        result = new Compensation(this.requestingAccount, 
                                  this.pendingRequests, 
                                  this.state, 
                                  this.subService, 
                                  this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount requestingAccount;
    protected PersistentCompensationPendingRequests pendingRequests;
    protected PersistentCompensationState state;
    protected SubjInterface subService;
    protected PersistentCompensation This;
    
    public Compensation(PersistentAccount requestingAccount,PersistentCompensationPendingRequests pendingRequests,PersistentCompensationState state,SubjInterface subService,PersistentCompensation This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.requestingAccount = requestingAccount;
        this.pendingRequests = pendingRequests;
        this.state = state;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 254;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 254) ConnectionHandler.getTheConnectionHandler().theCompensationFacade
            .newCompensation(this.getId());
        super.store();
        if(this.getRequestingAccount() != null){
            this.getRequestingAccount().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.requestingAccountSet(this.getId(), getRequestingAccount());
        }
        if(this.pendingRequests != null){
            this.pendingRequests.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.pendingRequestsSet(this.getId(), pendingRequests);
        }
        if(this.getState() != null){
            this.getState().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.stateSet(this.getId(), getState());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAccount getRequestingAccount() throws PersistenceException {
        return this.requestingAccount;
    }
    public void setRequestingAccount(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.requestingAccount)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.requestingAccount = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.requestingAccountSet(this.getId(), newValue);
        }
    }
    protected void setPendingRequests(PersistentCompensationPendingRequests newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.pendingRequests)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.pendingRequests = (PersistentCompensationPendingRequests)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.pendingRequestsSet(this.getId(), newValue);
        }
    }
    public PersistentCompensationState getState() throws PersistenceException {
        return this.state;
    }
    public void setState(PersistentCompensationState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.state)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.state = (PersistentCompensationState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.stateSet(this.getId(), newValue);
        }
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentCompensation newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentCompensation)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCompensationFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentCompensation getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCompensation result = new CompensationProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCompensation)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensation(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensation(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensation(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensation(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensation(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getRequestingAccount() != null) return 1;
        if (this.getPendingRequests().getObservee().getLength() > 0) return 1;
        if (this.getState() != null) return 1;
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void executeCompensation(final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentExecuteCompensationCommand command = model.meta.ExecuteCompensationCommand.createExecuteCompensationCommand(now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public PersistentCompensationPendingRequests getPendingRequests() 
				throws PersistenceException{
        if (this.pendingRequests == null) {
			this.setPendingRequests(model.CompensationPendingRequests.createCompensationPendingRequests(this.isDelayed$Persistence()));
			this.pendingRequests.setObserver(this);
		}
		return this.pendingRequests;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCompensation)This);
		if(this.equals(This)){
			this.setRequestingAccount((PersistentAccount)final$$Fields.get("requestingAccount"));
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public PersistentBooleanValue allAnswered() 
				throws model.CompensationAbortedException, PersistenceException{
		return getThis().getPendingRequests().aggregateException(
				new AggregtionException<PersistentCompensationRequest, PersistentBooleanValue, CompensationAbortedException>() {
					public PersistentBooleanValue neutral() throws PersistenceException {
						return TrueValue.getTheTrueValue();
					}

					public PersistentBooleanValue compose(PersistentBooleanValue result, PersistentCompensationRequest argument) throws PersistenceException,
							CompensationAbortedException {
						PersistentBooleanValue booleanResult = result.and(argument.getState().accept(
								new CompensationRequestStateReturnExceptionVisitor<PersistentBooleanValue, CompensationAbortedException>() {
									public PersistentBooleanValue handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException,
											CompensationAbortedException {
										return TrueValue.getTheTrueValue();
									}

									public PersistentBooleanValue handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException,
											CompensationAbortedException {
										return FalseValue.getTheFalseValue();
									}

									public PersistentBooleanValue handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException,
											CompensationAbortedException {
										getThis().setState(DeclinedCompensationState.getTheDeclinedCompensationState());
										throw new CompensationAbortedException(getThis(), serverConstants.ExceptionMessages.CompensationAbortOneDecline);
									}
								}));
						if(booleanResult.isTrue()) {
							getThis().setState(SuccessfulCompensationState.getTheSuccessfulCompensationState());
						}
						return booleanResult;
					}
				});
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void executeCompensation() 
				throws PersistenceException{
		PersistentTransaction transactionToBeExecuted = getThis().getPendingRequests().aggregate(
				new Aggregtion<PersistentCompensationRequest, PersistentTransaction>() {
					public PersistentTransaction neutral() throws PersistenceException {
						return Transaction.createTransaction();
					}

					public PersistentTransaction compose(PersistentTransaction result, PersistentCompensationRequest argument) throws PersistenceException {
						DebitTransferSearchList sl = argument.getDebitTransfer().accept(
								new DebitTransferTransactionReturnVisitor<DebitTransferSearchList>() {
									public DebitTransferSearchList handleTransfer(PersistentTransfer transfer) throws PersistenceException {
										DebitTransferSearchList list = new DebitTransferSearchList();
										list.add(transfer);
										return list;
									}

									public DebitTransferSearchList handleDebit(PersistentDebit debit) throws PersistenceException {
										DebitTransferSearchList list = new DebitTransferSearchList();
										list.add(debit);
										return list;
									}

									public DebitTransferSearchList handleTransaction(PersistentTransaction transaction) throws PersistenceException {
										return transaction.getDebitTransfer().getDebitTransfers().getList();
									}
								});
						result.addToTransactionWithoutStateChange(sl);
						return result;
					}
				});
		transactionToBeExecuted.changeState(CompensatedState.createCompensatedState());
		transactionToBeExecuted.getDebitTransfer().getDebitTransfers().applyToAll(new Procdure<PersistentDebitTransfer>() {
			public void doItTo(PersistentDebitTransfer argument) throws PersistenceException {
				argument.changeState(CompensatedState.createCompensatedState());
			}
		});
		
		try {
			System.out.println("trans state" + transactionToBeExecuted.getState());
			PersistentTransaction t = transactionToBeExecuted.mirror();
			System.out.println("transfer state" + t.getDebitTransfer().getDebitTransfers().findFirst(new Predcate<PersistentDebitTransfer>() {
				public boolean test(PersistentDebitTransfer argument) throws PersistenceException {
					return true;
				}
			}).getState());
			t.execute(getThis().getRequestingAccount(), getThis().getRequestingAccount().getAccountService());
		} catch (AccountSearchException e) {
			getThis().getRequestingAccount().compensationDeclined(getThis(), e.getMessage(), getThis().getRequestingAccount().getAccountService());
		}

	}
    public void initializeDebitTransferTransaction(final PersistentDebitTransferTransaction dtt) 
				throws PersistenceException{
		dtt.accept(new DebitTransferTransactionVisitor() {
			@Override
			public void handleTransfer(PersistentTransfer transfer) throws PersistenceException {
				getThis().requestCompensationForDebitTransfer(transfer);
			}

			@Override
			public void handleDebit(PersistentDebit debit) throws PersistenceException {
				getThis().requestCompensationForDebitTransfer(debit);
			}

			@Override
			public void handleTransaction(PersistentTransaction transaction) throws PersistenceException {
				getThis().requestCompensationForDebitTransfers(transaction.getDebitTransfer().getDebitTransfers().getList());
			}
		});
	}
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setState(WaitingCompensationState.getTheWaitingCompensationState());
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public void pendingRequests_update(final model.meta.CompensationRequestMssgs event) 
				throws PersistenceException{
    	event.accept(new CompensationRequestMssgsVisitor() {
			@Override
			public void handleCompensationRequestChangeStateCompensationRequestStateMssg(
					CompensationRequestChangeStateCompensationRequestStateMssg event)
					throws PersistenceException {
//				Boolean execute = getThis().getPendingRequests().aggregate(new Aggregtion<PersistentCompensationRequest, Boolean>() {
//					public Boolean neutral() throws PersistenceException {
//						return true;
//					}
//
//					public Boolean compose(Boolean result, PersistentCompensationRequest argument) throws PersistenceException {
//						return result && argument.getState().accept(new CompensationRequestStateReturnVisitor<Boolean>() {
//							public Boolean handleAcceptedState(PersistentAcceptedState acceptedState) throws PersistenceException {
//								return true;
//							}
//
//							public Boolean handleWaitingState(PersistentWaitingState waitingState) throws PersistenceException {
//								return false;
//							}
//
//							public Boolean handleDeclinedState(PersistentDeclinedState declinedState) throws PersistenceException {
//								return false;
//							}
//
//						});
//					}
//				});
				try {
					if (getThis().allAnswered().isTrue()) {
//						if (execute) {
						System.out.println("all answered");
							getThis().executeCompensation(getThis().getRequestingAccount().getAccountService());
//						}
					}
				} catch (CompensationAbortedException e) {
					getThis().getRequestingAccount().compensationDeclined(getThis(), e.getMessage(), getThis().getRequestingAccount().getAccountService());
				}
			}
		});
	}
    public void requestCompensationForDebitTransferTransaction(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
    	debitTransferTransaction.changeState(CompensatedState.createCompensatedState());
        debitTransferTransaction.accept(new DebitTransferTransactionVisitor() {
			@Override
			public void handleTransfer(PersistentTransfer transfer)
					throws PersistenceException {
				getThis().requestCompensationForDebitTransfer(transfer);
			}
			
			@Override
			public void handleDebit(PersistentDebit debit) throws PersistenceException {
				getThis().requestCompensationForDebitTransfer(debit);
			}
			
			@Override
			public void handleTransaction(PersistentTransaction transaction)
					throws PersistenceException {
				getThis().requestCompensationForDebitTransfers(transaction.getDebitTransfer().getDebitTransfers().getList());
				
			}
		});        
    }
    public void requestCompensationForDebitTransfers(final DebitTransferSearchList debitTransfers) 
				throws PersistenceException{
		debitTransfers.applyToAll(new Procdure<PersistentDebitTransfer>() {
			@Override
			public void doItTo(PersistentDebitTransfer argument) throws PersistenceException {
				getThis().requestCompensationForDebitTransfer(argument);
			}
		});

	}
    public void requestCompensationForDebitTransfer(final PersistentDebitTransfer debitTransfer) 
				throws PersistenceException{
    	debitTransfer.changeState(CompensatedState.createCompensatedState());
    	PersistentCompensationRequest result = getThis().getPendingRequests().findFirst(new Predcate<PersistentCompensationRequest>() {
			@Override
			public boolean test(PersistentCompensationRequest argument)
					throws PersistenceException {
				return argument.getDebitTransfer().equals(debitTransfer);
			}
		});
    	if(result == null) {
	    	PersistentCompensationRequest newRequest = CompensationRequest.createCompensationRequest(debitTransfer, getThis());
		    newRequest.setDebitTransfer(debitTransfer);
		    debitTransfer.getSender().getAllCompensation().getPendingCompensationRequests().add(newRequest);
		    getThis().getPendingRequests().add(newRequest);
		
		    try {
			     PersistentBank b = getThis().getRequestingAccount().getBank().getAdministrator().searchBankByBankNumber(debitTransfer.getReceiverBankNumber());
			     PersistentAccount acc = b.searchAccountByAccNumber(debitTransfer.getReceiverAccountNumber());
			     PersistentCompensationRequest newRequest2 = CompensationRequest.createCompensationRequest(debitTransfer, getThis());
			     newRequest2.setDebitTransfer(debitTransfer);
			
			     acc.getAllCompensation().getPendingCompensationRequests().add(newRequest2);
			     getThis().getPendingRequests().add(newRequest2);
		   } catch (ExecuteException e) {
		      getThis().getRequestingAccount().compensationDeclined(getThis(), e.getMessage(), getThis().getRequestingAccount().getAccountService());
		   } 
    	}
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
