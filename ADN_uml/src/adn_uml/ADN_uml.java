package ADN_uml;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Random;
	public class ADN_uml {
	 /**
	  * Next a random number sequence is created
	  * So that the first number is less than the second and in
	  * those numbers will create a sequence of letters similar to those of ARN
	  * @param args
	  * @throws IOException
	  */
	 public static void main(String[] args) throws IOException {
	  ADN_uml cf = new ADN_uml();
	  System.out.println(cf.countReads("TTGC"));
	 } 
	 public ADN_uml(){
	  
	  int start, length;
	  String Sequence;
	  Random rd = new Random();
	  try
	  {
	   BufferedWriter bf = new BufferedWriter(new FileWriter ("Secuencias.umd"));
	   for (int i = 0; i < 1000; i++)
	   {
	    start = Math.abs( rd.nextInt());
	    length = 5 + rd.nextInt(25);
	    Sequence = "";
	    for(int j = 0; j < length; j++ )
	    {
	     switch(rd.nextInt(4))
	     {
	      case 0: Sequence += "A"; break;
	      case 1: Sequence += "C"; break;
	      case 2: Sequence += "G"; break;
	      case 3: Sequence += "T"; break;
	     }
	    }
	    bf.write(start + "," + (start + length) +  "," + Sequence + "\n");
	   }
	   bf.flush();
	  }
	  catch (IOException e)
	  {
	   e.printStackTrace();
	  }
	 }
	 /**
	  * the number of repetitions is calculated 
	  * of letters that are reflected
	  * in the sequence of numbers
	  * @param motif
	  * @return
	  * @throws IOException
	  */
	 public int countReads(String motif) throws IOException
	 {
	  BufferedReader br = new BufferedReader (new FileReader("Secuencias.umd"));
	  String read;
	  int lines = 0;
	  read = br.readLine();
	  while(read != null)
	  {
	   if (read.split(",")[2].contains(motif))
	   {
	    lines += 1;
	   } 
	   read = br.readLine();
	  }
	  return lines;
	  }
	}
