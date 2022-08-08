package org.geeksforgeeks.queues;

public class LQueue {

	QNode front, rear;

	public LQueue() {
		this.front = this.rear = null;
	}

	// rear gets modified
	public void enqueue(int key) {

		QNode temp = new QNode(key);

		if (rear == null) {
			this.front = this.rear = temp;
			return;
		}

		this.rear.next = temp;
		this.rear = temp;
	}

	public void dequeue() {

		if (this.front == null) {
			return;
		}

		QNode tmp = front;
		this.front = tmp.next;

		if (front == null) {
			rear = null;
		}
	}

	public static void main(String[] args) {
		LQueue q = new LQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.dequeue();
		System.out.println("Queue Front : " + q.front.key);
		System.out.println("Queue Rear : " + q.rear.key);
	}
}

class QNode {
	int key;
	QNode next;

	public QNode(int key) {
		this.key = key;
		this.next = null;
	}
}