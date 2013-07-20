package model.meta;

public interface SuccessfullStornoStateMssgs {
    void accept(SuccessfullStornoStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SuccessfullStornoStateDOWNMssgs extends StornoStateDOWNMssgs, SuccessfullStornoStateMssgs{}
interface SuccessfullStornoStateUPMssgs extends Mssgs, SuccessfullStornoStateMssgs{}
