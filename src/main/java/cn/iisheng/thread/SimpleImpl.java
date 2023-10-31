package cn.iisheng.thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * @author iisheng
 * @date 2022/09/25 17:19:37
 * @description 简单版本生产者、消费者模型
 */
public class SimpleImpl {
    
    
    // 基于wait、notify实现
    
    // 基于ReentrantLock实现
    
    // 基于Semaphore实现
    
    // 基于BlockingQueue实现
    
    // 基于PipedInputStream、PipedOutputStream实现
    
    
    public class Product {
        private String name;
        
        public Product(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
    }
    
    public class Producer implements Runnable {
        private Queue<Product> queue;
        private int maxCapacity;
        
        public Producer(Queue queue, int maxCapacity) {
            this.queue = queue;
            this.maxCapacity = maxCapacity;
        }
        
        @Override
        public void run() {
            synchronized (queue) {
                while (queue.size() == maxCapacity) { //一定要用 while，而不是 if，下文解释
                    try {
                        System.out.println("生产者" + Thread.currentThread().getName() + "等待中... Queue 已达到最大容量，无法生产");
                        wait();
                        System.out.println("生产者" + Thread.currentThread().getName() + "退出等待");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (queue.size() == 0) { //队列里的产品从无到有，需要通知在等待的消费者
                    queue.notifyAll();
                }
                Random random = new Random();
                Integer i = random.nextInt();
                queue.offer(new Product("产品" + i.toString()));
                System.out.println("生产者" + Thread.currentThread().getName() + "生产了产品：" + i.toString());
            }
        }
    }
    
    public class Consumer implements Runnable {
        private Queue<Product> queue;
        private int maxCapacity;
        
        public Consumer(Queue queue, int maxCapacity) {
            this.queue = queue;
            this.maxCapacity = maxCapacity;
        }
        
        @Override
        public void run() {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("消费者" + Thread.currentThread().getName() + "等待中... Queue 已缺货，无法消费");
                        wait();
                        System.out.println("消费者" + Thread.currentThread().getName() + "退出等待");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (queue.size() == maxCapacity) {
                    queue.notifyAll();
                }
                
                Product product = queue.poll();
                System.out.println("消费者" + Thread.currentThread().getName() + "消费了：" + product.getName());
            }
        }
    }
    
    public static void main(String[] args) {
        Queue<Product> queue = new ArrayDeque<>();
        
        SimpleImpl simple = new SimpleImpl();
        
        for (int i = 0; i < 100; i++) {
            new Thread(simple.new Producer(queue, 100)).start();
            new Thread(simple.new Consumer(queue, 100)).start();
        }
    }
}
