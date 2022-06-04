package Estrutura.ProvaEstruraDados1.Lista;

public class ListaEnc<T extends Comparable<T>> extends Lista<T> {


    private No<T> primmeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaEnc() {
        this.primmeiroNo = null;
        this.ultimoNo = null;

    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        No<T> novoNo = new No<>(elemento);
        if (estaVazia()) {
            this.primmeiroNo = novoNo;
        } else {
            this.ultimoNo.setProx(novoNo);
        }
        this.ultimoNo = novoNo;
        this.tamanho++;
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        incluir(elemento, 0);
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {

        if (posicao == 0) {
            No<T> novoNo = new No<T>(elemento);
            novoNo.setProx(this.primmeiroNo);
            this.primmeiroNo = novoNo;
        } else if (posicao == this.getTamanho() - 1) {
            No<T> novoNo = new No<T>(elemento);
            this.ultimoNo.setProx(novoNo);
            this.ultimoNo = novoNo;
        } else {
            No<T> noAnterior = recuperarNo(posicao - 1);
            No<T> noAtual = recuperarNo(posicao);
            No<T> novoNo = new No<T>(elemento);
            noAnterior.setProx(novoNo);
            novoNo.setProx(noAtual);
        }
        this.tamanho++;

    }

    private No<T> recuperarNo(int posicao) {
        if (posicao >= getTamanho()) {
            throw new IllegalArgumentException(String.format("Posição inválida [%d]", posicao));

        }
        No<T> resultado = null;
        for (int i = 0; i <= posicao; i++) {
            if (i == 0) {
                resultado = this.primmeiroNo;
            } else {
                resultado = resultado.getProx();
            }
        }
        return resultado;
    }

    @Override
    public T get(int posicao) throws Exception {
        No<T> no = recuperarNo(posicao);
        if (no != null) {
            return no.getDado();
        }
        return null;
    }


    @Override
    public int getPosElemento(T elemento) throws Exception {
        for (int i = 0; i < getTamanho(); i++) {
            No<T> noAtual = recuperarNo(i);
            if (noAtual.getDado() != null && noAtual.getDado().equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public void remover(int posicao) throws Exception {
        if (posicao >= getTamanho()) {
            throw new IllegalArgumentException(String.format("Posição inválida [%d]", posicao));

        }
        if (posicao == 0) {
            No<T> proximoNo = this.primmeiroNo.getProx();
            this.primmeiroNo.setProx(null);
            this.primmeiroNo = proximoNo;
        } else if (posicao == getTamanho() - 1) {
            No<T> penultimoNo = recuperarNo(getTamanho() - 2);
            penultimoNo.setProx(null);
            this.ultimoNo = penultimoNo;
        } else {
            No<T> noAnterior = recuperarNo(posicao - 1);
            No<T> proximoNo = recuperarNo(posicao + 1);
            No<T> noAtual = recuperarNo(posicao);
            noAnterior.setProx(proximoNo);
            noAtual.setProx(null);

        }
        this.tamanho--;

    }

    public void limpar() {
        tamanho = 0;
        primmeiroNo = ultimoNo = null;
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

}