
package controlador;

import backing.BackingBean;
import entity.Usuarios;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.jboss.weld.context.http.HttpRequestContextImpl;
import org.primefaces.context.RequestContext;


@ManagedBean(name="loginControlador")
@RequestScoped
public class LoginControlador implements Serializable{
    private Usuarios user;
    private final BackingBean bbean= new BackingBean();
    private final HttpServletRequest hsr;
    private final FacesContext fcontext;
    private FacesMessage fmessage;

    /**
     * Creates a new instance of LoginControlador
     */
    public LoginControlador() {
        user= new Usuarios();
        fcontext=FacesContext.getCurrentInstance();
        hsr=(HttpServletRequest)fcontext.getExternalContext().getRequest();
    } 
    
    public String validarUsusario(){
        //ojo user getdocumentoPK
    if(bbean.validarUsuario(user.getNombres(),user.getContrasena())){
    hsr.getSession().setAttribute("userLogueado",user);
    return "pages/home.xhtml?faces-redirect=true";
    }
    RequestContext.getCurrentInstance().update("growl");
    FacesContext context= FacesContext.getCurrentInstance();
    context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","datos invalidos"));
    return "";
    }
    
    public Usuarios getUser(){
    return user;
    }
    public void setUser(){
    this.user=user;
    }
}
