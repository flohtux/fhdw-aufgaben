package model.meta;

public interface AccountPxMssgs {
    void accept(AccountPxMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AccountPxDOWNMssgs extends Mssgs, AccountPxMssgs{}
interface AccountPxUPMssgs extends Mssgs, AccountPxMssgs{}
