package br.com.matheus.financas.util;

import br.com.matheus.financas.modelo.Categoria;
import br.com.matheus.financas.modelo.Conta;
import br.com.matheus.financas.modelo.Movimentacao;
import br.com.matheus.financas.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class PopulaTesteJPQL {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setId(1);

        Categoria categoria = new Categoria("viagem");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Viagem para SP");
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("100.00"));
        movimentacao.setCategoria(Arrays.asList(categoria));
        movimentacao.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        em.persist(categoria);
        em.persist(movimentacao);

        em.getTransaction().commit();
        em.close();

    }

}
