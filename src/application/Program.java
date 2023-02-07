package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Adress;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String departmentName = sc.next();
		System.out.print("Dia de pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Phone: ");
		String phone = sc.next();
		Department dep = new Department(departmentName, payDay, new Adress(email, phone));
		System.out.print("Quantos funcionários tem o departamento? ");
		int quantityDep = sc.nextInt();
		for (int i=0; i<quantityDep; i++) {
			System.out.println("Dados do funcionário " + (1+i) + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			dep.addEmployee(new Employee(name, salary));
		}
		
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO:");
		showReport(dep);
		sc.close();
	}
	public static void showReport(Department dep) {
		System.out.println("Departamento " + dep.getName() + " = R$ " + String.format("%.2f", dep.payRoll()));
		System.out.println("Pagamento realizado no dia " + dep.getPayDay());
		for (Employee emp : dep.getEmployees()) {
			System.out.println(emp.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + dep.getAdress().getEmail());
	}
}
