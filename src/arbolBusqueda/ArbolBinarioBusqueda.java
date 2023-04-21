package arbolBusqueda;

public class ArbolBinarioBusqueda {

	private NodoArbol raiz;

	public ArbolBinarioBusqueda() {
		raiz = null;
	}

	// Muestra los elementos del arbol binario en orden central ---------------
	public void mostrar() {
		this.mostrar(raiz, "  ");
	}

	private void mostrar(NodoArbol nodo, String espacios) {
		if (nodo != null) {
			this.mostrar(nodo.getIzquierdo(), espacios + "    ");
			System.out.print(espacios);
			nodo.getDato().mostrar();
			this.mostrar(nodo.getDerecho(), espacios + "    ");
		}
	}

	// Inserta un elemento con una cierta clave -------------------------------
	public void insertar(Alumno dato) {
		raiz = this.insertarRec(raiz, dato);
	}

	private NodoArbol insertarRec(NodoArbol nodo, Alumno dato){
		if (nodo == null) {     // Crear nuevo nodo
			nodo = new NodoArbol(dato);
		} else if (dato.getMatricula() < nodo.getDato().getMatricula()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), dato);
			nodo.setIzquierdo(nuevoIzq);
		} else if (dato.getMatricula() > nodo.getDato().getMatricula()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), dato);
			nodo.setDerecho(nuevoDer);
		} else {      // Clave repetida
			System.out.println("Error. El alumno con matrícula " + dato.getMatricula() + " ya existe");
		}
		return nodo;    // Devolver la nueva raíz del subárbol
	}


	// ------------------------------------------------------------------------
	// TODO 3.2: Devuelve el numero de nodos del arbol de forma RECURSIVA
	public int getNumElementos() {
		return this.getNumElementos(raiz);
	}

	private  int getNumElementos(NodoArbol nodo){
		if(nodo != null) {
			return 1 + this.getNumElementos(nodo.getIzquierdo()) + this.getNumElementos(nodo.getDerecho());
		}
		return 0;
	}


	// ------------------------------------------------------------------------
	// TODO 3.3: Devuelve el numero de nodos del arbol con clave
	// menor a una clave dada de forma RECURSIVA
	public int getNumMenores(int clave) {
		return getNumMenores(raiz, clave);
	}

	private int getNumMenores(NodoArbol nodo, int clave){
		if(nodo == null) {
			return 0;
		}
		if(nodo.getDato().getMatricula() < clave) {
			return 1 + this.getNumMenores(nodo.getIzquierdo(), clave) + this.getNumMenores(nodo.getDerecho(), clave);
		}else
			return this.getNumMenores(nodo.getIzquierdo(), clave);

	}

	// ------------------------------------------------------------------------
	// TODO 3.4: Devuelve el elemento con la menor clave de forma RECURSIVA
	public Alumno getMenorElemento() {
		return getMenorElemento(raiz);
	}
	private Alumno getMenorElemento(NodoArbol nodo){
		if (nodo == null) {
			return null;
		}
		if(nodo.getIzquierdo() == null) {
			return nodo.getDato();
		}
		return this.getMenorElemento(nodo.getIzquierdo());
	}


	// ------------------------------------------------------------------------
	// TODO 3.5: Devuelve el número de nodos del árbol con clave mayor que
	// claveMinimo y menor que claveMaximo
	public int getNumIntermedios(int claveMinimo, int claveMaximo) {
		return getNumIntermedios(raiz, claveMinimo, claveMaximo);
	}

	private int getNumIntermedios(NodoArbol nodo, int claveMinimo, int claveMaximo){
		if (nodo == null) {
			return 0;
		}
		int contador = 0;
		int claveActual = nodo.getDato().getMatricula();
		if (claveActual > claveMinimo && claveActual < claveMaximo) {
			contador++;
			contador += getNumIntermedios(nodo.getIzquierdo(), claveMinimo, claveMaximo);
			contador += getNumIntermedios(nodo.getDerecho(), claveMinimo, claveMaximo);
		} else if (claveActual <= claveMinimo) {
			contador += getNumIntermedios(nodo.getDerecho(), claveMinimo, claveMaximo);
		} else if (claveActual >= claveMaximo) {
			contador += getNumIntermedios(nodo.getIzquierdo(), claveMinimo, claveMaximo);
		}
		return contador;
	}

}


