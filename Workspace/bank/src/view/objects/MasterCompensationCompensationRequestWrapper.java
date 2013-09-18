package view.objects;


/* Additional import section end */

public class MasterCompensationCompensationRequestWrapper extends AssociationInTreeWrapper {

	public MasterCompensationCompensationRequestWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	    public void setIcon(IconRenderer renderer) {
    	this.getWrappedObject().setIcon(renderer);
    }
	
	
	public String toString(){
    	//TODO: Implement toString in wrapper class for association masterCompensation in class CompensationRequest
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
