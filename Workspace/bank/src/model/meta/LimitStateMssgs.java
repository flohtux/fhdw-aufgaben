package model.meta;

public interface LimitStateMssgs {
    void accept(LimitStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LimitStateDOWNMssgs extends AccountLimitStateDOWNMssgs, LimitStateMssgs{}
interface LimitStateUPMssgs extends MinLimitStateUPMssgs, MaxLimitStateUPMssgs, LimitStateMssgs{}
