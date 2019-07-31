package com.github7;
/*
   Author:linrui
   Date:2019/7/31
   Content:
*/

class TicketTask implements Runnable {
    private int ticket = 20000;

    @Override
    public synchronized void run() {
        for (int i = 0; i < ticket; i++) {
            System.out.println(Thread.currentThread().getName() +
                    ",库房还剩下" + --ticket);
        }
    }
}

public class CellTicket {
    public static void main(String[] args) {
        TicketTask ticketTask = new TicketTask();
        new Thread(ticketTask, "黄牛1").start();
        new Thread(ticketTask, "黄牛2").start();
        new Thread(ticketTask, "黄牛3").start();
    }
}
