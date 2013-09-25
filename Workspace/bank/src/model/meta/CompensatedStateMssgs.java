package model.meta;

public interface CompensatedStateMssgs {
    void accept(CompensatedStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompensatedStateDOWNMssgs extends DebitTransferStateDOWNMssgs, CompensatedStateMssgs{}
interface CompensatedStateUPMssgs extends Mssgs, CompensatedStateMssgs{}
