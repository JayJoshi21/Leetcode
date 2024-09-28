class MyCircularDeque {

    private int[] deq;         // Array to store deque elements
    private int K;             // Maximum capacity of the deque
    private int front;         // Pointer to the front of the deque
    private int rear;          // Pointer to the rear of the deque
    private int currentCount;  // Current number of elements in the deque

    // Constructor to initialize the deque with the given capacity
    public MyCircularDeque(int k) {
        K = k;
        deq = new int[K];      // Initialize array with capacity K
        front = 0;
        rear = K - 1;
        currentCount = 0;
    }

    // Insert element at the front of the deque
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + K) % K;
        deq[front] = value;
        currentCount++;
        return true;
    }

    // Insert element at the rear of the deque
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % K;
        deq[rear] = value;
        currentCount++;
        return true;
    }

    // Delete element from the front of the deque
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % K;
        currentCount--;
        return true;
    }

    // Delete element from the rear of the deque
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + K) % K;
        currentCount--;
        return true;
    }

    // Get the front element of the deque
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deq[front];
    }

    // Get the rear element of the deque
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deq[rear];
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return currentCount == 0;
    }

    // Check if the deque is full
    public boolean isFull() {
        return currentCount == K;
    }
}
