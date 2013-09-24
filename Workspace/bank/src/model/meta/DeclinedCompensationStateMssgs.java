package model.meta;

public interface DeclinedCompensationStateMssgs {
    void accept(DeclinedCompensationStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DeclinedCompensationStateDOWNMssgs extends CompensationStateDOWNMssgs, DeclinedCompensationStateMssgs{}
interface DeclinedCompensationStateUPMssgs extends Mssgs, DeclinedCompensationStateMssgs{}
