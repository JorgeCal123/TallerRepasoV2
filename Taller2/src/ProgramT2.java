import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class ProgramT2 {

	
	private static double[] arreglo;
	
	private static int[] teclado;
	
	private static int[] arreglo2;

	/*
	 * Este metodo lo que hace es primero declarar las variables y
	 * luego imprime el valor y su tipo
	 * 
	 * el retorno es de tipo void
	 * que significa que no retorna nada
	**/
	
	public static void crearVariables() {
		int E = 10;
		double D = 15;
		char C = 'c';
		// Para obtener el tipo de clase lo que hice fue castear cada variable
		// a tipo object y despues con getclass y getsimplename obtuve el tipo
		System.out.println(E + " es tipo: " + ((Object)E).getClass().getSimpleName());
		System.out.println(D + " es tipo: " + ((Object)D).getClass().getSimpleName());
		System.out.println(C + " es tipo: " + ((Object)C).getClass().getSimpleName());

	}
	
	/**
	 * Para esta task no quise crear cada valor sino que hice un for
	 * que me los creara aleatoriamente con la clase Random
	 * no se te vaya a olvidar importar los recursos de random (import java.util.Random;)
	 * @param cantidad: es la cantidad de numeros que voy a agregaar a la lista de tipo entero
	 * @return una lista de tipo doubles
	 */
	public static double[] createArray(int cantidad) {
		arreglo = new double[cantidad];
		Random nota = new Random();
		float minimo = 1.0f;
		float maximo = 5.0f;

		// Para generar un random con numeros decimales es una mierda
		// pero la operacion que se hace es para darle un rango de 1 a 5
		// busca en San Google para saber más
		for (int i = 0; i < cantidad; i++) {
			arreglo[i] = minimo + nota.nextDouble() * (maximo-minimo);
		}
	
		return arreglo;
	}
	
	/**
	 * imprime la lista de forma desordenada a como llegaron los numeros
	 */
	public static void imprimelista() {
		for (int i = 0; i < arreglo.length; i++) {
			System.out.println(arreglo[i]);
			
		}
	}
	
	/*
	 * imprime la lista de forma ordenado, no pude encontrar como invertir el orden
	 *  no se te vaya a olvidar importar la clase Array (import java.util.Arrays;)
	 * la lista de forma fácil te toca hacerlo manual porque 
	 * invertirl es otra mierda
	 */
	public static void imprimelistaOrdenada() {
	
		Arrays.sort(arreglo);
		// Aqui utilice la clase Decimal format para que solo me tome 2 decimales
		// No se te vaya olvidar importara (import java.text.DecimalFormat;)
		DecimalFormat df = new DecimalFormat("#.00");
		for (int i = 0; i < arreglo.length; i++) {
			System.out.println(df.format(arreglo[i]));
			
		}
	}

	/*
	 * recorro la lista, sumo cada uno de sus elementos y al final le saco promedio
	 */
	private static double impimirPromedio() {
		double suma = 0;
		for (int i = 0; i < arreglo.length; i++) {
			suma += arreglo[i];
		}
		return suma / arreglo.length;
	}
	
	/*
	 * utilizo la clase scanner para pedir los numeros por teclado
	 * no se te vaya a olvidar immportar los recursos de scanner (import java.util.Scanner;)
	 * y con un while lo repito la cantidad de veces que me pidan
	 */
	private static void numerosporTeclado(int cantidad) {
		Scanner scar = new Scanner(System.in);
		teclado = new int[cantidad];
		int i = 0;
		System.out.println("Escriba " + cantidad + " numeros");

		// Aqui utilizo un try catch para evitar que me coloquen algun
		// otro valor diferente de un numero
		while(i < cantidad) {
			System.out.println("Escriba un numero positivo o negativo");
			try {
				int numero = Integer.parseInt(scar.next());
				teclado[i] = numero;
				i++;


			} catch (Exception e) {
				System.out.println("debe escribir un numero");
			}

		}
	}
	
	/*
	 * Aqui simplemente imprimo la lista que me pasaron por teclado
	 */
	public static void imprimelistaTeclado() {
		for (int i = 0; i < teclado.length; i++) {
			System.out.println(teclado[i]);
			
		}
	}
	
	/*
	 * En esta parte lo que hago es diferenciar cuales son los numeros podsitivos
	 * y cuales son los negativos para despues sacarle la media a cada uno 
	 */
	private static void imprimeMedia_Positivo_negativo() {
		int positivos = 0;
		int cantP = 0;
		int negativos = 0;
		int cantN = 0;
		for (int i = 0; i < teclado.length; i++) {
			if (teclado[i] > 0) {
				positivos += teclado[i];
				cantP++;
			}
			else {
				negativos += teclado[i];
				cantN++;
			}
			
		}
		
		//En esta parte le coloque a cada resultado un try catch
		// en caso de que todos sean positivos y no haya ninguno negativo o viceversa
		// ya que si todos son positivos no hay ninguno negativo, asi que
		//la cantidad de negativos es cero y recorda que no se puede dividir por cero
		try {
			double result1 = (double) positivos / cantP;
			System.out.println("la media de los positivos es de:" + result1);

		} catch (ArithmeticException e) {
			System.out.println("la media de los positivos es de:" + 0);
		}
		try {
			double result2 = (double) negativos / cantN;
			System.out.println("la media de los negativos es de:" + result2);

		} catch (ArithmeticException e) {
			System.out.println("la media de los negativos es de:" + 0);
		}
	}

	
	/*
	 * hice lo mismo que el primer metodo para sacar los 100 numeros
	 * pero lo unico que cambia es la forma de hacer el ramdon
	 * Preguntale a San Google porque se debe hacer asi
	 */
	public static int[] createArray2(int cantidad) {
		arreglo2 = new int[cantidad];
		Random number = new Random();
		int minimo = 1;
		int maximo = 100;

		for (int i = 0; i < cantidad; i++) {
			arreglo2[i] = number.nextInt(maximo-minimo+1) + minimo ;
		}
	
		return arreglo2;
	}
	
 /*
  *  Saco el promedio
  */
	private static void promedioArray() {
		int suma = 0;
		for (int i = 0; i < arreglo2.length; i++) {
			//System.out.println(arreglo2[i]);
			suma += arreglo2[i];
		}
		System.out.println("La suma es de: " + suma );
		System.out.println("La media es de: " + (double)(suma/arreglo2.length) );

	}

	
	
	
	
	/*
	 * De esta forma se escribe el metodo main SIEMPRE...
	 * cualquier cosa que se utilice en el metodo main debes colocar
	 * static por eso en los metodos o variables le coloque static
	 * pero trata de por ahora no darle importancia solo se coloca static
	 * si lo llamas desde el main por obligacion sino te da error
	 * 
	 *  Para ejecutarlo y ver los resultados dale play que esta arribita y te debe de ejecutar
	 */
	public static void main(String arg[]) {

		/*
		 para cada task utilice divide y venceras para que el metodo no quede
		tan largo y lo hice por partes
	
		**/
		
		// task 1
		System.out.println("Task 1 \n");

		crearVariables();
		System.out.println("");

		// task 2
		System.out.println("Task 2 \n");
		createArray(6);
		imprimelista();
		System.out.println("");
		imprimelistaOrdenada();
		System.out.println("");
		//le doy formato directamente
		System.out.println(new DecimalFormat("#.00").format(impimirPromedio()));
		System.out.println("");
		
		// task 3
		System.out.println("Task 3 \n");
		numerosporTeclado(10);
		imprimelistaTeclado();
		imprimeMedia_Positivo_negativo();
		
		// task 4
		System.out.println("Task 4 \n");

		createArray2(100);
		promedioArray();
	}



}
