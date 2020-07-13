package algorithmFunctions;

import java.util.Vector;

public class SortAlgorithmFunctions {

	private static long startTime = 0L, endTime = 0L;

	/*
	 * Para todos los algoritmos lo primero que hacemos es mirar si el tamaño del array es 0, en ese caso se saca un error dado que el tamaño tiene que ser mayor a 0, luego miramos si es 1, en ese caso se devuelve
	 * directamente el array sin hacer operaciones dado que el array de tamaño 1 ya esta ordenado.
	 * 
	 * Ademas para todos lo algoritmos antes de empezar a hacer los calculos primero llamamos a la funcion de nanoTime() de la clase system para sacar el tiempo que es en nanosegundos, cuando se termina el
	 * algoritmo se la vuelve a llamar, y haciendo la diferencia entre ambas sacamos el tiempo en nanosegundos que a tardado el algoritmo en ejecutarse.
	 */

	/*
	 * En el algoritmo de la burbuja hacemos un for anidado en el que el elemento i se compara con todos los elementos j, de manera que si hay un elemento j menor que i se intercambiaran quedando al final de la
	 * ejecucion del segundo for el numero mas pequeño en la posicion i.
	 */
	public static int [] bubbleSortAlgorithm(int [] numbers) throws Exception{

		if(numbers.length == 0) throw new Exception("The lenght of the array can not be 0.");
		else if(numbers.length == 1) return numbers;

		startTime = System.nanoTime();

		int index = 0;

		for(int i = 0; i < numbers.length; i++) {
			for(int j = i + 1; j < numbers.length; j++) {
				if(numbers[j] < numbers[i]) {
					index = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = index;
				}
			}
		}

		endTime = System.nanoTime();

		return numbers;
	}

	/*
	 * En el algoritmo de cocktail shaker sort o algoritmo de la burbuja bidereccional utilizo un bucle while, que se ejecuta mientras que i sea menor que j y j mayor que i, osea mientras que los indices
	 * no se crucen, o en el caso de que el algoritmo se ordene antes de que se lleguen a cruzarse los indices, lo que se hace es que con un booleano salgo del while en el caso de que no se haya hecho ningun
	 * cambio en el array durante la pasada del for porque significara que el algoritmo ya esta ordenado. Dentro del bucle while hay dos for, uno que recorre el array de abajo hacia arriba y el segundo que lo
	 * recorre de arriba hacia abajo.
	 * 
	 * Con el for de abajo hacia arriba lo que se hace es llevar el mayor numero de esa pasada del for a la ultima posicion del array que le corresponda, siempre lo primero es mirar si el siguiente numero es mayor
	 * que en el que se esta recorriendo en ese momento en el array, en el caso de que no lo sea el algoritmo entiende que el numero actual es mayor que el siguiente por lo que tendra que moverlo hacia arriba en el
	 * array, en el caso de que el siguiente sea mayor entonces el algoritmo entiende que el siguiente sera el mayor encontrado hasta el momento por lo que sera el numero que deba de mover hacia arriba en el array,
	 * para ello tan solo sigue el bucle sumando 1 al indice que recorre el array, y ahora el algoritmo tendra un nuevo numero mayor que habra de ir moviendo.
	 * 
	 * Una vez se haya encontrado la posicion que le corresponde al numero mayor en el array, ya no tendra que mirarse esa posicion para ordenar porque no habra ningun numero mayor que ese en el array, por lo que
	 * se resta en 1 al indice de la condicion del for, ahorrando comparaciones al algoritmo a la vez que se va ordenando.
	 * 
	 * En el caso del for de arriba hacia abajo sera lo mismo pero al reves, mirando si el siguiente es menor, y terminando por colocar el menor numero en su posicion correspondiente, y sumando 1 al indice de la
	 * condicion del for.
	 */
	public static int [] cocktailShakerSortAlgorithm(int [] numbers) throws Exception{

		if(numbers.length == 0) throw new Exception("The lenght of the array can not be 0.");
		else if(numbers.length == 1) return numbers;

		startTime = System.nanoTime();

		int i = 0, j = numbers.length - 1, index;
		boolean change;

		while(i < j && j > i) {

			change = false;

			//Forward to set the max i number in the i iteration
			for(int k = i; k < j; k++) {
				if(numbers[k] > numbers[k+1]) {
					index = numbers[k];
					numbers[k] = numbers[k+1];
					numbers[k+1] = index;
					change = true;
				}
			}

			if(!change) break;
			j--;

			//Backward to set the min i number in the i iteration
			for(int l = j; l > i; l--) {
				if(numbers[l] < numbers[l-1]) {
					index = numbers[l];
					numbers[l] = numbers[l-1];
					numbers[l-1] = index;
					change = true;
				}
			}

			if(!change) break;
			i++;
		}

		endTime = System.nanoTime();

		return numbers;
	}

	/*
	 * En el algoritmo de ordenacion por seleccion lo que se utiliza es un for anidado, lo que se hace es ir recorriendo el array como en el algoritmo de la burbuja pero en este caso con el segundo for lo que se
	 * hace es encontrar el menor numero del array, una vez encontrado ese numero sera el que habra que cambiar en posicion i, de esta manera nos ahorramos cambios innecesarios como en el algortimo de la burbuja.
	 */
	public static int [] selectionSortAlgorithm(int [] numbers) throws Exception{

		if(numbers.length == 0) throw new Exception("The lenght of the array can not be 0.");
		else if(numbers.length == 1) return numbers;

		startTime = System.nanoTime();

		int currentMin, currentMinIndex = 0, index = 0;

		for(int i = 0; i < numbers.length; i++) {
			currentMin = numbers[i];
			currentMinIndex = i;

			for(int j = i; j < numbers.length; j++) {
				if(numbers[j] < currentMin) {
					currentMin = numbers[j];
					currentMinIndex = j;
				}
			}

			index = numbers[i];
			numbers[i] = currentMin;
			numbers[currentMinIndex] = index;
		}

		endTime = System.nanoTime();

		return numbers;
	}

	/*
	 * En el algoritmo de insercion lo que se hace es ir recorriendo con un for el array. Dentro del for lo primero que se mira es si el siguiente numero es mayor que el actual, en ese caso tendriamos un nuevo
	 * numero mayor en el array que guardo en la variable currentMax, en caso contrario querra decir que es un numero menor por lo que tendra que ir mas atras en las posiciones del array. Lo siguiente que se haria
	 * si fuese un numero menor seria guardarlo en una variable para no perder el valor cuando hagamos el cambio de posiciones, lo siguiente es con un for encontrar la posicion en la que debe ir el numero, 
	 * recorriendo el array desde el indice del numero maximo actual hasta el indice 0 del array. Una vez encontrada la posicion hay que hacer otro for para mover todos los numeros mayores al que se va a cambiar
	 * 1 posicion hacia arriba de modo que no se sobreescriba la informacion dentro del array, y una vez movidos todos se intercambia el numero en el indice encontrado con el anterior for. Se termina por sumar 1 
	 * al indice del numero mayor actual ya que se ha tenido que cambiar 1 hacia arriba su posicion en el array.
	 */
	public static int [] insertionSortAlgorithm(int [] numbers) throws Exception{

		if(numbers.length == 0) throw new Exception("The lenght of the array can not be 0.");
		else if(numbers.length == 1) return numbers;

		startTime = System.nanoTime();

		int currentMax = numbers[0], currentMaxIndex = 0, swapValue, swapIndex = 0;

		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] >= currentMax) {
				currentMax = numbers[i];
				currentMaxIndex = i;
			}else {
				swapValue = numbers[i];

				for(int j = currentMaxIndex; j >= 0; j--) {
					if(j == 0) {
						swapIndex = 0;
						break;
					}else if(numbers[j+1] >= numbers[i] && numbers[j-1] < numbers[i]) {
						swapIndex = j;
						break;
					}
				}

				for(int k = currentMaxIndex; k >= 0; k--) {
					if(k != swapIndex) {
						numbers[k+1] = numbers[k];
					}else {
						numbers[k+1] = numbers[k];
						numbers[k] = swapValue;
						break;
					}
				}

				currentMaxIndex++;
			}
		}

		endTime = System.nanoTime();

		return numbers;
	}

	/*
	 * En el algoritmo de ordenamiento por cuentas lo primero que hago es encontrar en el array el numero mayor y menor, una vez encontrados creo un array con tantas posiciones como la diferencia entre el mayor y
	 * el menor mas 1. Una vez tenemos el array creado, lo que se hace es contar en el array original cuantos numeros hay de cada uno, contandolos de menor a mayor, y se va introduciendo la cuenta en el array
	 * creado, de este modo nos quedara un array con el numero de veces que se repite cada numero ordenado de menor a mayor. Cuando se ha terminado de hacer el conteo, se termina por recorrer el array de cuentas y
	 * se vuelve a introducir los numeros en el array original.
	 */
	public static int [] countingSortAlgorithm(int [] numbers) throws Exception{

		if(numbers.length == 0) throw new Exception("The lenght of the array can not be 0.");
		else if(numbers.length == 1) return numbers;

		startTime = System.nanoTime();

		int min = numbers[0], auxMin = 0, max = numbers[0], count, initialIndex = 0;

		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] < min) min = numbers[i];
			if(numbers[i] > max) max = numbers[i];
		}

		auxMin = min;

		int [] auxArray = new int [(max - min) + 1];

		for(int i = 0; i < auxArray.length; i++) {
			count = 0;
			for(int j = 0; j < numbers.length; j++) {
				if(numbers[j] == auxMin) count++;
			}

			auxArray[i] = count;
			auxMin++;
		}

		for(int i = 0; i < auxArray.length; i++) {
			for(int j = initialIndex; j < (initialIndex + auxArray[i]); j++) {
				numbers[j] = min;
			}
			initialIndex += auxArray[i];
			min++;
		}

		endTime = System.nanoTime();

		return numbers;
	}

	/*
	 * En algoritmo de ordenamiento gnome lo que se hace es ir recorriendo el array de abajo arriba, en cada pasada del for que recorre el array, lo que se hace es comparar el numero actual con el anterior,
	 * de manera que si el numero actual es menor que el anterior se hace el cambio de posiciones y se resta 1 al indice del for para que en la siguiente pasada se comparen el numero que se acaba de intercambiar
	 * con el anterior, se repite este mismo proceso hasta que el anterior sea menor que el actual en ese caso el numero quedara ordenado.
	 * Cuando se da que el anterior es menor que el actual o que la posicion del indice es 0, tan solo se suma 1 al indice que recorre el array.
	 */
	public static int [] gnomeSortAlgorithm(int [] numbers) throws Exception{

		if(numbers.length == 0) throw new Exception("The lenght of the array can not be 0.");
		else if(numbers.length == 1) return numbers;

		startTime = System.nanoTime();

		int index = 0;

		for(int i = 0; i < numbers.length;) {
			if(i == 0) i++;
			else {
				if(numbers[i-1] > numbers[i]) {
					index = numbers[i-1];
					numbers[i-1] = numbers[i];
					numbers[i] = index;
					i--;
				}else i++;
			}
		}

		endTime = System.nanoTime();

		return numbers;
	}

	/*
	 * El algoritmo de ordenamiento gnome optimizado hace lo mismo que el algoritmo gnome pero con la diferencia de que en este caso se guarda el indice desde el que se empezo a ordenar el ultimo numero,
	 * de esta menera el algoritmo se ahorra tener que volver a subir por todo el array hasta encontrar el siguiente numero a ordenar, directamente sube al maximo numero ordenado y sigue ordenando desde ahí.
	 */
	public static int [] optimizedGnomeSortAlgorithm(int [] numbers) throws Exception{

		if(numbers.length == 0) throw new Exception("The lenght of the array can not be 0.");
		else if(numbers.length == 1) return numbers;

		startTime = System.nanoTime();

		int [] auxArray;

		for(int i = 0; i < numbers.length; i++) {
			auxArray = optimizedGnomeSortAlgorithm(numbers, i);
			numbers = auxArray;
		}

		endTime = System.nanoTime();

		return numbers;
	}

	private static int [] optimizedGnomeSortAlgorithm(int [] numbers, int pos) throws Exception{

		if(numbers.length == 0 || numbers.length == 1) throw new Exception("This should not happen.");

		int index = 0;

		while((pos > 0) && (numbers[pos-1] > numbers[pos])) {
			index = numbers[pos-1];
			numbers[pos-1] = numbers[pos];
			numbers[pos] = index;
			pos--;
		}

		return numbers;
	}

	public static int [] oddEvenSortAlgorithm(int [] numbers) throws Exception{

		if(numbers.length == 0) throw new Exception("The lenght of the array can not be 0.");
		else if(numbers.length == 1) return numbers;

		startTime = System.nanoTime();

		int oddEven = 0, index = 0;
		boolean oddChange = true, evenChange = true;

		if(numbers.length %2 == 0) {
			while(oddChange || evenChange) {
				if(oddEven == 0) {
					//Odd
					oddChange = false;
					for(int i = 0, j = 1; i < numbers.length-1 && j < numbers.length;) {
						if(numbers[i] > numbers[j]) {
							index = numbers[i];
							numbers[i] = numbers[j];
							numbers[j] = index;
							oddChange = true;
						}
						i += 2;
						j += 2;
					}
					oddEven++;
				}else {
					//Even
					evenChange = false;
					for(int i = 1, j = 2; i < numbers.length-2 && j < numbers.length-1;) {
						if(numbers[i] > numbers[j]) {
							index = numbers[i];
							numbers[i] = numbers[j];
							numbers[j] = index;
							evenChange = true;
						}
						i += 2;
						j += 2;
					}
					oddEven--;
				}
			}
		}else {
			while(oddChange || evenChange) {
				if(oddEven == 0) {
					//Odd
					oddChange = false;
					for(int i = 1, j = 2; i < numbers.length-1 && j < numbers.length;) {
						if(numbers[i] > numbers[j]) {
							index = numbers[i];
							numbers[i] = numbers[j];
							numbers[j] = index;
							oddChange = true;
						}
						i += 2;
						j += 2;
					}
					oddEven++;
				}else {
					//Even
					evenChange = false;
					for(int i = 0, j = 1; i < numbers.length-2 && j < numbers.length-1;) {
						if(numbers[i] > numbers[j]) {
							index = numbers[i];
							numbers[i] = numbers[j];
							numbers[j] = index;
							evenChange = true;
						}
						i += 2;
						j += 2;
					}
					oddEven--;
				}
			}
		}

		endTime = System.nanoTime();

		return numbers;
	}

	public static int [] cycleSortAlgorithm(int [] numbers) throws Exception{

		if(numbers.length == 0) throw new Exception("The lenght of the array can not be 0.");
		else if(numbers.length == 1) return numbers;

		int count = 0, correctIndex = 0, swapNum, nextNum, initialSwapIndex = 0;

		for(int i = 0; i < numbers.length; i++) {
			count = 0;
			for(int j = 0; j < numbers.length; j++) {
				if(numbers[j] < numbers[i]) count++;
			}

			if(i == count) continue;
			else {
				swapNum = numbers[i];
				initialSwapIndex = count;
				do {
					if(numbers[count] != swapNum) {
						nextNum = numbers[count];
						numbers[count] = swapNum;
						swapNum = nextNum;
						
						count = 0;
						for(int k = 0; k < numbers.length; k++) {
							if(numbers[k] < nextNum && k != initialSwapIndex) count++;
						}
					}else {
						for(int l = count; l < numbers.length;) {
							if(numbers[l] == numbers[count]) continue;
							else {
								correctIndex = l;
								break;
							}
						}
						nextNum = numbers[correctIndex];
						numbers[correctIndex] = swapNum;
						swapNum = nextNum;
					}
				}while(count != i);
				
				numbers[i] = swapNum;
			}
		}

		return numbers;
	}

	public static int [] quickSortAlgorithm(int [] numbers, Vector<Integer> pivotIndexVector, String election, int leftIndex, int rightIndex) throws Exception{

		if(election == null) throw new Exception("The election of the pointer cant be null");
		else if(numbers.length == 0) throw new Exception("The lenght of the array can not be 0.");
		else if(numbers.length == 1) return numbers;

		int pivotValue = 0, pivotIndex = 0;
		//int initialLeftIndex = leftIndex, initialRightIndex = rightIndex;

		if(election.equals("randomPivot")) {
			pivotIndex = (int) Math.random() * (rightIndex + 1);
			pivotValue = numbers[pivotIndex];
		}else if(election.equals("middlePivot")){
			int suma = (numbers[leftIndex] + numbers[leftIndex + 1] + numbers[rightIndex]) / 3;

			if(suma == numbers[leftIndex]) {
				pivotIndex = leftIndex;
				pivotValue = numbers[leftIndex];
			}else if(suma == numbers[leftIndex + 1]) {
				pivotIndex = leftIndex + 1;
				pivotValue = numbers[leftIndex + 1];
			}else {
				pivotIndex = rightIndex;
				pivotValue = numbers[rightIndex];
			}
		}else if(election.equals("betterPivot")) {
			int suma = 0;

			for(int i = leftIndex; i < rightIndex; i++) {
				suma += numbers[i];
			}

			pivotValue = suma / (rightIndex - leftIndex);

			for(int i = leftIndex; i < rightIndex; i++) {
				if(numbers[i] == pivotValue) {
					pivotIndex = i;
					break;
				}
			}
		}

		int index = 0;

		while(leftIndex != rightIndex) {
			if(numbers[leftIndex] > pivotValue && numbers[rightIndex] < pivotValue) {
				index = numbers[leftIndex];
				numbers[leftIndex] = numbers[rightIndex];
				numbers[rightIndex] = index;
				leftIndex++;
				rightIndex--;
			}else if(numbers[leftIndex] < pivotValue) leftIndex++;
			else if(numbers[rightIndex] >= pivotValue) rightIndex--;
			else {
				leftIndex++;
				rightIndex--;
			}
		}

		index = numbers[pivotIndex];
		numbers[pivotIndex] = numbers[rightIndex];
		numbers[rightIndex] = index;

		pivotIndexVector.add(rightIndex);

		quickSortAlgorithm(numbers, pivotIndexVector, election, 0, leftIndex - 1);
		quickSortAlgorithm(numbers, pivotIndexVector, election, leftIndex + 1, numbers.length - 1);

		return numbers;
	}

	public static long timeOfAlgorithm() {
		return endTime - startTime;
	}
}
