package Estrutura.ProvaEstruraDados1.Lista;

public class No<T> {

    public T dado;
    public No prox;

    public No(T dado) {
        this.dado = dado;
        this.prox = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public No<T> getProx() {
        return prox;
    }

    public void setProx(No<T> prox) {
        this.prox = prox;
    }

    public No<T> setProx() {
        return prox;
    }


}