
package java42_0201;

class MyArrayListIndexOutOfRangException extends RuntimeException{
    public MyArrayListIndexOutOfRangException(String message) {
        super(message);
    }
}

//为了代码简单，就不写泛型版本的，直接认为 ArrayList 中存的是 String
public class MyArrayList {
    //确定属性和方法
    //属性
    private String[] data = null;
    private int size = 0;//表示当前数组内的有效数组元素的个数
    private int capacity = 100;//表示当前顺序表最大容纳元素个数，如果 size 超过了 capacity, 就需要扩容

    //方法,增删改查

    //因为 data = null, 所以不能直接引用，这里写一个构造方法.也可以称为实例化
    public MyArrayList(){
        data = new String[capacity];
    }

    //实现扩容
    private void realloc(){

        //先把 capacity 变大(具体变大的公式自己随便定，根据实际要求进行确定)
        capacity = 2 * capacity;
        String[] newData = new String[capacity];
        //把旧的数据组中的数据拷贝到新数组中
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        //把新的大的数组赋值给原有  的属性 data ，同时会释放掉旧的数组（GC)
        data = newData;
    }

    //1、元素尾插到顺序表末尾
    // O（1）的时间复杂度
    public void add(String elem) {
        if (size >= capacity) {
            //需要先扩容
        }

        //就直接把新的元素放到下标为 size 的位置上即可
        data[size] = elem;
        size++;
    }
    //2、把元素插入到任意中间位置
    //O（n）的复杂度
    public void add(int index, String elem) {
        //如果 Index == size ，相当于把新元素插入到末尾~
        if (index <= 0 || index > size){
            return;
        }

        if (size >= capacity) {
            realloc();
        }
        //把 elem 放到 index 位置上， 不能覆盖掉已经有的元素
        // 需要把 index 位置的元素，依次往后搬运。给 index 位置腾出一个空闲空间，来放置 elem
        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        //搬运完毕，把新的元素放到 index 位置上
        data[index] = elem;
        size++;
    }

    //3. 按照下标位置删除元素,这个方法的返回结果就是被删除元素
    //O（n）的复杂度
    public String remove(int index) {
        //仍然是需要进行搬运，把 index 位置的元素覆盖掉即可
        if (index < 0 || index > size) {
            return null;
        }
        String result = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        //别忘记 size 要更新
        size--;

        return result;
    }

    //4. 按照元素的值来删除元素，这个方法返回成功/失败
    //O（n）的复杂度
    public boolean remove(String elem) {
        //先找到元素所在的位置
        int index = 0;
        for(; index < size; index++) {
            if (data[index].equals(elem)) {
                break;
            }
        }
        if (index >= size ) {
            //没找到匹配的元素，删除时不黑
            return false;
        }
        //找到匹配的元素了， 从 index 位置开始搬运
        for (int i = index; i < size-1 ; i++) {
            data[i] =  data[i+1];
        }
        size--;
        return true;
    }

    //5. 根据下标获取元素
    // O（1）的时间复杂度
    public  String get(int index) {
        if (index < 0 || index > size){
            //此处可以返回一个 null； 也可以抛出一个异常
           // return null;
            throw new MyArrayListIndexOutOfRangException("下标越界了！index：" + index);
        }
        return data[index];
    }

    //6.按照下标修改元素
    // O（1）的时间复杂度
    public void set(int index, String elem) {
        if (index < 0 || index > size){
            //此处可以返回一个 null； 也可以抛出一个异常
            // return null;
            throw new MyArrayListIndexOutOfRangException("下标越界了！index：" + index);
        }
        data[index] = elem;
    }

    //7.判断元素是否存在
    //O（n）
    public boolean contains(String elem) {
        //此处不太方便用 for each
        //for each 遍历了整个  data 的所有元素
        //实际上只需要遍历前 size 个元素即可
        for (int i = 0; i < size;i++) {
            if (data[i].equals(elem)){
                return true;
            }
        }
        return false;
    }

    //8. 查找元素位置
    //O(n）
    public int indexOf(String elem) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(elem)){
                return i;
            }
        }
        return -1;
    }

    //9. 查找元素位置（从后往前找）
    //O(n)
    public int lastIndexOf(String elem) {
        for (int i = size-1 ; i >=0 ; i--){
            if (data[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {  //O（1）
        size = 0;
}

    public int size() {     //O（1）
        return size ;
}

    public boolean isEmpty() {  //O（1）

        return size == 0;
}

    //alt + insert 选择 toString 方法。
    // 注意 toString 和 println 不要混为一谈，toSting 只是把对象转化为一个 String 而已
    //具体转化为 toString 之后是保存，是赋值，还是打印，还是写文件等等 都可以。
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for  (int i = 0; i <size; i++) {
            stringBuilder.append(data[i]);
            if (i <size-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static void testAdd() {
        MyArrayList myArrayList = new MyArrayList();

        //写代码一定要测试，每次写一些逻辑，都尽快的进行验证。！！
        //通过一些简单的测试代码，来测试另外一些代码的功能，这种测试我们称为“单元测试”。
        //“单元测试”是开发写的，是一种思想方法的体现，意识。

        //1. 验证尾插
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("python");
        System.out.println(myArrayList);


        //2，验证中间位置插入
        myArrayList.add(1,"javascript");
        System.out.println(myArrayList);
    }

    private static void testRemove(){
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("python");

        myArrayList.remove(1);
        System.out.println(myArrayList);

        myArrayList.remove("java");
        System.out.println(myArrayList);

    }

    private static void testGetAndSet() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("python");

        System.out.println(myArrayList.get(1));
        myArrayList.set(1,"javascrept");
        System.out.println(myArrayList);

        myArrayList.get(100);

    }

    private static void testContainsAndIndexOf(){
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("c++");
        myArrayList.add("python");

        System.out.println(myArrayList.contains("c++"));

        System.out.println(myArrayList.indexOf("c++"));

        System.out.println(myArrayList.lastIndexOf("c++"));
    }

    private static void testSizeEmptyClear() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("c++");
        myArrayList.add("python");

        System.out.println(myArrayList.size());
        System.out.println(myArrayList.isEmpty());

        myArrayList.clear();

        System.out.println(myArrayList.size());
        System.out.println(myArrayList.isEmpty());
    }


    public static void main(String[] args) {
//        testAdd();
//     testRemove();
//     testGetAndSet();
//     testContainsAndIndexOf();
     testSizeEmptyClear();

    }

}
