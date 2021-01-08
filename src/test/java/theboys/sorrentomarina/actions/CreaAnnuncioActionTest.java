package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import theboys.sorrentomarina.managers.AnnuncioManager;
import theboys.sorrentomarina.managers.TableAnnuncioManager;
import theboys.sorrentomarina.models.Annuncio;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.ResponsabileLido;
import theboys.sorrentomarina.models.Turista;

import javax.servlet.ServletContext;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class CreaAnnuncioActionTest extends ActionSetupDB{

  private CreaAnnuncioAction action;
  /**
   * Test nel caso i dati siano inseriti correttamente e viene aggiunto
   * un nuovo annuncio
   */
  @Test
  public void CreaAnnunciotestExecuteSuccess(){
    Mockito.when(mockReq.getParameter("titolo")).thenReturn("Prova titolo");
    Mockito.when(mockReq.getParameter("foto")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("contenuto")).thenReturn("contenuto dell'annuncio");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido(1,"", "a", "", "", "",1));

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    action = new CreaAnnuncioAction();
    String page = this.action.execute(mockReq, mockRes);
    AnnuncioManager am = new TableAnnuncioManager(mockConnection);
    Annuncio a = null;
    try {
      a = am.retriveById(5);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    assertNotNull(a);
    assertEquals("redirect:/SorrentoMarina/dashboard", page);
  }

  /**
   * Test nel caso i dati non siano inseriti correttamente e non
   * viene aggiunto l'annuncio
   */
  @Test
  public void CreaAnnunciotestExecuteFailure(){
    Mockito.when(mockReq.getParameter("titolo")).thenReturn("Prova titolo");
    Mockito.when(mockReq.getParameter("foto")).thenReturn("foto");
    Mockito.when(mockReq.getParameter("contenuto")).thenReturn("contenuto dell'annuncio");

    Mockito.when(mockReq.getSession()).thenReturn(mockSession);
    Mockito.when(mockReq.getSession().getAttribute("adminLido")).thenReturn(new ResponsabileLido());

    ServletContext ctx = Mockito.mock(ServletContext.class);
    Mockito.when(ctx.getAttribute("db")).thenReturn(mockConnection);
    Mockito.when(mockReq.getServletContext()).thenReturn(ctx);
    action = new CreaAnnuncioAction();
    String page = this.action.execute(mockReq, mockRes);
    AnnuncioManager am = new TableAnnuncioManager(mockConnection);
    Annuncio a = null;
    try {
      a = am.retriveById(6);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    assertNull(a);
    assertEquals("/WEB-INF/views/500.jsp", page);
  }
}