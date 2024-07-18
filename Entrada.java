package utilitats;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;

public class Entrada {
	
	private static Scanner entrada;
	
	static {
		entrada = new Scanner(System.in);
	}
	
	public static byte llegirByte(String missatge) {
		boolean success = false;
		byte miByte = 0;	
		do {
			try {
				System.out.print(missatge);
				miByte = entrada.nextByte();
				success = true;
			}catch(InputMismatchException e) {
				System.out.println("Error de format");
				entrada.nextLine();
			}
		}while(!success);
		entrada.nextLine();
		return miByte;
	}

	public static int llegirInt(String missatge) {
		boolean success = false;
		int miInt = 0;	
		do {
			try {
				System.out.print(missatge);
				miInt = entrada.nextInt();
				success = true;
			}catch(InputMismatchException e) {
				System.out.println("Error de format");
				entrada.nextLine();
			}
		}while(!success);
		entrada.nextLine();
		return miInt;
	}

	public static float llegirFloat(String missatge) {
		boolean success = false;
		float miFloat = 0;	
		do {
			try {
				System.out.print(missatge);
				miFloat = entrada.nextFloat();
				success = true;
			}catch(InputMismatchException e) {
				System.out.println("Error de format");
				entrada.nextLine();
			}
		}while(!success);
		entrada.nextLine();
		return miFloat;
	}

	public static double llegirDouble(String missatge) {
		boolean success = false;
		double miDouble = 0;	
		do {
			try {
				System.out.print(missatge);
				miDouble = entrada.nextDouble();
				success = true;
			}catch(InputMismatchException e) {
				System.out.println("Error de format");
				entrada.nextLine();
			}
		}while(!success);
		entrada.nextLine();
		return miDouble;
	}
	
	public static char llegirChar(String missatge) {
		boolean success = false;
		String lectura =  "";
		char miChar = ' ';	
		do {
			try {
				System.out.print(missatge);
				lectura = entrada.nextLine();
				if (lectura.length() == 1) {
					miChar = lectura.charAt(0);
					success = true;
				}else {
					System.out.println("Error, s'ha s'ha llegit una cadena de més d'un char");
				}
			}catch(Exception e) {
				System.out.println("Error");
				entrada.nextLine();
			}
		}while(!success);
		return miChar;
	}
	
	public static String llegirString(String missatge){
		boolean success = false;
		String miString =  "";	
		do {
			try {
				System.out.print(missatge);
				miString = entrada.nextLine();
				success = true;
			}catch(Exception e) {
				System.out.println("Error");
				entrada.nextLine();
			}
		}while(!success);
		return miString;
	}
	
	public static boolean llegirSiNo(String missatge) {
		boolean success = false;
		String lectura =  "";
		boolean miBoolean = false;	
		do {
			try {
				System.out.print(missatge);
				lectura = entrada.nextLine();
				if (lectura.equalsIgnoreCase("s")) {
					miBoolean = true;
					success = true;
				}else if (lectura.equalsIgnoreCase("n")){
					miBoolean = false;
					success = true;
				}else {
					System.out.println("Error, només 's' i 'n' son entrades vàlides");
				}
			}catch(Exception e) {
				System.out.println("Error");
				entrada.nextLine();
			}
		}while(!success);
		return miBoolean;
	}

	private static Path LlegirPath(String missatge) {
		Path path = null;
		boolean success = false;
		do {
			String answer = Entrada.llegirString(missatge);
			path = Path.of(answer);
			success = Files.isReadable(path);
			if (!success) {
				path = Path.of(System.getProperty("user.dir") + answer);
				success = Files.isReadable(path);
				if (!success) System.out.println("Ruta no vàlida!");
			}
		}while(!success);
		return path;
	}
	
	public static void close() {
		entrada.close();
	}
	
}
