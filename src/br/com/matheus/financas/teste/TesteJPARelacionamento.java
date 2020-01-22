package br.com.matheus.financas.teste;

import br.com.matheus.financas.modelo.Conta;
import br.com.matheus.financas.modelo.Movimentacao;
import br.com.matheus.financas.modelo.TipoMovimentacao;
import br.com.matheus.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TesteJPARelacionamento {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setAgencia("1122");
        conta.setBanco("237 - BANCO BRADESCO");
        conta.setNumero("3344");
        conta.setTitular("Juca da Silva");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("200.0"));

        movimentacao.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(conta);
        em.persist(movimentacao);

        em.getTransaction().commit();
        em.close();

    }

}
