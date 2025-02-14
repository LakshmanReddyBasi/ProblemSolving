// 1352. Product of the Last K Numbers
// Solved
// Medium
// Topics
// Companies
// Hint
// Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.

// Implement the ProductOfNumbers class:

// ProductOfNumbers() Initializes the object with an empty stream.
// void add(int num) Appends the integer num to the stream.
// int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has at least k numbers.
// The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.

 

// Example:

// Input
// ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
// [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

// Output
// [null,null,null,null,null,null,20,40,0,null,32]

// Explanation
// ProductOfNumbers productOfNumbers = new ProductOfNumbers();
// productOfNumbers.add(3);        // [3]
// productOfNumbers.add(0);        // [3,0]
// productOfNumbers.add(2);        // [3,0,2]
// productOfNumbers.add(5);        // [3,0,2,5]
// productOfNumbers.add(4);        // [3,0,2,5,4]
// productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
// productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
// productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
// productOfNumbers.add(8);        // [3,0,2,5,4,8]
// productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32 

SOln:

MINE:

class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list=new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int len = list.size();
        int prod=1;
        for (int i = len-k;i<len;i++){
            prod*=list.get(i);
        }
        return prod;
    }
}

______________________________________________________________

  Optimal:
using prefixProduct:

class ProductOfNumbers {

    ArrayList<Integer>list=new ArrayList<>();
    int prod=1;

    public ProductOfNumbers() {
    }
    
    public void add(int num) {

        if(num==0){
            list=new ArrayList<>();
            prod=1;
            return;
        }
        prod=prod*num; 
        list.add(prod);       
    }
    
    public int getProduct(int k) {
        if(list.size()<k)return 0;
        int ans=list.get(list.size()-1);
        if(list.size()==k)return ans;
        return ans/list.get(list.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
