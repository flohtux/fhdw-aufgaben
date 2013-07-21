package model.meta;

public interface StornoStateMssgs {
    void accept(StornoStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StornoStateDOWNMssgs extends Mssgs, StornoStateMssgs{}
interface StornoStateUPMssgs extends RequestStateUPMssgs, NotSuccessfullStorneStateUPMssgs, NoRequestStateUPMssgs, SuccessfullStornoStateUPMssgs, StornoStateMssgs{}