package model.meta;

public interface CompensationRequestListeMssgsVisitor extends CompensationRequestListeDOWNMssgsVisitor, CompensationRequestListeUPMssgsVisitor {}


interface CompensationRequestListeDOWNMssgsVisitor  {

    public void handleCompensationRequestListeAddCompensationRequestMssg(CompensationRequestListeAddCompensationRequestMssg event) throws persistence.PersistenceException;
    
}


interface CompensationRequestListeUPMssgsVisitor  {

    public void handleCompensationRequestListeAddCompensationRequestMssg(CompensationRequestListeAddCompensationRequestMssg event) throws persistence.PersistenceException;
    
}
