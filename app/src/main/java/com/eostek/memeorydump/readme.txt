内存泄漏原因
crash1，静态变量导致。ondestroy置空可以解决
crash2，非静态内部类导致。（非静态内部类，会引用外部类。静态内部类则不会）。解决方法是使用静态修饰，外加弱引用
crash3，匿名内部类导致。（匿名内部类中使用单利模式持有这个内部类将会导致无法释放类本身）使用静态变量声明这个对象。
crash4，集合未置空导致。
crash5，BraodcastReceiver，ContentObserver，File，Cursor，Stream，Bitmap等资源的使用，应该在Activity销毁时及时关闭或者注销。
crash， webview导致的内存泄漏，使用多进程可避免。
crash，
内存泄漏中不得不了解的弱引用。
使用bitmap时，使用对象池。