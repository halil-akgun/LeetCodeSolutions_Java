package TopInterview150;

/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:
 - Each child must have at least one candy.
 - Children with a higher rating get more candies than their neighbors.

Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 */
public class LC135_Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2})); // 5
        System.out.println(candy(new int[]{1, 2, 2})); // 4
        System.out.println(candy(new int[]{1, 3, 4, 5, 2})); // 11   1 2 3 4 1
    }

    public static int candy(int[] ratings) {

        // way 1
        if (ratings.length < 2) return 1;

        int[] candies = new int[ratings.length];
        int totalCandies = 0;

        candies[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
            totalCandies += candies[i];
        }

        return totalCandies + candies[candies.length - 1];


        // way 2
//        int up = 0, down = 0, p = 0, res = 1;
//        for (int i = 1; i < ratings.length; i++) {
//            if (ratings[i] < ratings[i - 1]) {
//                down++;
//                res += down + 1;
//                up = 0;
//                if (p >= down)
//                    res--;
//            } else if (ratings[i] > ratings[i - 1]) {
//                up++;
//                res += up + 1;
//                down = 0;
//                p = up;
//            } else {
//                up = 0;
//                down = 0;
//                p = 0;
//                res += 1;
//            }
//        }
//        return res;
    }
}
