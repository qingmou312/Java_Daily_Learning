//Java数组章节练习题
public class ArrayUtils{

    //1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
		int i = 0;
		int max = data [0];
		for (i = 0;i < data.length;i++){
			if (data[i] >= max ){
				max = data [i];
			}
		}
        return max;
    }
    
    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
		int i = 0;
		int min = data [0];
		for (i = 0;i < data.length;i++){
			if (data[i] <= min ){
				min = data [i];
			}
		}
        return min;
    }
    
    
    //3.计算数组值之和
    public static int arrayElementSum(int[] data){
        int i = 0;
		int sum = 0;
		for(i = 0;i<data.length;i++){
			sum = sum + data[i];
		}
        return sum;
    }
    
    //4.数组拼接
    public static int[] arrayJoin(int[] a, int[] b){
        int [] c = new int[a.length+b.length];
		for(int i = 0;i<a.length;i++){
			c[i] = a[i];
		}
		for (int i = a.length;i<c.length;i++){
			c[i] = b[i-a.length];
		}
        return c;
    }

    //5.数组截取
    //[start, end)
    public static int[] arraySub(int[] data, int start , int end){
        int [] c = new int [end-start];
		for(int i = 0;i<end-start;i++){
			c[i] = data [i+start];
		}
        return c;
    }
    
    //6.数组打印
    public static void printArray(int[] data){
		for(int i = 0;i<data.length;i++){
			System.out.print(data[i]);
		}
		System.out.println();
    }
    
    //7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
		int [] c = new int[data.length];
		for(int i=0;i<data.length;i++){
			c[i] = data[(data.length)-i-1];
		}
		for(int i = 0;i<data.length;i++){
			System.out.print(c[i]);
		}		
    }
    
    public static void main(String[] args){
		int [] data  = new int [10];
		data[0] = 2;
		data[1] = 7;
		data[2] = 4;
		data[3] = 9;
		data[4] = 0;
		data[5] = 8;
		data[6] = 5; 
		data[7] = 1;
		data[8] = 3;
		data[9] = 6;
		//System.out.println(arrayMaxElement(data));  
		//System.out.println(arrayMinElement(data));
		//System.out.println(arrayElementSum(data));
		//printArray(data);
		//printArray(arraySub(data,1,5));
		printReversal(data);
		/*
		int[] a = new int[5];
		int[] b = new int[3];
		a[0] = 12;
		a[1] = 13;
		a[2] = 14;
		a[3] = 15;
		a[4] = 16;
		b[0] = 0;
		b[1] = 1;
		b[2] = 2;
		printArray(arrayJoin(a,b));*/
    }
}