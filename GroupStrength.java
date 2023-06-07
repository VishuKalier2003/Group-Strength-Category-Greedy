/* You are given a 0-indexed integer array nums representing the score of students in an exam. The teacher would 
like to form one non-empty group of students with maximal strength, where the strength of a group of students of 
indices i0, i1, i2, ... , ik is defined as nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​]. Return the maximum 
strength of a group the teacher can create.
* Eg 1 : nums = [3,-1,-5,2,5,-9]             Strength = 1350
* Eg 2 : nums = [-4,-5,-4]                   Strength = 20  
*/
import java.util.*;
public class GroupStrength
{
      public int MaximumStrength(int nums[])
      {
            PriorityQueue<Integer> MaxHeap = new PriorityQueue<Integer>();   //* Max Heap -> O(N)
            int count = 0, strength = 1;      // Variables declared...
            for(int i = 0; i < nums.length; i++)     //! Checking -> O(N)
            {
                  if(nums[i] == 0)    // If score of a student is zero, do not take...
                        continue;
                  else if(nums[i] < 0)
                  {
                        count++;   // Check the count of negative score students...
                        MaxHeap.add(nums[i]);    // Adding to the MaxHeap...
                  }
                  else if(nums[i] > 0)
                        strength = strength * nums[i];
            }
            if(count % 2 == 0)    // If the number of negative score students is even...
            {
                  while(!MaxHeap.isEmpty())    //! Evaluation -> O(N)
                        strength = strength * MaxHeap.poll();
            }
            else    // If the number of negative score students is odd...
            {
                  while(MaxHeap.size() != 1)    //! Evaluation -> O(N)
                        strength = strength * MaxHeap.poll();
            }
            return strength;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter Number of Students : ");
            x = sc.nextInt();
            int array[] = new int[x];
            for(int i = 0; i < array.length; i++)
            {
                  System.out.print("Enter Score : ");
                  array[i] = sc.nextInt();
            }
            GroupStrength groupstrength = new GroupStrength();    // Object creation...
            System.out.println("The Maximum Group Strength Possible : "+groupstrength.MaximumStrength(array));
            sc.close();
      }
}


//! Time Complexity -> O(N)
//* Space Complexity -> O(N)