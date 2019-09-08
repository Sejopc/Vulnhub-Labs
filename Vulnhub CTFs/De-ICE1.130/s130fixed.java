import java.io.*;
//import java.util.Arrays;
public class s130fixed
{
public static void main(String[] args)
{
try
{
System.out.println("Password Generator");
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
System.out.print("[?] Username: ");
String input=in.readLine();
int[] output=processLoop(input);
//System.out.println("[+] Output: "+Arrays.toString(output));
String outputASCII="";
for(int i=0;i<output.length;i++) outputASCII+=(char) output[i];
System.out.println("[>] Password: "+outputASCII);
}
catch(IOException e)
{
System.out.println("[-] IO Error!");
}
}
/*input is username of account*/
public static int[] processLoop(String input){
int strL=input.length();
int lChar=(int)input.charAt(strL-1);
int fChar=(int)input.charAt(0);
int[] encArr=new int[strL+2];
encArr[0]=(int)lChar;
for(int i=1;i<strL+1;i++) encArr[i]=(int)input.charAt(i-1);
encArr[encArr.length-1]=(int)fChar;
encArr=backLoop(encArr);
encArr=loopBack(encArr);
encArr=loopProcess(encArr);
int j=encArr.length-1;
for(int i=0;i<encArr.length;i++){
if(i==j) break;
int t=encArr[i];
encArr[i]=encArr[j];
encArr[j]=t;
j--;
}
return encArr;
}
/*Note the pseudocode will be implemented with the
root account and my account, we still need to implement it with the csadmin, sdadmin,
and dbadmin accounts though*/
public static int[] backLoop(int[] input){
int ref=input.length;
int a=input[1];
int b=input[ref-1];
int ch=(a+b)/2;
for(int i=0;i<ref;i++){
if(i%2==0) input[i]=(input[i]%ch)+(ref+i);
else input[i]=(input[i]+ref+i);
}
return input;
}
public static int[] loopBack(int[] input){
int ref=input.length/2;
int[] encNew=new int[input.length+ref];
int ch=0;
for(int i=(ref/2);i<input.length;i++){
encNew[i]=input[ch];
ch++;
}
for(int i=0;i<encNew.length;i++){
if(encNew[i]<=33) encNew[i]=33+(++ref*2);
else if(encNew[i]>=126) encNew[i]=126-(--ref*2);
else{
if(i%2==0) encNew[i]-=(i%3);
else encNew[i]+=(i%2);
}
}
return encNew;
}
public static int[] loopProcess(int[] input){
for(int i=0;i<input.length;i++){
if(input[i]==40||input[i]==41) input[i]+=input.length;
else if(input[i]==45) input[i]+=20+i;
}
return input;
}
}
