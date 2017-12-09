package com.ericzong.algorithm.number;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 问题：给定一组整数，从中找出两个数，它们的和为指定目标整数。
 * 逻辑：先将数值放入 Map 中，后根据一数和目标计算出另一数，并通过 Map 快速查找数组中是否存在另一数。
 * 限制：暂无。可支持重复项。
 * 
 * @author Eric Zong
 */
public class TwoSumFull {
    
    public static Set<Pair> getPairByTarget(int[] array, int target) {
        Set<Pair> result = new LinkedHashSet<>(array.length);
        List<Integer> processedNumbers = new ArrayList<>(array.length);
        
        DataStructure data = new DataStructure();
        for(int i = 0; i < array.length; i++) {
            data.add(i, array[i]);
        }
        
        for (Iterator<Integer> itr = data.iterator(); itr.hasNext(); ) {
            int one = itr.next();
            if(processedNumbers.contains(one)) {
                continue;
            } else {
                processedNumbers.add(one);
            }
            
            int another = target - one;
            if(data.containsValue(another)) {
                processedNumbers.add(another);
                
                Set<Node> oneSet = data.get(one);
                Set<Node> anotherSet = data.get(another);
                combine(oneSet, anotherSet, result);
            }
        }
        
        return result;
    }
    
    private static void combine(Set<Node> oneSet, Set<Node> anotherSet, Set<Pair> result) {
        for(Node one : oneSet) {
            for(Node another : anotherSet) {
                if(!one.equals(another)) {
                    Pair pair = new Pair(one, another);
                    result.add(pair);
                }
            }
        }
    }
    
    /**
     * 数据存储结构。
     * 实际上是个 Map，key 为给定的整数数组中数，value 被构造为节点集合（因为数据可以是重复的）。
     * 
     * @author Eric Zong
     */
    static class DataStructure {
        private Map<Integer, Set<Node>> data = new LinkedHashMap<>();
        
        public void add(int index, int value) {
            Set<Node> set = null;
            if(!data.containsKey(value)) {
                set = new LinkedHashSet<>();
                data.put(value, set);
            } else {
                set = data.get(value);
            }
            
            Node node = new Node(index, value);
            set.add(node);
        }
        
        public Iterator<Integer> iterator() {
            return data.keySet().iterator();
        }
        
        public boolean containsValue(Object value) {
            return data.containsKey(value);
        }
        
        public Set<Node> get(int value) {
            return data.get(value);
        }
    }

    /**
     * 结果。存储符合条件的两个数据节点。
     * 
     * @author Eric Zong
     */
    static class Pair {
        private Node one;
        private Node another;

        public Pair(Node one, Node another) {
            // 固定索引较小的节点存储在 one 中，较大的存储在 another 中
            // 这是为了保证表示的一致性，以及判等
            if(one.index > another.index) {
                this.one = another;
                this.another = one;
            } else {
                this.one = one;
                this.another = another;
            }
        }

        public Node getOne() {
            return one;
        }

        public Node getAnother() {
            return another;
        }

        @Override
        public int hashCode() {
            return Objects.hash(one, another);
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            
            if(obj instanceof Pair) {
                Pair other = (Pair) obj;
                return this.one.equals(other.one) && this.another.equals(other.another);
            }
            
            return false;
        }

        @Override
        public String toString() {
            return String.format("<%s, %s>", one, another);
        }
    }

    /**
     * 数据节点。存储一个整数和其对应的索引。
     * 
     * @author Eric Zong
     */
    static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) { return true; }

            if (obj instanceof Node) {
                Node other = (Node) obj;
                return (this.index == other.index && this.value == other.value);
            }

            return false;
        }

        @Override
        public String toString() {
            return String.format("(%d)%d", index, value);
        }
    }
}
