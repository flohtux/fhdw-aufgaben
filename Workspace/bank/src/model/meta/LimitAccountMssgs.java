package model.meta;

public interface LimitAccountMssgs {
    void accept(LimitAccountMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LimitAccountDOWNMssgs extends Mssgs, LimitAccountMssgs{}
interface LimitAccountUPMssgs extends Mssgs, LimitAccountMssgs{}
