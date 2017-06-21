package coding.interviews;

public class Test {
	public static void main(String[] args) throws Exception {
		StringBuilder duplication = new StringBuilder();
		int[] numbers = {3, 5, 6, 5, 2, 0, 4};
		boolean duplicated = DuplicationInArray.duplicate(numbers, duplication);
		int duplicatedNumber = Integer.parseInt(duplication.toString());
		System.out.println(duplicatedNumber + "是重复的数字：" + duplicated);
		System.out.println(DuplicationInArrayNoEdit.getDuplication(numbers));
	}
}
