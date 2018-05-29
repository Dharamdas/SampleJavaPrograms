package concurrent.blockingqueue;

public interface CustomBlockingQueue<E> {
	  /**
     * Inserts the specified element into this queue
     * only if space is available else
     * waits for space to become available.
     */
    void put(E item)  throws InterruptedException ;


    /**
     * Retrieves and removes the head of this queue
     * only if elements are available else
     * waits for element to become available.
     */
    E take()  throws InterruptedException;
}
