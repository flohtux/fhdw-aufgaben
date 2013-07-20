package view.objects;


/* Additional import section end */

public class StornoStateDebitNoteTransferStateWrapper extends AssociationInTreeWrapper {

	public StornoStateDebitNoteTransferStateWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	    public void setIcon(IconRenderer renderer) {
    	this.getWrappedObject().setIcon(renderer);
    }
	
	
	public String toString(){
    	//TODO: Implement toString in wrapper class for association stornoState in class DebitNoteTransferState
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
