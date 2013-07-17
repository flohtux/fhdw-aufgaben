package model.meta;

public interface AccountLimitStateMssgs {
    void accept(AccountLimitStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AccountLimitStateDOWNMssgs extends Mssgs, AccountLimitStateMssgs{}
interface AccountLimitStateUPMssgs extends NoLimitStateUPMssgs, LimitStateUPMssgs, AccountLimitStateMssgs{}
