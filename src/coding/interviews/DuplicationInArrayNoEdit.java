package coding.interviews;

public class DuplicationInArrayNoEdit {
	/*
	 * 题目二：不修改数组找出重复的数字
	 * 长度为n+1的数组里所有数字都在1~n的范围内，所有数组中至少有一个数字是重复的。
	 * 找出数组中任意一个重复的数字
	 * 
	 * 思路1：对数字范围[1, n]，用二分法分段统计每段数字出现的频次，结合段首start==段尾end来判断是否为重复数字
	 * 这个思路的空间复杂度为O(1)，时间复杂度为O(nlogn)
	 * 如果要降低时间复杂度，可以创建一个长度为n的辅助数组，把原数组中的数字逐个复制到辅助数组，
	 * 再采用DuplicationInArray.duplicate(int[] numbers, StringBuilder duplication)的方法来实现
	 */
	public static int getDuplication(int[] numbers) {
		if (numbers ==null || numbers.length <= 0) {
			return -1;
		}
		
		int start = 0;
		int end = numbers.length - 1;
		while (end >= start) {
			int middle = ((end - start) >> 1) + start;
			int count = countRange(numbers, start, middle);
			
			if (end == start) {
				if (count > 1) {
					return start;
				} else {
					break;
				}
			}
			
			if(count > (middle - start) + 1) {
				end = middle;
			} else {
				start = middle + 1;
			}
				
		}
		
		return -1;
	}
	
	private static int countRange(int[] numbers, int start, int end) {
		if (numbers == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= start && numbers[i] <= end) {
				++count;
			}
		}
		return count;
	}
}
