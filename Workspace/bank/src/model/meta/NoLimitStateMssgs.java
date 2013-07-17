package model.meta;

public interface NoLimitStateMssgs {
    void accept(NoLimitStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoLimitStateDOWNMssgs extends AccountLimitStateDOWNMssgs, NoLimitStateMssgs{}
interface NoLimitStateUPMssgs extends Mssgs, NoLimitStateMssgs{}
