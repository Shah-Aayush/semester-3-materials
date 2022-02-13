import java.util.Scanner;
class Practical7d {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringAndWords[] Paragraph = new StringAndWords[10];
		String original = new String();
		StringBuilder sentence = new StringBuilder();
		int count = 0;
		System.out.print("Enter String : ");
		original = sc.nextLine();
		int countIndex = 0;
		int end = 0;
		for(int i=0;i<original.length();i++){
			count = 0;
			if(original.charAt(i)=='.' || original.charAt(i)=='!' || original.charAt(i)=='?'){
				for(int j=end;j<i;j++){
					if(original.charAt(j)==' ' && (j!=0 &&  original.charAt(j-1)!='.' && original.charAt(j-1)!='!' && original.charAt(j-1)!='?'))
					count++;
					sentence.append(original.charAt(j));
				}
				Paragraph[countIndex++] = new StringAndWords(count+1,sentence);
				sentence = new StringBuilder();
				end = i+1;
				count=0;
			}
		}
		for(int pick=0;pick<countIndex;pick++){
			for(int comp=pick+1;comp<countIndex;comp++){
				if(Paragraph[pick].count>Paragraph[comp].count){
					int temp = Paragraph[pick].count;
					Paragraph[pick].count = Paragraph[comp].count;
					Paragraph[comp].count = temp;
					StringBuilder tempStr = new StringBuilder(Paragraph[pick].str);
					Paragraph[pick].str = Paragraph[comp].str;
					Paragraph[comp].str = tempStr;
				}
			}
		}
		
		for(int i=0;i<countIndex;i++)
		System.out.println(Paragraph[i].str + " = " + Paragraph[i].count);
	}
}
