package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.ResponsabileEnteManager;
import theboys.sorrentomarina.managers.TableResponsabileEnteManager;
import theboys.sorrentomarina.models.ResponsabileEnte;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

public class CheckLoginRespEnte extends ChainableAction {

  /**
   * Controlla le credenziali passate e ritorna la dashboard con l'admin loggato
   * o avvisa che le credenziali non sono corrette
   *
   * @param request la request
   * @param response la response
   * @return ritorna la dashboard con l'admin loggato o la pagina di login
   * @author Francesco Pio Covino
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      ResponsabileEnteManager em = new TableResponsabileEnteManager(this.getSource(request));
      Optional<ResponsabileEnte> opt = em.findResponsabileEnte(username, password);
      if (opt.isPresent()) {
        request.getSession().setAttribute("utente", opt.get());
        return view("admin/index");
      }
    } catch (SQLException ex) {
      return view("500");
    }
    request.setAttribute("messagge", "Credenziali non corrette! Riprova.");
    setNext(new MostraFormLoginAction());
    return super.execute(request, response);
  }
}