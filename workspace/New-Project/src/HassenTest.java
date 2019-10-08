
import java.util.Arrays;
import java.util.List;


public class HassenTest {

	public static void main(String[] args){
	List<Personne> people =Arrays.asList(
			new Personne("hassen", "ben slima", 25),
			new Personne("karim", "derbel", 26),
			new Personne("Mohamed", "Kacim", 30)
			);
	System.out.println("----Filter----");
	people.stream().
	filter(p->p.getLastName().startsWith("b")).
	forEach(p->System.out.println(p.getFirstName()));
	//do the same as stream
	Long count=people.parallelStream().
	filter(p->p.getLastName().startsWith("b")).
	count();
	System.out.println(count);
	System.out.println("----Map----");
	
	System.out.println("Non-Lamda: ");
	for(Personne p:people){
		System.out.println("# "+p.getAge());
	}
	System.out.println("\nLamda: ");
	people.stream().map(x->x.getAge()).forEach(x->System.out.println("# "+x));	


}
}
