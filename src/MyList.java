import java.util.Arrays;

public class MyList <T>{

    Object[] list;
    private int index=0;
    private int lastIndex=index;

    public MyList(){
        this.list=(T[]) new Object[10];
    }

    public MyList (int necessarySize){
        this.list=(T[]) new Object[necessarySize];
    }

    public int size(){
        return this.index;
    }

    public int getCapacity(){
        return this.list.length;
    }

    public void add(T element){
        if(list.length<=index){
            Object[] newList=(T[]) new Object[list.length*2];
            for(int i=0; i< list.length; i++){
                newList[i]=list[i];
            }
            list=newList;
        }

        list[lastIndex++]=element;
        index ++;
    }

    public T get(int index){
        return (T) list[index];
    }

    public void remove(int index){
        Object[] newList=(T[]) new Object[getCapacity()];
        for(int i=0; i<list.length-1; i++){
            if(index<i){
                newList[i-1]=list[i];
            }else{
                newList[i]=list[i];
            }

        }
        list=newList;
        index--;
        lastIndex--;

    }

    public void set(int index, T element){
        if (index < 0 || list.length <= index) {
            return;
        }

        list[index] = element;
    }

    public String toString() {
        String stringList = "[";
        for (int i=0; i<size(); i++) {
            stringList += list[i];
            stringList +=",";
        }
        int end = stringList.length();
        stringList = stringList.substring(0, end - 1);  // remove the last comma inside the stringList "stringList"
        stringList +="]";

        return stringList;
    }

    public int indexOf(T data) {
        for (int i=0; i<list.length; i++) {
            if (data.equals(list[i])) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i=lastIndex-1; 0<=i; i--) {
            if (data.equals(list[i])) {
                return i;
            }
        }

        return -1;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public T[] toArray() {
        return Arrays.copyOf((T[])list, index);
    }

    public void clear() {
        for (int i=0; i<list.length; i++) {
            list[i] = null;
        }

        index = 0;
    }



    public MyList<T> subList(int start, int end) {
        if ((start < 0 || list.length <= start) && (end < 0 || list.length <= end)) {
            return null;
        }

        int subListLength = end - start;
        MyList<T> subListObj = new MyList<>(subListLength);

        for (int i=start; i<end; i++) {
            subListObj.add((T) list[i]);
        }

        return subListObj;
    }

    public boolean contains(T element) {
        for (Object o : list) {
            if (element.equals(o)) {
                return true;
            }
        }

        return false;
    }

}
