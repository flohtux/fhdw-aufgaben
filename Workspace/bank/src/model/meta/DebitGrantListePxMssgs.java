package model.meta;

public interface DebitGrantListePxMssgs {
    void accept(DebitGrantListePxMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitGrantListePxDOWNMssgs extends Mssgs, DebitGrantListePxMssgs{}
interface DebitGrantListePxUPMssgs extends Mssgs, DebitGrantListePxMssgs{}
