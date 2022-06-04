package Lista;

import static java.lang.System.exit;

public class ListaEncadeadaInteiros {
    private Nodo prim;
    private Nodo posicao;
    private int tamanho;


    public void criarLista() {
        prim = null;

    }

    public boolean listaVazia() {
        if (prim == null)
            return true;
        else
            return false;
    }

    // Inserir no inicio
    public void incluirInicio(int i) {
        Nodo novo = new Nodo();
        novo.setInicio(i);
        novo.setInfo(i);
        novo.setProx(prim);
        prim = novo;
        tamanho++;

    }

    public int getTamanho() {
        return tamanho;
    }

    public void incluir(int i, int posicao) {
        Nodo novo;

        // Move elemento para anterior
        Nodo anterior = null;
        // Percore a lista
        Nodo p = prim;

        // Procurar elemento na lista
        while (p != null && p.getInfo() == posicao) {
            anterior = p;
            p = p.getProx();
        }

        // Cria novo elemento
        novo = new Nodo();
        novo.setInfo(i);

        //Encadeia novo elemento
        if (anterior == null) { // Insere no inicio
            novo.setProx(prim);
            prim = novo;
        } else { // Insere no meio da lista
            novo.setProx(anterior.getProx());
            anterior.setProx(novo);
        }

        tamanho++;
    }


    // Buscar Elemento
    public Nodo getElemento(int i) throws ElementoNaoExisteException {
        Nodo p = this.prim;
        int aux = 0;
        if (prim != null) {
            while (aux != tamanho) {
                if (p.getInfo() == i) {
                    System.out.println("Elemento encontrado: " + p.getInfo());
                    exit(0);
                } else {
                    p = p.getProx();
                    aux++;
                }
            }
            throw new ElementoNaoExisteException();
        } else throw new ElementoNaoExisteException();
    }


    // Buscar Posicao
    public int get(int posicao) throws ElementoNaoExisteException {
        Nodo p = this.prim;
        int aux = 0;
        if (prim != null) {
            while (aux != tamanho) {
                if (p.getInfo() == posicao) {
                    System.out.println("Posição do elemento encontrado: " + aux);
                    exit(0);
                } else {
                    p = p.getProx();
                    aux++;
                }
            }
            throw new ElementoNaoExisteException();
        } else throw new ElementoNaoExisteException();
    }

    public boolean contem(int i) throws ElementoNaoExisteException {
        Nodo p = this.prim;
        int aux = 0;
        boolean aux1 = false;
        if (prim != null) {
            while (aux != tamanho) {
                if (p.getInfo() == i) {
                    System.out.println("Elemento encontrado: " + true);
                    exit(0);
                } else {
                    p = p.getProx();
                    aux++;
                }
            }
            System.out.println("Elemento encontrado: " + false);
        } else throw new ElementoNaoExisteException();
        return aux1;
    }


    public void incluirOrdenadoCres(int i) {
        Nodo novo;

        // Move elemento para anterior
        Nodo anterior = null;
        // Percore a lista
        Nodo p = prim;

        // Procurar elemento na lista
        while (p != null && p.getInfo() < i) {
            anterior = p;
            p = p.getProx();
        }

        // Cria novo elemento
        novo = new Nodo();
        novo.setInfo(i);

        //Encadeia novo elemento
        if (anterior == null) { // Insere no inicio
            novo.setProx(prim);
            prim = novo;
        } else { // Insere no meio da lista
            novo.setProx(anterior.getProx());
            anterior.setProx(novo);
        }
        tamanho++;
    }

    public void incluirOrdenadoDecres(int i) {
        Nodo novo;

        // Move elemento para anterior
        Nodo anterior = null;
        Nodo ultimo = null;
        // Percore a lista
        Nodo p = prim;


        // Procurar elemento na lista
        while (p != null && p.getInfo() > i) {
            anterior = p;
            p = p.getProx();
        }

        // Cria novo elemento
        novo = new Nodo();
        novo.setInfo(i);

        //Encadeia novo elemento
        if (anterior == null) { // Insere no inicio
            novo.setProx(prim);
            prim = novo;
        } else { // Insere no meio da lista
            novo.setProx(anterior.getProx());
            anterior.setProx(novo);
        }
        tamanho++;
    }

    public void remover(int i) {

        // Move o elemento para anterior
        Nodo anterior = null;

        // Percorre a lista
        Nodo p = prim;

        // Procura elemento na lista guardando anterior
        while (p != null && p.getInfo() != i) {
            anterior = p;
            p = p.getProx();
        }

        // Verifica se achou elemento
        if (p == null) {
            return; // Nao achou
        }

        // Retira o elemento
        if (p == null) {
            // Nao achou mantem primeiro
        }

        // Retira o elemento
        if (anterior == null) {
            prim = p.getProx(); // Retira elemento inicio
        } else {
            anterior.setProx(p.getProx()); // Retira do meio da lista
        }
        tamanho--;
    }

    public void limpar() {
        while (prim != null) {
            Nodo temp = prim.getProx();
            prim = null;
            prim = temp;
            tamanho = 0;
        }
    }


    // Imprimir lista
    public void exibir() {
        for (Nodo n = prim; n != null; n = n.getProx()) {
            System.out.println("Elemento: " + n.getInfo());
        }
        if (listaVazia() == true) {
            System.out.println("Lista está Vazia");
        }
    }

}



