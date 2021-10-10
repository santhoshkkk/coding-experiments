package algo;

import java.util.Objects;

class Entry implements Comparable{
    int key;
    int value;
    long accessTime;

    Entry(int keyIn, int valIn){
        key = keyIn;
        value = valIn;
        accessTime = System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return key == entry.key && value == entry.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public int compareTo(Object other){
        if(!(other instanceof Entry)){
            return -1;
        }
        return (int) (this.accessTime - ((Entry)other).accessTime);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                ", accessTime=" + accessTime +
                '}';
    }
}