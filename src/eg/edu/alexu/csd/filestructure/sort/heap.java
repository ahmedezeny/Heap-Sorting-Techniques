package eg.edu.alexu.csd.filestructure.sort;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class heap implements IHeap {
    private node root;
    private ArrayList<INode> heap =new ArrayList<>();
    private int size=0;

    private class node <T extends Comparable<T>> implements INode {
        int index;
        private T value;


        public node(int index){
            this.index=index;
        }

        @Override
        public INode getLeftChild() {
            if(2*index+1>=size){
                return null;
            }return heap.get(2*index+1);
        }

        @Override
        public INode getRightChild() {
            if(2*index>=size){
                return null;
            }return heap.get(2*index);
        }

        @Override
        public INode getParent() {
            if(index/2<0){
                return null;
            }return heap.get(index/2);
        }

        @Override
        public Comparable getValue() {
            return value;
        }

        @Override
        public void setValue(Comparable value) {
            this.value= (T) value;
        }


    }

    public heap()
    {
        node n = new node(0);
        n.setValue(Integer.MAX_VALUE);
        heap.add(n);//.setValue(Integer.MIN_VALUE));
    }

    @Override
    public INode getRoot() {
        if(size<1){
            return null;
        }
        return heap.get(1);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void heapify(INode node) {
        Comparable larger;
        Comparable l = node.getLeftChild().getValue();
        Comparable r =  node.getLeftChild().getValue();
        if(!(l.compareTo(size)>0)&&l.compareTo(node.getValue())>0){
            larger=l;
        }else{
            larger=node.getValue();
        }
        if(!(r.compareTo(size)>0)&& r.compareTo(larger)>0){
            larger=r;
        }if(larger !=  node.getValue()){
            INode n=new node<>(0);
            n.setValue(larger);
            swap(n, node);
            heapify(node);
        }

    }

    @Override
    public Comparable extract() {
        if(this.size<1){
            return null;
        }
        Comparable max= (Comparable) heap.get(1);
        heap.set(1,heap.get(size--));
        heapify(heap.get(1));
        return max;
    }

    @Override
    public void insert(Comparable element) {
        heap.set(++size, (INode) element);
        int current = size;
        while (heap.get(current).getValue().compareTo(heap.get(current).getParent().getValue())>0){
            swap(heap.get(current),heap.get(current).getParent());
        }

    }

    @Override
    public void build(Collection unordered) {
        //TODO check the complexity
        if(unordered.size()>0){
            root.setValue(1);
        }
        this.heap=new ArrayList<>();
        int i=1;
        Iterator itr=unordered.iterator();
        while(itr.hasNext()){
            node n=new node(i++);
            n.setValue((Comparable) itr.next());
            heap.add(n);
        }
        size=unordered.size();
        for (int ii=size/2;ii>=1;ii--){
            heapify(heap.get(ii));
        }
    }

    // Function to swap two nodes of the heap
    private void swap(INode fpos, INode spos)
    {
        Comparable tmp;
        tmp = fpos.getValue();
        fpos.setValue(spos.getValue());
        spos.setValue(tmp);
    }

}
