package org.geeksforgeeks.queues;

public class Queue {

	int front, rear, size;
	int capacity;
	int[] array;

	public Queue(int capacity) {
		this.capacity = capacity;
		this.front = this.size = 0;
		this.rear = capacity - 1;
		this.array = new int[capacity];
	}

	public boolean isFull(Queue queue) {
		return (queue.size == queue.capacity);
	}

	public boolean isEmpty(Queue queue) {
		return queue.size == 0;
	}

	// Method add item to the queue
	// Modifies rear & size
	public void enqueue(int item) {
		if (isFull(this))
			return;
		this.rear = (this.rear + 1) % this.capacity;
		this.array[rear] = item;
		this.size += 1;
		System.out.println(item + " enqueued to queue!");
	}

	// Method pop/delete item from the queue
	// Modifies front & rear
	public int dequeue() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		int item = this.array[this.front];
		this.front = (this.front + 1) % capacity;
		this.size -= 1;
		return item;
	}

	public int front() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		return this.array[this.front];
	}

	public int rear() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		return this.array[this.rear];
	}

	public static void main(String[] args) {
		Queue queue = new Queue(1000);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println(queue.dequeue() + " dequeued from queue\n");

		System.out.println("Front item is " + queue.front());

		System.out.println("Rear item is " + queue.rear());
	}
}
