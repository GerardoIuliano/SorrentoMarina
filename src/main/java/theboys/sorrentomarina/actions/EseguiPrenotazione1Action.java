package theboys.sorrentomarina.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EseguiPrenotazione1Action  implements Action{
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    try{
      return view("prenotazione2");
    }catch(Exception e){
      e.printStackTrace();
      return view("500");
    }
  }
}
