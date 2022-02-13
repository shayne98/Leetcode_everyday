package leecode.ds.hash.No307;

/**
 * @author 小羊Shaun
 * @version 1.0
 * @date 2022/2/3 11:41
 */
class NumArray {
    class Node{
        int l,r,sum;
    }
    Node[] nodes;
    int[] array;


    public NumArray(int[] nums) {
        array = nums;
        nodes = new Node[nums.length*5];
        build(1,0, nums.length-1);
    }
    public void build(int k,int l,int r){
        nodes[k] = new Node();
        nodes[k].l =l;
        nodes[k].r = r;
        if (l == r) {
            nodes[k].sum = array[l];
            return;
        }
        int mid = (l+r)/2;
        build(2*k,l,mid);
        build(2*k+1,mid+1,r);
        nodes[k].sum = nodes[2*k].sum+nodes[2*k+1].sum;
    }

    public void update(int index, int val) {
        updateRange(index,val,1);
    }
    public void updateRange(int index,int val,int k){
        if(nodes[k].l==nodes[k].r){
            nodes[k].sum = val;
            return;
        }
        int mid = (nodes[k].l+nodes[k].r)/2;
        if(index<=mid){
            updateRange(index,val,2*k);
        }
        else{
            updateRange(index,val,2*k+1);
        }
        nodes[k].sum = nodes[2*k].sum+nodes[2*k+1].sum;
        return;
    }


    public int sumRange(int left, int right) {
        return query(left,right,1);


    }
    public int query(int l,int r,int k){
        if(nodes[k].l==l&&nodes[k].r==r){
            return nodes[k].sum;
        }
        int mid = (nodes[k].l+nodes[k].r)/2;
        if(r<=mid){
            return query(l,r,2*k);
        }
        else if(l>mid){
            return  query(l,r,2*k+1);
        }
        else {
            return query(l,mid,2*k)+query(mid+1,r,2*k+1);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */