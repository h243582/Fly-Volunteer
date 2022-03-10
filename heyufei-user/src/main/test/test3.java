public class test3 {

    public static void main(String[] args) throws InterruptedException {
        LazyMan.getInstance();
        LazyMan.getInstance();
        LazyMan.getInstance();
        LazyMan.getInstance();
        System.out.println(LazyMan);
    }


}

class LazyMan {
    private static boolean flag = false; //用来判断有没有进去过
    private volatile static LazyMan lazyMan;

    private LazyMan() {//空构造
        synchronized (LazyMan.class) {
            //第一次进来 就把flag变成false。下次如果flag等于true就说明已经来过了
            if (!flag) {
                flag = true;
            } else {
                throw new RuntimeException("不要试图用反射破坏单例模式");
            }
        }
    }

    public static void getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                }
            }
        }

    }
}