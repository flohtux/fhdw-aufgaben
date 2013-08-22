package model.meta;

public interface DebitGrantListeMssgs {
    void accept(DebitGrantListeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitGrantListeDOWNMssgs extends Mssgs, DebitGrantListeMssgs{}
interface DebitGrantListeUPMssgs extends Mssgs, DebitGrantListeMssgs{}
