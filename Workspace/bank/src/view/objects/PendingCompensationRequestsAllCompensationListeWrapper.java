package view.objects;


/* Additional import section end */

public class PendingCompensationRequestsAllCompensationListeWrapper extends AssociationInTreeWrapper {

	public PendingCompensationRequestsAllCompensationListeWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	    public void setIcon(IconRenderer renderer) {
    	this.getWrappedObject().setIcon(renderer);
    }
	
	
	public String toString(){
    	//TODO: Implement toString in wrapper class for association pendingCompensationRequests in class AllCompensationListe
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
