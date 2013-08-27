package model.meta;

public interface DebitTransferListeMssgs {
    void accept(DebitTransferListeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitTransferListeDOWNMssgs extends Mssgs, DebitTransferListeMssgs{}
interface DebitTransferListeUPMssgs extends Mssgs, DebitTransferListeMssgs{}
