package interceptor;

import java.util.Scanner;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Connected
public class Connector {

	@AroundInvoke
	public Object connect(InvocationContext context) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir le login :");
		String login = sc.next();
		System.out.println("Saisir le pass :");
		String pwd = sc.next();
		sc.close();

		if (login.equalsIgnoreCase("root") && pwd.equalsIgnoreCase("root")) {
			System.out.println("CONNECTE");
			return context.proceed();
		} else {
			System.out.println("ERREUR DE CONNEXION");
			return null;
		}
	}
}
