package com.ubots.teste.domain;

public class Solicitacao {
    private int numero;
    private Atendente atendente;
    private String descricao;
    private TipoSolicitacaoEnum tipo;

    
    public Solicitacao() {
    }


    public Solicitacao(int numero, Atendente atendente, String descricao, TipoSolicitacaoEnum tipo) {
        this.numero = numero;
        this.atendente = atendente;
        this.descricao = descricao;
        this.tipo = tipo;
    }


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public Atendente getAtendente() {
        return atendente;
    }


    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public TipoSolicitacaoEnum getTipo() {
        return tipo;
    }


    public void setTipo(String tipoA) {
        TipoSolicitacaoEnum tipo;
        if(tipoA.equalsIgnoreCase("c")){
            tipo =  TipoSolicitacaoEnum.CARTÕES;
        }else if(tipoA.equalsIgnoreCase("e")){
            tipo =  TipoSolicitacaoEnum.EMPRÉSTIMOS;
        }else{
            tipo = TipoSolicitacaoEnum.OUTROS_ASSUNTOS;
        }
        this.tipo = tipo;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        result = prime * result + ((atendente == null) ? 0 : atendente.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Solicitacao other = (Solicitacao) obj;
        if (numero != other.numero)
            return false;
        if (atendente == null) {
            if (other.atendente != null)
                return false;
        } else if (!atendente.equals(other.atendente))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (tipo != other.tipo)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Solicitacao [numero=" + numero + ", atendente=" + atendente + ", descricao=" + descricao + ", tipo="
                + tipo + "]";
    }
    
}
