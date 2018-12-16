package Q2;

import java.util.Arrays;

public class SmartArrayList {
    private static final int INIT_CAPACITY = 2;
    private int size=0;  // no of element stored
    private String[] data = new String[INIT_CAPACITY]; // where the element stored


    public SmartArrayList() {

    }

    public void add(int index, String s) {
        // check 0<= index <= size
        // when index == size, append to the end
        // TODO: IMPLEMENT THE METHOD
        if ((index >= 0) & (index <= size)) {
            if (size==data.length) {
                String[] newData = new String[data.length*2];
                for (int i=0; i<index; i++) {
                    newData[i] = data[i];
                }
                newData[index] = s;
                for (int i=index+1; i<=size; i++) {
                    newData[i] = data[i-1];
                }
                data = newData;
            } else  {
                String[] newData = new String[data.length];
                for (int i=0; i<index; i++) {
                    newData[i] = data[i];
                }
                newData[index] = s;
                for (int i=index+1; i<=size; i++) {
                    newData[i] = data[i-1];
                }
                data = newData;
            }
            size ++;
        } else {
            ;
        }

    }

    public void add(String s) {
        // TODO: IMPLEMENT THE METHOD

        if (size==data.length) {
            add(size, s);
        }
        if (size<data.length) {
            add(size, s);
        }


    }

    public String get(int index) {
        // TODO: IMPLEMENT THE METHOD
        if (index >= 0 | index < size) {
            return data[index];
        } else {
            return null;
        }

    }

    public void set(int index, String s){
        // TODO: IMPLEMENT THE METHOD
        if (index >= 0| index< size) {
            data[index] = s;
        } else {
            ;
        }
    }

    public void remove(int index) {
        // TODO: IMPLEMENT THE METHOD
        if (index>=0| index<size) {
            for (int i=index; i<size-1; i++) {
                data[i] = data[i+1];
            }
        }
        size --;
    }

    @Override
    public String toString(){
        // TODO: IMPLEMENT THE METHOD
        String s = "[";
        for (int i=0; i<size; i++) {
            s += data[i] + ",";
        }
        s = s.substring(0,s.length()-1);
        s += "]";
        return s;
    }


}
