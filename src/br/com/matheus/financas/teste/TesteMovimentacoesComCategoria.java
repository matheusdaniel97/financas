package br.com.matheus.financas.teste;

import br.com.matheus.financas.modelo.Categoria;
import br.com.matheus.financas.modelo.Conta;
import br.com.matheus.financas.modelo.Movimentacao;
import br.com.matheus.financas.modelo.TipoMovimentacao;
import br.com.matheus.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class TesteMovimentacoesComCategoria {

    public static void main(String[] args) {

        Categoria categoria1 = new Categoria("Viagens");
        Categoria categoria2 = new Categoria("Negocios");

        Conta conta = new Conta();
        conta.setId(2);

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(Calendar.getInstance());
        movimentacao1.setDescricao("Viagem para São Paulo");
        movimentacao1.setTipo(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("100.00"));
        movimentacao1.setCategoria(Arrays.asList(categoria1,categoria2));
        movimentacao1.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(Calendar.getInstance());
        movimentacao2.setDescricao("Viagem para Sorocaba");
        movimentacao2.setTipo(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("50.00"));
        movimentacao2.setCategoria(Arrays.asList(categoria1,categoria2));
        movimentacao2.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(categoria1);
        em.persist(categoria2);
        em.persist(movimentacao1);
        em.persist(movimentacao2);

        em.getTransaction().commit();
        em.close();

    }

}
