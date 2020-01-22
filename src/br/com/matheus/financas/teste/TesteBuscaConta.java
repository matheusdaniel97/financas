package br.com.matheus.financas.teste;

import br.com.matheus.financas.modelo.Conta;
import br.com.matheus.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaConta {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);

        System.out.println(conta.getTitular());

        em.getTransaction().commit();
        em.close();

    }
}
