/*********************************************************************
 * csce 146
 * homework02
 * @author chongwen guo
 * 
**/
public class DLLNode implements IDLLNode {

	private DLLNode next;
	private DLLNode prev;
	private Basket nodeData;
	
	public DLLNode()
	{
		
	}
	
	@Override
	public DLLNode getNext() {
		// TODO Auto-generated method stub
		return this.next;
	}

	@Override
	public void setNext(DLLNode newNext) {
		// TODO Auto-generated method stub
		this.next = newNext;
	}

	@Override
	public DLLNode getPrev() {
		// TODO Auto-generated method stub
		return this.prev;
	}

	@Override
	public void setPrev(DLLNode newPrev) {
		// TODO Auto-generated method stub
		this.prev = newPrev;
	}

	@Override
	public Basket getNodeData() {
		// TODO Auto-generated method stub
		return this.nodeData;
	}

	@Override
	public void setNodeData(Basket newData) {
		// TODO Auto-generated method stub
		this.nodeData = newData;
		
	}

}
