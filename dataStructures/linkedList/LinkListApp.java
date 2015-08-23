class Link {

	public int iData; // data item
	public double dData; // data item
	public Link next; // next link in list
	//---------------------------------------------
	// Constructor
	public Link(int id, double dd) {
		iData = id;
		dData = dd;
		next = null;
	}
	//---------------------------------------------
	// Display ourself
	public void displayLink() {
		System.out.print("{" + iData + ", " + dData + "} ");
	}

}

/*
This class supports:
1) Inserting an item at the beginning of the list
2) Deleting the item at the beginning of the list
3) Iterating through the list to display its contents
*/
class LinkList {

	private Link first; // Reference to the first link on list

	//---------------------------------------------
	// Constructor
	public void LinkList() {
		first = null; // No items on list yet
	}
	//---------------------------------------------
	public boolean isEmpty() { // True if list empty
		return (first==null);
	}
	//---------------------------------------------
	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}
	//---------------------------------------------
	// Assume list not empty
	// Return what we delete
	// Java garbage collects the unreferenced removed node
	public Link deleteFirst() {
		//if( !isEmpty()) {
			Link temp = first; // Save reference to link
			first = first.next;
			return temp;
	//}
	}
// ------------------------------------------
// Display the whole list
	public void displayList() {
	System.out.println("List (first --> last)");
	
	Link current = first;
	while(current != null) {
		current.displayLink();
		current = current.next;
	}
	System.out.println("");

	}
}

class LinkListApp {
	public static void main(String[] args) {
		LinkList theList = new LinkList();
		theList.insertFirst(1, 2.99);
		theList.insertFirst(2, 2.99);
		theList.insertFirst(3, 2.99);
		theList.insertFirst(4, 2.99);
		theList.insertFirst(5, 2.99);

		theList.displayList();
	

	// Delete
	while( !theList.isEmpty() ){
		Link aLink = theList.deleteFirst();
		System.out.print("Deleted ");
		aLink.displayLink();
		System.out.println("");
	}
	theList.displayList();
	}
}
