package test;


public class LogicTest {
	public boolean EqualSum(int sum, int[] values) {
		// Your code goes here
		// Return true if there are 2 distinct integers in values that add up to sum
		// Otherwise return false
		int i=0;
		int j=1;
		while(i<values.length) {
			int temp1;
			int temp2;
			int tempi;
			int tempj;  //i use the temps  to keep the value and the position on the array
			boolean distincti=true;
			boolean distinctj=true;
			while(j<values.length) {
				if (i!=j && values[i]+values[j]==sum) { //check if value[i] + value[j] add up to sum and if yes update temps
					temp1=values[i];
					temp2=values[j];
					tempi=i;
					tempj=j;  
					for (int t=0;t<values.length;t++) { //check if value[i] is distinct
						if (temp1==values[t] && t!=tempi) distincti=false;
					}
					for (int t=0;t<values.length;t++) { //check if value[j] is distinct
						if (temp2==values[t] && t!=tempj) distinctj=false;
					}
					if (distincti && distinctj) {
						return true;
					}else {
						break;
					}
				}
				if (!distincti) break; // if value[i] not dinstinct there is no point to continue with it
				j++;
			}
			i++;
			j=i++;
		}
		return false;
	}
	
	
}