package model.meta;

public interface DebitGrantMssgs {
    void accept(DebitGrantMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitGrantDOWNMssgs extends Mssgs, DebitGrantMssgs{}
interface DebitGrantUPMssgs extends Mssgs, DebitGrantMssgs{}
