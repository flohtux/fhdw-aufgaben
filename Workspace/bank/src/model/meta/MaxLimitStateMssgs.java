package model.meta;

public interface MaxLimitStateMssgs {
    void accept(MaxLimitStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MaxLimitStateDOWNMssgs extends LimitStateDOWNMssgs, MaxLimitStateMssgs{}
interface MaxLimitStateUPMssgs extends Mssgs, MaxLimitStateMssgs{}
