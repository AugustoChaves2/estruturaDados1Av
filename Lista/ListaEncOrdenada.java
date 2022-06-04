package Estrutura.ProvaEstruraDados1.Lista;

public class ListaEncOrdenada<T extends Comparable<T>> extends ListaEnc<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;


    public ListaEncOrdenada(Class<T> dataType) {
        inicio = null;
        ultimo = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    @Override
    public void incluir(T elemento) throws Exception {

        No<T> novo = new No<T>(elemento);
        novo.setDado(elemento);
        if (estaVazia()) {
            inicio = novo;
            ultimo = novo;
            ultimo.setProx(inicio);
        } else {
            ultimo.setProx(novo);
            novo.setProx(inicio);
            ultimo = novo;
        }
        tamanho++;
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {

        No<T> novo = new No<T>(elemento);
        novo.setDado(elemento);
        if (estaVazia()) {
            inicio = novo;
            ultimo = novo;
            ultimo.setProx(inicio);
        } else {
            novo.setProx(inicio);
            inicio = novo;
            ultimo.setProx(inicio);
        }
        tamanho++;
    }

    public void incluirOrdenadoCres(T elemento){
        No<T> novo = new No<T>(elemento);
        novo.setDado(elemento);




    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {

        if (posicao >= 0 && posicao >= tamanho) {
            No<T> novo = new No<T>(elemento);
            novo.setDado(elemento);
            if (posicao == 0) {
                novo.setProx(inicio);
                inicio = novo;
                ultimo.setProx(inicio);
            } else {
                if (posicao == tamanho) {
                    ultimo.setProx(novo);
                    novo.setProx(inicio);
                    ultimo = novo;
                } else {
                    No<T> aux = inicio;
                    for (int i = 0; i < (posicao - 1); i++) {
                        aux = aux.setProx();
                    }
                    No<T> seguinte = aux.setProx();
                    aux.setProx(novo);
                    novo.setProx(seguinte);
                }
            }
            tamanho++;
        }

    }

    @Override
    public T get(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            if (posicao == 0) {
                return inicio.getDado();
            } else {
                No<T> aux = inicio;
                for (int i = 0; i < posicao; i++) {
                    aux = aux.setProx();
                }
                return aux.getDado();
            }
        } else {
            throw new Exception("Posição inexistente na lista. ");
        }

    }

    @Override
    public int getPosElemento(T elemento) throws Exception {
        if (contem(elemento)) {
            No<T> aux = inicio;
            int cont = 0;
            while (elemento != aux.getDado()) {
                cont++;
                aux = aux.setProx();
            }
            return cont;
        } else {
            throw new Exception("Valor inexistente na lista");
        }
    }

    @Override
    public void remover(int posicao) throws Exception {

        if (posicao >= 0 && posicao < tamanho) {
            if (posicao == 0) {
                inicio = inicio.setProx();
                ultimo.setProx(inicio);
            } else {
                No<T> aux = inicio;
                for (int i = 0; i < posicao - 1; i++) {
                    aux = aux.setProx();
                }
                if (aux.setProx() == ultimo) {
                    aux.setProx(inicio);
                    ultimo = aux;
                } else {
                    No<T> seguinte = aux.setProx();
                    aux.setProx(seguinte.setProx());
                }
            }
            tamanho--;
        }

    }

    @Override
    public void limpar() {
        inicio = null;
        ultimo = null;
        tamanho = 0;

    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public boolean contem(T elemento) throws Exception {
        for (int i = 0; i < getTamanho(); i++) {
            No<T> noAtual = recuperarNo(i);
            if (noAtual.getDado() != null && noAtual.getDado().equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    private No<T> recuperarNo(int posicao) {
        if (posicao >= getTamanho()) {
            throw new IllegalArgumentException(String.format("Posição invalida[%d]", posicao));
        }
        No<T> resultado = null;
        for (int i = 0; i <= posicao; i++) {
            if (i == 0) {
                resultado = this.inicio;
            } else {
                resultado = resultado.setProx();
            }
        }
        return resultado;
    }
}
