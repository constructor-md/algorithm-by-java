package com.example.demo.designcode.patternstructure.iterator;

public class NameRepository<T> implements Container {

    //模拟集合类内的存储空间
    public T[] names ;

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }







}
