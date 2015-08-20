public class Link {
	
	public String bookName;
	public int millionsSold;

	// Reference the next link in the next linkList
	public Link next;

	// Constructor
	public Link(String bookName, int millionsSold) {
		this.bookName = bookName;
		this.millionsSold = millionsSold;
	}

	// Display function
	public void display() {
		System.out.println(bookName + ": " + millionsSold + ",000,000");
	}

	public String toString() {
		return bookName;
	}

	public static void main(String[] args) {
		System.out.println("hi");
		LinkList theLinkedList = new LinkList();
		theLinkedList.insertFirstLink("Don Quixote", 500);
		theLinkedList.insertFirstLink("A tale of Two Cities", 200);
		theLinkedList.insertFirstLink("The Lord of the Rings", 150);
		theLinkedList.insertFirstLink("Harry Potter", 234);


		theLinkedList.removeFirst();
		theLinkedList.display();	
		System.out.println(theLinkedList.find("The Lord of the Rings").bookName + " was found");
		theLinkedList.removeLink("The Lord of the Rings");
		theLinkedList.display();
	}
}


class LinkList {
	public Link firstLink;

	// Constructor
	LinkList() {
		firstLink = null;
	}

	public boolean isEmpty() {
		return (firstLink == null);
	}

	// Add to front
	public void insertFirstLink(String bookName, int millionsSold) {
		Link newLink = new Link(bookName, millionsSold);
		newLink.next = firstLink;
		firstLink = newLink;
	}

	// Remove from front
	public Link removeFirst() {
		Link linkReference = firstLink;
		if(!isEmpty()) {
			firstLink = firstLink.next;
		}else {
			System.out.println("Empty LinkedList");
		}
		return linkReference;
	}

	public void display() {
		Link theLink = firstLink;
		while(theLink != null) {
			theLink.display(); // recursion?
			System.out.println("Next Link:" + theLink.next);
			theLink = theLink.next;
			System.out.println();
		}
	}

	// Search for a key
	public Link find(String bookName) {

		Link theLink = firstLink;

		if (!isEmpty()) {
			while(theLink.bookName != bookName) {
				if(theLink.next == null) {
					return null;
				}else {
					theLink = theLink.next;
				}
			}
		} else {
			System.out.println("Empty LinkedList");
		}
		return theLink;
	}

	// Remove a specific link
	// 1) Cycle through all Links until there is a match
	// 2) If the referenced Link stored in the Linkedlist's firstLink matches
				// Store the reference next in firstLink as firstLink
  // 3) If a match occurs elsewhere, find the Link thats next equals the reference to remove
  // 4) Get the reference named next in the Link to remove and assign it to the Link above
  public Link removeLink (String bookName) {
  	Link currentLink = firstLink;
  	Link previousLink = firstLink;

  	while (currentLink.bookName != bookName) {
  		if (currentLink.next == null) {
  			return null;
  		}else {
  			previousLink = currentLink;
  			currentLink = currentLink.next;
  		}
  	}

  	if(currentLink == firstLink) {
  		firstLink = firstLink.next;
  	} else {
  		previousLink.next = currentLink.next;
  	}
  	return currentLink;
  }
}





