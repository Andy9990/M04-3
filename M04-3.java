private class TwoWayLinkedListIterator<E> implements ListIterator<E>

{

private Node<E> current = head.next;

private Node<E> lastAccessed = null;

private int index = 0;

public boolean hasNext()

{

return index < size;

}

public boolean hasPrevious()

{

return index > 0;

}

public int previousIndex()

{

return index - 1;

}

public int nextIndex()

{

return index;

}

public E next()

{

if (!hasNext())

throw new NoSuchElementException();

lastAccessed = current;

E item = current.element;

current = current.next;

index++;

return item;

}

public E previous()

{

if (!hasPrevious())

throw new NoSuchElementException();

current = current.previous;

index--;

lastAccessed = current;

return current.element;

}

public void set(E value)

{

if(lastAccessed == null)

throw new IllegalStateException();

lastAccessed.element = value;

}

public void remove()

{

if (lastAccessed == null)

throw new IllegalStateException();

Node<E> x = lastAccessed.previous;

Node<E> y = lastAccessed.next;

x.next = y;

y.previous = x;

size--;

if (current == lastAccessed)

current = y;

else

index--;

lastAccessed = null;

}

public void add(E value)

{

Node<E> x = current.previous;

Node<E> y = new Node(value);

Node<E> z = current;

x.next = y;

y.next = z;

z.previous = y;

y.previous = x;

size++;

index++;

lastAccessed = null;

}

}
