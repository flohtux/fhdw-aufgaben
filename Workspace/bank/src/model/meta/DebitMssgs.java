package model.meta;

public interface DebitMssgs {
    void accept(DebitMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitDOWNMssgs extends DebitTransferDOWNMssgs, DebitMssgs{}
interface DebitUPMssgs extends Mssgs, DebitMssgs{}
