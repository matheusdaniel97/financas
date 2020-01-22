package br.com.matheus.financas.teste;

import br.com.matheus.financas.modelo.Conta;
import br.com.matheus.financas.modelo.Movimentacao;
import br.com.matheus.financas.modelo.TipoMovimentacao;
import br.com.matheus.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteJPQL {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(1);

        String jpql = "select m from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo order by m.valor desc";
        Query query = em.createQuery(jpql);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

        List <Movimentacao> resultado = query.getResultList();

        for (Movimentacao movimentacao : resultado
             ) {
            System.out.println("Descricao: " + movimentacao.getDescricao());
            System.out.println("Valor: " + movimentacao.getValor());
        }

        em.getTransaction().commit();
        em.close();

    }
}
