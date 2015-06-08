
package backing;
import entity.Usuarios;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BackingBean {
    EntityManagerFactory emf;
    EntityManager em;
    
    public BackingBean() {
        emf=Persistence.createEntityManagerFactory("EjemplosPU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
    }
    public boolean validarUsuario(String nickName, String pass){
        try{
        Usuarios myUser= em.createNamedQuery("Usuarios.findByNombres", Usuarios.class).setParameter("username",nickName).setParameter("pass",pass).getSingleResult();
        if(myUser!=null){
        return true;
        }
        }catch(Exception e){
        return false;
        }
    return false;
    }
   }
