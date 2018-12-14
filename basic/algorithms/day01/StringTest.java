package algo.day01;

import java.util.HashMap;
import java.util.Map;


public class StringTest {
	public static void main(String[] args) {
		judgeRevolveWord("1234", "3412");
		String data2 = invertedWords("pig loves dog");
		System.out.println("pig loves dog  -->>  " + data2);
		String data = move("ABCDE", 2);
		System.out.println("移动 -->> " + data);
		String data3 = compareStringWord(new String[] { "b", "ba" });
		System.out.println("字典顺序最小的 -->> " + data3);
		String data4 = replaceSpace("i love  you!");
		System.out.println("空格替换 -->>  " + data4);
		int data5 = longestSubstring("abcdefbadeeeeeeeef");
		System.out.println("最长子串长度 -->>  "+data5);
	}

	/**
	 * 判断 a和b是否为旋转词
	 * 
	 * @param a
	 * @param b
	 */
	public static boolean judgeRevolveWord(String a, String b) {
		if (a.length() != b.length()) {
			System.out.println("不是旋转词");
			return false;
		}
		String result = a + a;
		if (result.contains(b)) {
			System.out.println("互为旋转词");
			return true;
		}
		System.out.println("不是旋转词");
		return false;
	}

	/**
	 * 字符串逆序调整 O(N)
	 * 
	 * @param data
	 * @return
	 */
	public static String invertedWords(String data) {
		String[] result = data.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = result.length - 1; i >= 0; i--) {
			sb.append(reverse(result[i]));
			if (i != 0) {
				sb.append(" ");
			} else {
				sb.append("。");
			}
		}
		return sb.toString();
	}

	/**
	 * 时间复杂度O(N) 空间复杂度O(1)
	 * 
	 * @param data
	 * @param i
	 * @return ABCDE i==2 -->> CBADE -> CBAED -> -> DEABC
	 */
	public static String move(String data, int i) {
		String result = reverse(data.substring(0, i + 1)) + reverse(data.substring(i + 1));
		return reverse(result);
	}

	/**
	 * 得到字典顺序中所有字母拼接最小的 每两个相加的字典顺序小则小，不能通过单个字符
	 * 
	 * @return
	 */
	public static String compareStringWord(String[] data) {
		if (data == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		String pre = "";
		String last = "";
		String temp = "";
		for (int i = 0; i < data.length; ++i) {
			for (int j = i + 1; j < data.length; ++j) {
				pre = data[i] + data[j];
				last = data[j] + data[i];
				if (pre.compareTo(last) > 0) {
					temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}
			sb.append(data[i]);
		}
		return sb.toString();
	}

	/**
	 * 空格替换
	 * 
	 * @param word
	 * @return
	 */
	public static String replaceSpace(String data) {
		int length = data.length();
		char[] chars = data.toCharArray();
		// data.replace("", "%20");
		int num = 0;
		for (int i = 0; i < length; i++) {
			if (chars[i] == ' ') {
				num++;
			}
		}
		int newLength = length + 2 * num;
		char[] newChars = new char[newLength];
		for (int i = 0, j = 0; i < length && j < newLength; i++) {
			if(chars[i] != ' ' ) {
				newChars[j++] = chars[i];
			}else {
				newChars[j++] = '%';
				newChars[j++] = '2';
				newChars[j++] = '0';
			}
		}
		return String.valueOf(newChars);
	}

	/**
	 * 合法括号串
	 * (()())是对的
	 * ()a()()是错的，括号没有包括
	 * @param data
	 * @return
	 */
	public static boolean checkParenthesis(String data) {
		if(data == null) return false;
		char[] chars = data.toCharArray();
		int num = 0;
		for(int i = 0;i<chars.length;i++) {
			if(chars[i]== '(' ) {
				num++;
			}else if(chars[i]== ')' ) {
				num --;
			}else {
				if(num == 0) {
					return false;
				}
			}
			if(num < 0) {
				return false;
			}
		}
		if(num != 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * 最长无重复字符子串
	 * @param word
	 * @return
	 */
	public static int longestSubstring(String A) {
		if(A == null) {
			return 0;
		}
		char[] chs = A.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		int pre = 1;//默认长度为1
		map.put(chs[0], 0);   
		int posA;//当前节点往左可达到无重复子串的位置 abcedba a -> 1
		int posB;//前一个节点往左可达到无重复子串位置 abcedba b -> 2
		int max = pre;
		for(int i = 1;i<chs.length;i++) {
			if(map.containsKey(chs[i])) {
				posA = map.get(chs[i]) + 1;
			}else {
				posA = 0;
			}
			map.put(chs[i], i);
			posB = i - pre - 1;
			if(posB >= posA) {//B在A的右边
				pre ++;
			}else {
				pre = i - posA + 1;
			}
			  
			if(pre >max) {
				max = pre;
			}
		}
		return max;
	}
	
	private static String reverse(String word) {
		char[] data = word.toCharArray();
		String result = "";
		for (int i = data.length - 1; i >= 0; i--) {
			result += data[i];
		}
		return result;

	}
}
