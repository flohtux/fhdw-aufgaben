package model.meta;

public interface AcceptedStateMssgs {
    void accept(AcceptedStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AcceptedStateDOWNMssgs extends CompensationRequestStateDOWNMssgs, AcceptedStateMssgs{}
interface AcceptedStateUPMssgs extends Mssgs, AcceptedStateMssgs{}
