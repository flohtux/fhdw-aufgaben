package model.meta;

public interface NotSuccessfullStorneStateMssgs {
    void accept(NotSuccessfullStorneStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotSuccessfullStorneStateDOWNMssgs extends StornoStateDOWNMssgs, NotSuccessfullStorneStateMssgs{}
interface NotSuccessfullStorneStateUPMssgs extends Mssgs, NotSuccessfullStorneStateMssgs{}
