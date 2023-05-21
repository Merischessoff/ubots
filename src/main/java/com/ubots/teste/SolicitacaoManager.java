package com.ubots.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ubots.teste.domain.Atendente;
import com.ubots.teste.domain.Categoria;
import com.ubots.teste.domain.Solicitacao;
import com.ubots.teste.domain.Time;

@Component
public class SolicitacaoManager {
    private static List<Atendente> atendentesDisponiveis = new ArrayList<Atendente>();
    private static List<Atendente> atendentesIndisponiveis = new ArrayList<Atendente>();
    private static List<Solicitacao> solicitacaosAndamento = new ArrayList<Solicitacao>();
    private static List<Solicitacao> solicitacaosEspera = new ArrayList<Solicitacao>();

    private static int numeroSolicitacao = 0;

    public SolicitacaoManager() {
    }

    public List<Atendente> getAtendentesDisponiveis() {
        return atendentesDisponiveis;
    }

    public void setAtendentesDisponiveis(Atendente atendentesDisponiveis) {
        this.atendentesDisponiveis.add(atendentesDisponiveis);
    }

    public List<Solicitacao> getSolicitacaosAndamento() {
        return solicitacaosAndamento;
    }

    public void setSolicitacaosAndamento(Solicitacao solicitacaosAndamento) {
        this.solicitacaosAndamento.add(solicitacaosAndamento);
    }

    public List<Solicitacao> getSolicitacaosEspera() {
        return solicitacaosEspera;
    }

    public void setSolicitacaosEspera(Solicitacao solicitacaosEspera) {
        this.solicitacaosEspera.add(solicitacaosEspera);
    }

    public static void carregaAplicacao(){
        //CARTÕES, EMPRÉSTIMOS, OUTROS_ASSUNTOS
        Time timeCartao = new Time(new Categoria("CARTÕES", "CARTÕES"));
        Time timeEmprestimo = new Time(new Categoria("EMPRÉSTIMOS", "EMPRÉSTIMOS"));
        Time timeOutro = new Time(new Categoria("OUTROS_ASSUNTOS", "OUTROS_ASSUNTOS"));

        Atendente a1 = new Atendente("fulanoCartao1", timeCartao, 0);
        Atendente a2 = new Atendente("fulanoCartao2", timeCartao, 0);
        Atendente a3 = new Atendente("fulanoCartao3", timeCartao, 0);

        Atendente a4 = new Atendente("fulanoEmprestimo1", timeEmprestimo, 0);
        Atendente a5 = new Atendente("fulanoEmprestimo2", timeEmprestimo, 0);

        Atendente a6 = new Atendente("fulanoOutros1", timeOutro, 0);

        atendentesDisponiveis.add(a1);
        atendentesDisponiveis.add(a2);
        atendentesDisponiveis.add(a3);

        atendentesDisponiveis.add(a4);
        atendentesDisponiveis.add(a5);

        atendentesDisponiveis.add(a6);
    }

    public static Solicitacao verificaDisponibilidade(Solicitacao solicitacao) {
        int limiteAtendimentos = 3;
        
        Optional<Atendente> at = atendentesDisponiveis.stream()
                .filter(atendente -> atendente.getTime().getCategoria().getNome()
                    .equalsIgnoreCase(solicitacao.getTipo().toString()))
                .filter(atendente -> atendente.getAtendimentos() < limiteAtendimentos)
                .findFirst();
        
        numeroSolicitacao++;
    
        solicitacao.setNumero(numeroSolicitacao);
        if (at.isPresent()) {
            Atendente atendente = at.get();
            atendente.setAtendimentos(atendente.getAtendimentos() + 1);
            solicitacao.setAtendente(atendente);
            solicitacaosAndamento.add(solicitacao);
            if(atendente.getAtendimentos() == 3){
                atendentesIndisponiveis.add(atendente);
                atendentesDisponiveis.remove(atendente);
            }else{
                atendentesDisponiveis.set(atendentesDisponiveis.indexOf(atendente), atendente);
            }
            return solicitacao;
        } else {
            solicitacaosEspera.add(solicitacao);
            return solicitacao;
        }
    }
    

}
