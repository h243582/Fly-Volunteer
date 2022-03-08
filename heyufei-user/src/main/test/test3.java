import lombok.SneakyThrows;

public class test3 {

    public static void main(String[] args) throws InterruptedException {
        Student s = new Student();
        SetThread1 st = new SetThread1(s);
        Thread t1 = new Thread(st);

        GetThread1 gt = new GetThread1(s);
        Thread t2 = new Thread(gt);

        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        Thread.sleep(100);
    }


}

class SetThread1 implements Runnable {
    private Student s;
    private int x = 0;

    public SetThread1(Student s) {
        this.s = s;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            if (x % 2 == 0) {
                s.set("林青霞");
            } else{
                s.set("刘意");
            }
            x++;
        }
    }
}


class GetThread1 implements Runnable {
    private Student s;

    public GetThread1(Student s) {
        this.s = s;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            s.get();
        }
    }
}


class Student {
    private String name;
    private boolean flag; // 默认情况是没有数据 ,如果是true,说明有数据

    public synchronized void set(String name) throws InterruptedException {
        if (this.flag) {// 如果有数据,就等待
            this.wait();
        }
        this.name = name;
        // 修改标记
        this.flag = true;
        this.notify();
    }

    public synchronized void get() throws InterruptedException {
        if (!this.flag) {// 如果没有数据,就等待
            this.wait();
        }

        System.out.println(this.name);// 获取数据
        // 修改标记
        this.flag = false;
        this.notify();
    }
}

