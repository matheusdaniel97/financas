package br.com.matheus.financas.teste;

import br.com.matheus.financas.modelo.Conta;
import br.com.matheus.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConta {

    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setTitular("Matheus Daniel");
        conta.setAgencia("123");
        conta.setBanco("nuBank");
        conta.setNumero("567");

        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();

        em.close();

    }

}
