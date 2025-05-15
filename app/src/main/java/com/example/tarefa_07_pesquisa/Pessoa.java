package com.example.tarefa_07_pesquisa;

import android.widget.EditText;

import java.util.ArrayList;

public class Pessoa {
    //DECLARANDO ATRIBUTOS
    private String respostaEspontanea; //variável de instância da classe
    public int respostaEstimulada01;
    public int respostaEstimulada02;
    public int respostaEstimulada03;
    public String problemasDaCidade;

    //Tela de Cadastro
    public String nome;
    public String celular;
    public String local;
    public String data;
    public String hora;

    public static ArrayList<Pessoa> listaEleitor = new ArrayList<>();


    //CONSTRUTOR
    public Pessoa(String respostaEspontanea, String problemasDaCidade){
        this.respostaEspontanea = respostaEspontanea;
        this.problemasDaCidade = problemasDaCidade;
    }

   /* public Pessoa(EditText edRespostaEspontanea) {
        this.respostaEspontanea = respostaEspontanea;
        this.respostaEstimulada01 = respostaEstimulada01;
        this.respostaEstimulada02 = respostaEstimulada02;
        this.respostaEstimulada03 = respostaEstimulada03;
        this.problemasDaCidade = problemasDaCidade;
        this.nome = nome;
        this.celular = celular;
        this.local = local;
        this.data = data;
        this.hora = hora;
    }
*/
    //GETTERS E SETTERS
    public static ArrayList<Pessoa> getListaEleitor() {
        return listaEleitor;
    }
    public static void setListaEleitor(ArrayList<Pessoa> listaEleitor) {
        Pessoa.listaEleitor = listaEleitor;
    }

    public String getRespostaEspontanea() {
        return respostaEspontanea;
    }

    public void setRespostaEspontanea(String respostaEspontanea) {
        this.respostaEspontanea = respostaEspontanea;
    }

    public int getRespostaEstimulada01() {
        return respostaEstimulada01;
    }

    public void setRespostaEstimulada01(int respostaEstimulada01) {
        this.respostaEstimulada01 = respostaEstimulada01;
    }

    public int getRespostaEstimulada02() {
        return respostaEstimulada02;
    }

    public void setRespostaEstimulada02(int respostaEstimulada02) {
        this.respostaEstimulada02 = respostaEstimulada02;
    }

    public int getRespostaEstimulada03() {
        return respostaEstimulada03;
    }

    public void setRespostaEstimulada03(int respostaEstimulada03) {
        this.respostaEstimulada03 = respostaEstimulada03;
    }

    public String getProblemasDaCidade() {
        return problemasDaCidade;
    }

    public void setProblemasDaCidade(String problemasDaCidade) {
        this.problemasDaCidade = problemasDaCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    /*
    public void setCadastro(String nome, String celular, String local, String data, String hora) {
        this.nome = nome;
        this.celular = celular;
        this.local = local;
        this.data = data;
        this.hora = hora;
    }
*/

}
