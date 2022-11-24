package client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import presentation.BookPresentation;
import presentation.BookPresentationImpl;





public class BookClient {

	public static void main(String[] args) {
		
		Scanner src=new Scanner(System.in);

		AnnotationConfigApplicationContext springContainer = new AnnotationConfigApplicationContext(BookClientConfiguration.class);
//		BookPresentation bookPresentation=new BookPresentationImpl();
		
		BookPresentation bookPresentation = (BookPresentation)springContainer.getBean("presentation");
		
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=src.nextInt();
			bookPresentation.performMenu(choice);
		}

	}

}
