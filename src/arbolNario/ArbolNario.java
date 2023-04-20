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
		this.mostrarProfundidadRecursivo(raiz);
		System.out.println();
	}

	private void mostrarProfundidadRecursivo(NodoArbolNario nodo){
		System.out.print(nodo.getDato() + " ");
		IteradorAdelanteListaNodosArbolNario it = nodo.getHijos().getIteradorAdelante();
		while(nodo!=null && it.hasNext()){
			NodoArbolNario nodo2 = it.next();
			this.mostrarProfundidadRecursivo(nodo2);
		}
	}


	// ------------------------------------------------------------------------
	// TODO 2.3: Mostrar el arbol recorriendo en profundidad de forma ITERATIVA
	public void mostrarProfundidadIterativo() {
		System.out.print("Profundidad Iterativo: ");
		if(raiz!=null){
			PilaNodosArbolNario pila = new PilaNodosArbolNario();
			pila.apilar(raiz);
			while(!pila.vacia()) {
				NodoArbolNario nodo = pila.desapilar();
				System.out.print(nodo.getDato() + " ");
				IteradorAtrasListaNodosArbolNario it = nodo.getHijos().getIteradorAtras();
				while (it.hasPrevious())
					pila.apilar(it.previous());
			}
			System.out.print("\n");
		}

	}

	// ------------------------------------------------------------------------
	// TODO 2.4: Mostrar el arbol recorriendo en amplitud de forma ITERATIVA
	public void mostrarAmplitud() {
		System.out.print("Amplitud: ");

		System.out.println();
	}
}