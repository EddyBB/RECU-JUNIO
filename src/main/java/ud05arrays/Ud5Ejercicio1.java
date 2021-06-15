/**
 * 
 */
package ud05arrays;

import helpers.Helper;

/**
 * @author eserrano
 *
 */
public class Ud5Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object [][] datosVirus= {
				{"Coronavirus",3,0.125f},
				{"Sarampión",12,0.0001f},
				{"Viruela", 7,0.00015f},
				{"Paperas",4,0.00001f},
				{"Ébola",2,0.199f}
		};
		
		Virus[] arrayVirus = crearArrayVirus(datosVirus);
		
		imprimeVirus(arrayVirus,"Pares",true);
		imprimeVirus(arrayVirus,"Impares",false);
		
	}
	
	/**
	 * El método debe crear un nuevo Array de Virus usando los 
	 * datos que se pasan como parametro.
	 * 
	 * @param datosBolas datos de las bolas en array bidimensional de 
	 * numero de filas variable y longitud de columnas = 3,
	 * la primera columna de cada fila tiene el String nombre del virus
	 * la segunda el Integer tasa de reproducción r0
	 * la tercera el Float tasa de letalidad
	 * @return Nuevo array con los Virus creados.
	 */
	public static Virus[] crearArrayVirus(Object[][] datosVirus) {
		
		Virus[] v = new Virus[datosVirus.length];
		int i = 0;
		for (Object[] virus : datosVirus) {
			v[i] = new Virus((String)virus[0], (Integer)virus[1], (Float)virus[2]);
			i++;
		}
		
		return v;
	}
	

	/**
	 * Metodo que Imprime un array de Virus.
	 * 
	 * Se imprimiran los virus que ocupan posicion par si el parametro pares
	 * es true. Ej: 0, 2, 4, 6, ...
	 * 
	 * Se imprimiran los virus que ocupan posición impar si el parametro pares
	 * es false. Ej: 1, 3, 5, 7, ...
	 * 
	 * Por cada virus a imprimir, hacer un print en una linea 
	 * con la informacion que el virus proporciona de forma predeterminada
	 *  en su metodo toString
	 * 
	 * NOTA: Modificar sobrescribiendo el comentario TODO y no modificar ni borrar las lineas ya existentes
	 */
	public static void imprimeVirus(Virus[] array, String titulo, boolean pares) {
		System.out.println(titulo + ": --------------------");
		
		int inicio = pares ? 0 : 1;
		for (int i = inicio; i < array.length; i = i +2) {
			System.out.println(array[i]);
		}
		
		System.out.println("-----------------------------");
	}
	
	/**
	 * El metodo ordena UNA COPIA del array que se pasa como parametro
	 * 
	 * El orden ha de ser ASCENDENTE, De Menor a Mayor
	 * 
	 * RECUERDA QUE EL METODO TRABAJA SOBRE UNA COPIA
	 * NO DEBE MODIFICAR EL ARRAY ORIGINAL.
	 * PISTA: Clona el array antes de ordenar.
	 * 
	 * @param array A clonar y ordenar
	 * @return copia ordenada del array pasado como parametro
	 */
	public static Virus[] ordena(final Virus[] array) {
		
		Virus[] copia = array.clone();
		
		 for (int i = 0; i < copia.length; i++) {
			for (int j = i+1; j < copia.length; j++) {
				if (copia[j].compareTo(copia[i]) < 0) {
					Helper.swap(copia, i, j);
				}
			}
		}
		
		return copia;
	}
	
	/**
	 * Elimina todas las veces que aparece un Virus en un Array.
	 * 
	 * Debe devolver un nuevo array que contiene de forma consecutiva todos
	 * los elementos que no se han eliminado en las primeras posiciones.
	 * En las últimas posiciones del array quedarán los huecos nulos
	 * pertenecientes a las eliminaciones producidas
	 * 
	 * Ejemplo:
	 * 
	 * Eliminar 3 en [6,5,1,8,3,9,9,3,2,null,null]
	 * Debe devolver: [6,5,1,8,9,9,2,null,null,null,null]
	 * 
	 * RECUERDA QUE EL METODO TRABAJA SOBRE UNA COPIA
	 * NO DEBE MODIFICAR EL ARRAY ORIGINAL.
	 * PISTA: Clona el array antes de eliminar.
	 * 
	 * @param Virus de muestra a borrar
	 * @return nuevo array sin los eliminados.
	 */
	public static Virus[] eliminaVirus(Virus v,final Virus[] array) {
		
		Virus[] copia = array.clone();
		if (copia !=null) {
			for (int i = 0; i < copia.length; i++) {
				while (copia[i] != null && v.equals(copia[i])) {
					copia[i] = null;
					
					for (int j = i; j < copia.length - 1; j++) {
						Helper.swap(copia, j, j + 1);
					}
				}
			}
		}
		
		return copia;
	}
	
	/**
	 * Encuentra en el Array los virus que sean igual o más
	 * peligrosos que el Virus que se pasa como parámetro
	 * 
	 * Se considera que un Virus es más peligroso que otro
	 * usando la relación r0 * letalidad. A mayor Valor, mayor 
	 * peligrosidad
	 * 
	 * @param v
	 * @return array con los índices de los elementos peligrosos, 
	 * null si no hay ninguno más peligroso
	 */
	public static int [] encuentraPeligrosos(Virus v, Virus[] array) {
		
		Float umbral = v.getR0() * v.getLetalidad();
		int[] retorno = new int[array.length];
		
		int j = 0;
		for (int i = 0; i < retorno.length; i++) {
			Float letalidad = array[i].getR0() * array[i].getLetalidad();
			if (letalidad >= umbral) {
				retorno[j] = i;
				j++;
			}
		}
		
		int[] nuevo = null;
		if (j > 0) {
			nuevo = new int[j];
			for (int i = 0; i < nuevo.length; i++) {
				nuevo[i] = retorno[i];
			}
		}
		
		
		return nuevo;
	}
	
	
	
	

}
