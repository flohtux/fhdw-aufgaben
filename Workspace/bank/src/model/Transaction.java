package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.DebitTransferStateReturnVisitor;
import model.visitor.DebitTransferTransactionExceptionVisitor;
import model.visitor.DebitTransferTransactionReturnExceptionVisitor;
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
import persistence.ConnectionHandler;
import persistence.DebitTransferSearchList;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentBooleanValue;
import persistence.PersistentDebitTransfer;
import persistence.PersistentDebitTransferListe;
import persistence.PersistentDebitTransferState;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentExecutedState;
import persistence.PersistentNotExecutableState;
import persistence.PersistentNotExecutedState;
import persistence.PersistentNotSuccessfulState;
import persistence.PersistentProxi;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransaction;
import persistence.Predcate;
import persistence.Procdure;
import persistence.ProcdureException;
import persistence.SubjInterface;
import persistence.TDObserver;
import persistence.TransactionProxi;

/* Additional import section end */

public class Transaction extends model.DebitTransferTransaction implements PersistentTransaction{
    
    
    public static PersistentTransaction createTransaction() throws PersistenceException{
        return createTransaction(false);
    }
    
    public static PersistentTransaction createTransaction(boolean delayed$Persistence) throws PersistenceException {
        PersistentTransaction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransactionFacade
                .newDelayedTransaction(new java.sql.Timestamp(System.currentTimeMillis()),"");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransactionFacade
                .newTransaction(new java.sql.Timestamp(System.currentTimeMillis()),"",-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentTransaction createTransaction(boolean delayed$Persistence,PersistentTransaction This) throws PersistenceException {
        PersistentTransaction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransactionFacade
                .newDelayedTransaction(new java.sql.Timestamp(System.currentTimeMillis()),"");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransactionFacade
                .newTransaction(new java.sql.Timestamp(System.currentTimeMillis()),"",-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot debitTransfer = (AbstractPersistentRoot)this.getDebitTransfer();
            if (debitTransfer != null) {
                result.put("debitTransfer", debitTransfer.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    debitTransfer.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && debitTransfer.hasEssentialFields())debitTransfer.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Transaction provideCopy() throws PersistenceException{
        Transaction result = this;
        result = new Transaction(this.timestamp, 
                                 this.subject, 
                                 this.sender, 
                                 this.state, 
                                 this.subService, 
                                 this.This, 
                                 this.debitTransfer, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentDebitTransferListe debitTransfer;
    
    public Transaction(java.sql.Timestamp timestamp,String subject,PersistentAccount sender,PersistentDebitTransferState state,SubjInterface subService,PersistentDebitTransferTransaction This,PersistentDebitTransferListe debitTransfer,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((java.sql.Timestamp)timestamp,(String)subject,(PersistentAccount)sender,(PersistentDebitTransferState)state,(SubjInterface)subService,(PersistentDebitTransferTransaction)This,id);
        this.debitTransfer = debitTransfer;        
    }
    
    static public long getTypeId() {
        return 146;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 146) ConnectionHandler.getTheConnectionHandler().theTransactionFacade
            .newTransaction(new java.sql.Timestamp(System.currentTimeMillis()),"",this.getId());
        super.store();
        if(this.getDebitTransfer() != null){
            this.getDebitTransfer().store();
            ConnectionHandler.getTheConnectionHandler().theTransactionFacade.debitTransferSet(this.getId(), getDebitTransfer());
        }
        
    }
    
    public PersistentDebitTransferListe getDebitTransfer() throws PersistenceException {
        return this.debitTransfer;
    }
    public void setDebitTransfer(PersistentDebitTransferListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.debitTransfer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.debitTransfer = (PersistentDebitTransferListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransactionFacade.debitTransferSet(this.getId(), newValue);
        }
    }
    public PersistentTransaction getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTransaction result = new TransactionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentTransaction)this.This;
    }
    
    public void accept(DebitTransferTransactionVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getState() != null) return 1;
        if (this.getDebitTransfer() != null && this.getDebitTransfer().getTheObject().getLeafInfo() != 0) return 1;
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
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentTransaction)This);
		if(this.equals(This)){
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
    
    public void addToTransaction(final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
		debitTransfer.applyToAll(new Procdure<PersistentDebitTransfer>() {
			@Override
			public void doItTo(PersistentDebitTransfer argument) throws PersistenceException {
				if (!getThis().contains(argument).isTrue()) {
					getThis().getDebitTransfer().getDebitTransfers().add(argument);
					argument.changeState(NotSuccessfulState.createNotSuccessfulState());
				}
			}
		});
	}
    public PersistentBooleanValue contains(final PersistentDebitTransferTransaction debitTransfer) 
				throws PersistenceException{
		PersistentDebitTransfer result = getThis().getDebitTransfer().getDebitTransfers().findFirst(new Predcate<PersistentDebitTransfer>() {
			public boolean test(PersistentDebitTransfer argument) throws PersistenceException {
				return argument.equals(debitTransfer);
			}
		});
		if (result != null) {
			return TrueValue.getTheTrueValue();
		} else {
			return FalseValue.getTheFalseValue();
		}
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		getThis().setDebitTransfer(DebitTransferListe.createDebitTransferListe());
		getThis().setState(NotExecutedState.createNotExecutedState());
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public PersistentTransaction mirror() 
				throws model.AccountSearchException, PersistenceException{
		return getThis().getDebitTransfer().getDebitTransfers()
				.aggregateException(new AggregtionException<PersistentDebitTransfer, PersistentTransaction, AccountSearchException>() {
					public PersistentTransaction neutral() throws PersistenceException {
						return Transaction.createTransaction();
					}

					public PersistentTransaction compose(PersistentTransaction result, PersistentDebitTransfer argument) throws PersistenceException,
							AccountSearchException {
						DebitTransferSearchList a = new DebitTransferSearchList();
						a.add(argument.mirror());
						result.addToTransaction(a);
						return result;
					}
				});
	}
    public void removeFromTransaction(final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
		debitTransfer.applyToAll(new Procdure<PersistentDebitTransfer>() {
			@Override
			public void doItTo(final PersistentDebitTransfer argument) throws PersistenceException {
				getThis().getDebitTransfer().getDebitTransfers().removeFirstSuccess(new Predcate<PersistentDebitTransfer>() {
					@Override
					public boolean test(PersistentDebitTransfer argument2) throws PersistenceException {
						return argument.equals(argument2);
					}
				});
			}
		});

	}
    
    
    // Start of section that contains overridden operations only.
    
    public PersistentDebitTransferTransaction copy() 
				throws PersistenceException{
		final PersistentTransaction result = Transaction.createTransaction();
		result.setSender(getThis().getSender());
		result.setSubject(getThis().getSubject());
		result.setTimestamp(getThis().getTimestamp());
		result.setState(getThis().getState().copy());
		getThis().getDebitTransfer().getDebitTransfers().applyToAll(new Procdure<PersistentDebitTransfer>() {
			@Override
			public void doItTo(PersistentDebitTransfer argument) throws PersistenceException {
				result.getDebitTransfer().getDebitTransfers().add(argument.copyDebitTransfer());
			}
		});
		return result;
	}
    public PersistentDebitTransferTransaction executeImplementation() 
				throws model.ExecuteException, PersistenceException{
		getThis().getDebitTransfer().getDebitTransfers().applyToAllException(new ProcdureException<PersistentDebitTransfer, ExecuteException>() {
			@Override
			public void doItTo(PersistentDebitTransfer argument) throws PersistenceException, ExecuteException {
				argument.execute();
			}
		});
		getThis().changeState(SuccessfulState.createSuccessfulState());
		return getThis();
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
