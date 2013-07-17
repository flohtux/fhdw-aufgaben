package model.meta;

public interface AccountServiceMssgs {
    void accept(AccountServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AccountServiceDOWNMssgs extends ServiceDOWNMssgs, AccountServiceMssgs{}
interface AccountServiceUPMssgs extends Mssgs, AccountServiceMssgs{}
