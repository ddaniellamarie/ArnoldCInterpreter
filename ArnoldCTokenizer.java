import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ArnoldCTokenizer {

	//converts passed argument into a string
	private static String argumentToString(String arg){
		char[] caMainArg = null;
		String strMainArg = null;
		// Convert each String arg to char array
		caMainArg = arg.toCharArray();
		// Convert each char array to String
		strMainArg = new String(caMainArg);
		//print
		// System.out.print(strMainArg);
		return strMainArg;
	}

	public static void main (String[] args) throws IOException {

		if (args.length > 0){
        for(String arg: args) {
						String filename = argumentToString(arg);

						if (filename.endsWith(".arnoldc")) {
							// System.out.println(filename + " is valid ArnoldC file.");
											// variable declaration
							        int ch;

							        // check if File exists or not
							        FileReader fr=null;
							        try{
							            fr = new FileReader(filename);
							        }catch (FileNotFoundException fe){
							            System.out.println("File not found");
							        }
							        // read from FileReader till the end of file

							        while ((ch=fr.read())!=-1){
												if ((char)ch != '\n'){
												System.out.print((char)ch);}
											}
							        // close the file
							        fr.close();





						}else{
							System.out.println("Invalid ArnoldC file.");
						}
        }
		}else{
			System.out.println("No argument passed");
		}

	public Token(TokenType, String data){
		this.type = type;
		this.data = data;
	}

	@Override
	public String toString(){
		return String.format("(%s %s)", type.name(), data)
	}

	}


}
