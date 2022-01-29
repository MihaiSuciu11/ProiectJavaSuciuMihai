import javax.swing.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.io.File;

enum LOAD_TYPE {
	HARDCODAT, KEYBOARD, FILE
}

enum DISPLAY_TYPE  {
	CONSOLA, FISIER, GUI
}

public class TestClass {
	public static void main(String[] args) {
		Set<Student> studenti = new HashSet<Student>();
		studenti.add(new Student("Andrei", "Dragomir", 3987));
		studenti.add(new Student("Ruxandra", "Danciu", 3590));
		studenti.add(new Student("Alex", "Gaurila", 4777));
		studenti.add(new Student("Grigore", "Dima", 9648));
		studenti.add(new Student("Vlad", "Pascu", 9648));
		studenti.add(new Student("Suciu", "Mihai", 9648));

		Student studentu1 = new Student("Suciu", "Mihai", 9648);
		Student studentu2 = new Student("Ruxandra", "Danciu", 3590);;
		Student studentu3 = new Student("Alex", "Gaurila", 4777);
		Student studentu4 = new Student("Grigore", "Dima", 9648);
		Student studentu5 = new Student("Vlad", "Pascu", 9648);
		Student studentu6 = new Student("Andrei", "Dragomir", 3987);

		//definire profesor
		Profesor prof = new Profesor("Panaitescu","Anton");
		Profesor profpj = new Profesor("Angel", "Cataron");
		Profesor profss = new Profesor("Serban", "Oprisescu");
		Profesor profde = new Profesor("Pana", "Gheorghe");
		Profesor profeng = new Profesor("Sasu", "Elena");

		//definire curs nou
		Curs curs = new Curs("Rezistenta Materialelor", "RM", prof, studenti);
		Curs curspj = new Curs("Programare Java", "PJ", profpj, studenti);
		Curs cursss = new Curs("Sisteme si Semnale", "SS", profss, studenti);
		Curs cursde = new Curs("Dispozitive Electronice", "DE", profde, studenti);
		Curs cursengleza = new Curs("Engleza", "Eng", profeng, studenti);

		//studenti la cursuri

		curs.AddStudent(studentu1);
		cursde.AddStudent(studentu1);
		curspj.AddStudent(studentu1);
		cursss.AddStudent(studentu1);
		cursengleza.AddStudent(studentu1);
		/*
		curs.AddStudent(studentu2);
		cursde.AddStudent(studentu2);
		curspj.AddStudent(studentu2);
		cursss.AddStudent(studentu2);
		cursengleza.AddStudent(studentu2);

		curs.AddStudent(studentu3);
		cursde.AddStudent(studentu3);
		curspj.AddStudent(studentu3);
		cursss.AddStudent(studentu3);
		cursengleza.AddStudent(studentu3);

		curs.AddStudent(studentu4);
		cursde.AddStudent(studentu4);
		curspj.AddStudent(studentu4);
		cursss.AddStudent(studentu4);
		cursengleza.AddStudent(studentu4);

		curs.AddStudent(studentu5);
		cursde.AddStudent(studentu5);
		curspj.AddStudent(studentu5);
		cursss.AddStudent(studentu5);
		cursengleza.AddStudent(studentu5);

		curs.AddStudent(studentu6);
		cursde.AddStudent(studentu6);
		curspj.AddStudent(studentu6);
		cursss.AddStudent(studentu6);
		cursengleza.AddStudent(studentu6);
		*/
		//note

		curs.AddNota("Suciu", "Mihai", 8);
		cursde.AddNota("Suciu", "Mihai", 7);
		curspj.AddNota("Suciu", "Mihai", 5);
		cursss.AddNota("Suciu", "Mihai", 6);
		cursengleza.AddNota("Suciu", "Mihai", 4);
		/*
		curs.AddNota("Andrei", "Dragomir", 5);
		cursde.AddNota("Andrei", "Dragomir", 6);
		curspj.AddNota("Andrei", "Dragomir", 7);
		cursss.AddNota("Andrei", "Dragomir", 8);
		cursengleza.AddNota("Andrei", "Dragomir", 9);

		curs.AddNota("Ruxandra", "Danciu", 10);
		cursde.AddNota("Ruxandra", "Danciu", 9);
		curspj.AddNota("Ruxandra", "Danciu", 4);
		cursss.AddNota("Ruxandra", "Danciu", 5);
		cursengleza.AddNota("Ruxandra", "Danciu", 6);

		curs.AddNota("Grigore", "Dima", 8);
		cursde.AddNota("Grigore", "Dima", 7);
		curspj.AddNota("Grigore", "Dima", 8);
		cursss.AddNota("Grigore", "Dima", 9);
		cursengleza.AddNota("Grigore", "Dima", 10);

		curs.AddNota("Vlad", "Pascu", 6);
		cursde.AddNota("Vlad", "Pascu", 6);
		curspj.AddNota("Vlad", "Pascu", 5);
		cursss.AddNota("Vlad", "Pascu", 6);
		cursengleza.AddNota("Vlad", "Pascu", 6);

		curs.AddNota("Alex", "Gaurila", 8);
		cursde.AddNota("Alex", "Gaurila", 8);
		curspj.AddNota("Alex", "Gaurila", 9);
		cursss.AddNota("Alex", "Gaurila", 10);
		cursengleza.AddNota("Alex", "Gaurila", 10);
		*/

		ManagerCursuri cursuri = new ManagerCursuri();
		cursuri.AddCurs(curs);
		cursuri.AddCurs(curspj);
		cursuri.AddCurs(cursss);
		cursuri.AddCurs(cursde);
		cursuri.AddCurs(cursengleza);

		JFrame frame = new JFrame("Graphic user interface");
		LoginForm loginForm = new LoginForm(frame, cursuri);
		frame.setContentPane(loginForm.getMainPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		/*JFrame frame1 = new JFrame("Optiuni Profesor");
		LoginForm loginForm1 = new LoginForm(frame1);
		frame1.setContentPane(loginForm1.getMainPanel());
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.pack();*/

		/*Scanner sc = new Scanner(System.in);
		System.out.println("Username = ");
		var username = sc.next();
		System.out.println("Password = ");
		var password = sc.next();

		try {
			Application.getInstance().login(new User(username, password));
			System.out.println(Application.getInstance().currentUser);
			System.out.println(Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation());
			System.out.println(Application.getInstance().currentUser.menuStrategy.getAccountType());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
	}
}
