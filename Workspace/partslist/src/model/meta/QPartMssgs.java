package model.meta;

public interface QPartMssgs {
    void accept(QPartMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface QPartDOWNMssgs extends Mssgs, QPartMssgs{}
interface QPartUPMssgs extends Mssgs, QPartMssgs{}
