package model.meta;

public interface DeclinedStateMssgs {
    void accept(DeclinedStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DeclinedStateDOWNMssgs extends CompensationRequestStateDOWNMssgs, DeclinedStateMssgs{}
interface DeclinedStateUPMssgs extends Mssgs, DeclinedStateMssgs{}
