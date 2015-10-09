/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import deploy.DeploymentConfiguration;
import javax.persistence.Persistence;

/**
 *
 * @author Athinodoros
 */
public class Test
{

    public static void main(String[] args)
    {
        Persistence.generateSchema(DeploymentConfiguration.PU_NAME, null);
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        int deletedCount = em.createQuery("DELETE FROM InfoEntity").executeUpdate();
//        em.getTransaction().commit();
//        System.out.println(deletedCount);
    }
}
