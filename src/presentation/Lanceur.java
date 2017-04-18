package presentation;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import service.IService;
import service.ServiceImpl;

public class Lanceur {

	public static void main(String[] args) {
		// 1- Chargement du conteneur
		WeldContainer weld = new Weld().initialize();

		// 2- Récupération du service
		IService service = weld.instance().select(ServiceImpl.class).get();

		// 3- Appel de la méthode à exécuter
		String resultat = service.appelDao();
		System.out.println(resultat);

		// 4- Destruction des objets
		weld.instance().destroy(service);
	}

}
