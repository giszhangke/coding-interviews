package coding.interviews;

public class DuplicationInArray {
	/*
	 * 题目一：找出数组中的重复数字
	 * 长度为n的数组里所有数字都在0~n-1的范围内。数组中某些数字是重复的。
	 * 找出数组中任意一个重复的数字
	 * 
	 * 思路：遍历数组，假设m=numbers[i]
	 * 若m!=i, 且numbers[m]=m，则数字numbers[i]与number[m]重复，返回true;
	 * 若m!=i, 且numbers[m]!=m，则交换numbers[i]与numbers[m]
	 * 	
	 */
	public static boolean duplicate(int[] numbers, StringBuilder duplication) {
		if (numbers == null || numbers.length < 0) {
			return false;
		}
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0 || numbers[i] > numbers.length) {
				return false;
			}
		}
		
		for (int i = 0; i < numbers.length; i++) {
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					duplication.append(numbers[i]);
					return true;
				}
				
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		
		return false;
	}
}
