package br.com.matheus.financas.teste;

import br.com.matheus.financas.modelo.Cliente;
import br.com.matheus.financas.modelo.Conta;
import br.com.matheus.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteContaCliente {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Daniel");
        cliente.setEndereco("Rua 10");
        cliente.setProfissao("Desenvolvedor Jr");

        Conta conta = new Conta();
        conta.setId(2);

        cliente.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(cliente);

        em.getTransaction().commit();
        em.close();


    }
}
