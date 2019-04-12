package eg.edu.alexu.csd.filestructure.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class m {

	public static void main(String[] args) {
		Heap h=new Heap();
		h.insert(20);
		h.insert(5);
		h.insert(2);
		h.insert(9);
		h.insert(16);
		h.insert(35);
		h.insert(1);
		h.extract();
		h.insert(88);
		List<Integer> s = Arrays.asList(5, 9,6,12,9,1,99,65);
		h.build(s);
		h.insert(null);
		
		h=new Heap();
		h.insert(Integer.valueOf(20));
		INode m=h.getRoot().getLeftChild();
		INode l=h.getRoot().getLeftChild();
		INode n=h.getRoot().getLeftChild();
		
		h=new Heap();
		//for (int i = 0; i < 100; i++)
		//	h.insert("soso");
		//for (int i = 0; i < 100; i++)
		//	h.extract();
		int iu=h.size();
		h.heapify(null);
		INode nv=h.getRoot();

	}

}
