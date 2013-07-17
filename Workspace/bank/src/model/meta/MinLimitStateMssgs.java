package model.meta;

public interface MinLimitStateMssgs {
    void accept(MinLimitStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MinLimitStateDOWNMssgs extends LimitStateDOWNMssgs, MinLimitStateMssgs{}
interface MinLimitStateUPMssgs extends Mssgs, MinLimitStateMssgs{}
