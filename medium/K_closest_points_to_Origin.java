// Problem No. 973
//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0). 
//The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

/* Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
*/

class Solution {
    public static int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];

        // will need to write a comparator
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(Integer.compare(a[1],b[1])));

        for(int i=0; i<points.length; i++){
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            
            pq.add(new int[]{i, distance});
            //System.out.println(pq.peek());
        }

        while(k>0){
            result[k-1] = points[pq.poll()[0]];
            k--;
        }
        return result;
    }
  
  public static void main(String[] args){
        
      MyClass myObj = new MyClass();
      
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] ans;
    
        ans = myObj.kClosest(points, k);
        
        System.out.println(Arrays.deepToString(ans));
    }
  
}

