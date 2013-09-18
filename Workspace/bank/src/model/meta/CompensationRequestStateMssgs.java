package model.meta;

public interface CompensationRequestStateMssgs {
    void accept(CompensationRequestStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompensationRequestStateDOWNMssgs extends Mssgs, CompensationRequestStateMssgs{}
interface CompensationRequestStateUPMssgs extends AcceptedStateUPMssgs, WaitingStateUPMssgs, DeclinedStateUPMssgs, CompensationRequestStateMssgs{}
