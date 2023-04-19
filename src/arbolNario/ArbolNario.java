package arbolNario;

public class ArbolNario {

	private NodoArbolNario raiz;

	public ArbolNario(int dato) {
		raiz = new NodoArbolNario(dato);
	}

	public void insertar(ArbolNario arbol) {
		raiz.getHijos().insertar(arbol.raiz);
	}

	// ------------------------------------------------------------------------
	// TODO 2.2: Mostrar el arbol recorriendo en profundidad de forma RECURSIVA
	public void mostrarProfundidadRecursivo() {
		System.out.print("Profundidad Recursivo: ");
		System.out.print(raiz.getDato() + " ");
		this.mostrarProfundidadRecursivo(raiz);
		System.out.println();
	}

	private void mostrarProfundidadRecursivo(NodoArbolNario nodo){
		IteradorAdelanteListaNodosArbolNario it = nodo.getHijos().getIteradorAdelante();
		while(nodo!=null && it.hasNext()){
			NodoArbolNario nodo2 = it.next();
			System.out.print(nodo2.getDato() + " ");
			this.mostrarProfundidadRecursivo(nodo2);
		}
	}


	// ------------------------------------------------------------------------
	// TODO 2.3: Mostrar el arbol recorriendo en profundidad de forma ITERATIVA
	public void mostrarProfundidadIterativo() {
		System.out.print("Profundidad Iterativo: ");
		PilaNodosArbolNario pila = new PilaNodosArbolNario();
		IteradorAdelanteListaNodosArbolNario it = raiz.getHijos().getIteradorAdelante();
		while(it.hasNext()){
			pila.apilar(it.next());
		}
		while(!pila.vacia()){
			System.out.print(pila.desapilar().getDato() + " ");
		}
			System.out.println();
	}

	// ------------------------------------------------------------------------
	// TODO 2.4: Mostrar el arbol recorriendo en amplitud de forma ITERATIVA
	public void mostrarAmplitud() {
		System.out.print("Amplitud: ");

		System.out.println();
	}
}